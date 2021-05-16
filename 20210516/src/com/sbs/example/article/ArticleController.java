package com.sbs.example.article;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.example.Controller;

public class ArticleController extends Controller {
	private ArticleDao dao;

	public ArticleController() throws IOException {
		dao = new ArticleDao();
	}

	public String doService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = (String) request.getAttribute("action");
		String view = "";
		
		if (action == null) {
			action = "default";
		}

		if (action.equals("addForm.do")) {
			view = addForm(request, response);
			
		} else if (action.equals("add.do")) {
			view = add(request, response);

		} else if (action.equals("detailForm.do")) {
			view = detailForm(request, response);

		} else if (action.equals("default") || action.equals("list.do")) {
			view = list(request, response);

		} else if (action.equals("delete.do")) {
			view = delete(request, response);

		} else if (action.equals("showUpdateForm.do")) {
			view = showUpdateForm(request, response);

		} else if (action.equals("update.do")) {
			view = update(request, response);
			
		} else if(action.equals("addReply.do")) {
			view = addReply(request, response);

		} 
		
		return view;
	}

	private String addForm(HttpServletRequest request, HttpServletResponse response) {
		return "article/addForm";
	}

	private String addReply(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String rbody = request.getParameter("rbody");
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		
		Reply reply = new Reply();
		reply.setBody(rbody);
		reply.setArticleId(articleId);
		reply.setMemberId(memberId);
		
		dao.insertReply(reply);
		
		return "r:/article/detailForm.do?id="+articleId;
		
	}

	private String update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setBody(body);

		dao.updateArticle(article);

		return "r:/article/detailForm.do?id=" + id;

	}

	private String showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);

		request.setAttribute("article", article);
		return "article/updateForm";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteArticleById(id);

		return "r:/article/list.do";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 현재페이지 1 ->  5 * 0 = 0 
		// 현재페이지 2 ->  5 * 1 = 5
		// 현재페이지 3 ->  5 * 2 = 10
		// 현재페이지 4 ->  5 * 3 = 15
		// 현재페이지     5 * (현재페이지 - 1)
		int currentPageNo = 1;
		if(request.getParameter("currentPageNo") != null) {
			currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));			
		}
		
		int articlesCntPerPage = 5;
		//int index = articleCntPerPage * (currentPageNo - 1);
		
		Pagination pagination = new Pagination();
		pagination.setCurrentPageNo(currentPageNo);
		pagination.setArticlesCntPerPage(articlesCntPerPage);
		pagination.setStartIndex(pagination.getStartIndex());
		
		ArrayList<Article> articles = dao.getArticles(pagination);
		request.setAttribute("articles", articles);
		request.setAttribute("pagination", pagination);
		
		return "article/list";
	}

	private String detailForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
				
		Article article = dao.getArticleById(id);
		ArrayList<Reply> replies = dao.getRepliesByArticleId(id);

		request.setAttribute("article", article);
		request.setAttribute("replies", replies);

		// 댓글 수정 요청 여부
		request.setAttribute("rflag", request.getParameter("rflag"));
		request.setAttribute("rid", request.getParameter("rid"));
		
		return "article/detail";

	}

	private String add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		Article article = new Article();
		article.setTitle(title);
		article.setBody(body);

		dao.insertArticle(article);

		// 재요청 -> redirect
		return "r:/article/list.do";
	}
}
