package com.sbs.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sbs.example.article.Article;
import com.sbs.example.article.ArticleDao;
import com.sbs.example.member.Member;
import com.sbs.example.member.MemberDao;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private ArticleDao dao;
	private MemberDao mdao;
	
	public TestServlet() throws IOException {		
		 dao = new ArticleDao();
		 mdao = new MemberDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "default";
		}
		
		if(action.equals("addForm")) {
		
			forward(request, response, "article/addForm");
			
		} else if(action.equals("doAdd")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			
			Article article = new Article();
			article.setTitle(title);
			article.setBody(body);
			
			dao.insertArticle(article);
			
			// 재요청 -> redirect
			response.sendRedirect("TestServlet?action=list");
			
		} else if(action.equals("detailForm") ) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Article article = dao.getArticleById(id);
			request.setAttribute("article", article);
			forward(request, response, "article/detail");
		}
		else if(action.equals("default") || action.equals("list")) {
			
			ArrayList<Article> articles = dao.getArticles();
			request.setAttribute("articles", articles);
			forward(request, response, "article/list");
			
		} 
		else if(action.equals("doDelete")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deleteArticleById(id);
			
			response.sendRedirect("TestServlet?action=list");
		}
		else if(action.equals("showUpdateForm")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Article article = dao.getArticleById(id);
			
			request.setAttribute("article", article);
			forward(request, response, "article/updateForm");
		}
		else if(action.equals("doUpdate")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			
			Article article = new Article();
			article.setId(id);
			article.setTitle(title);
			article.setBody(body);
			
			dao.updateArticle(article);
			
			response.sendRedirect("TestServlet?action=detailForm&id=" + id);
			
		}
		else if(action.equals("showLoginForm")) {
			forward(request, response, "member/loginForm");
		}
		else if(action.equals("doLogin")) {
			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			
			Member member = new Member();
			member.setLoginId(loginId);
			member.setLoginPw(loginPw);
			
			Member loginedMember = mdao.getMemberByLoginIdAndLoginPw(member);
			
			System.out.println(loginedMember);
			
			
			if(loginedMember == null) {
				//에러페이지
				forward(request, response, "error/loginFailed");
				
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("loginedMember", loginedMember);
				//request.setAttribute("loginedMember", loginedMember);
				response.sendRedirect("TestServlet?action=list");
			}		
		} 
		else if(action.equals("doLogout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("TestServlet?action=list");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String fname) throws ServletException, IOException {
		String path = "/WEB-INF/" + fname + ".jsp";
		RequestDispatcher rd =  request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
