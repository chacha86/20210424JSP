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
import com.sbs.example.article.ArticleController;
import com.sbs.example.article.ArticleDao;
import com.sbs.example.article.Reply;
import com.sbs.example.member.Member;
import com.sbs.example.member.MemberController;
import com.sbs.example.member.MemberDao;

@WebServlet("*.do")
public class TestServlet extends HttpServlet {
	private ArticleDao dao;
	private Controller cont;
	
	
	public TestServlet() throws IOException {		
		 dao = new ArticleDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 공통처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	
		// 모듈 분석
		String url = request.getRequestURI();
		
		String[] urlBits = url.split("/");
		
		if(urlBits.length < 3) {
			System.out.println("잘못된 요청");
			return;
		}
		
		String module = urlBits[1];
		String action = urlBits[2];
		
		if(module.equals("article")) {
			cont = new ArticleController();
		} else if(module.equals("member")) {
			cont = new MemberController();
		}
		
		request.setAttribute("action", action);
		
		System.out.println("1 : " + action);
		
		cont.doService(request, response);

		
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

