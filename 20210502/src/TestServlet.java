package com.sbs.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private ArticleDao dao;
	
	public TestServlet() throws IOException {		
		 dao = new ArticleDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "default";
		}
		
		if(action.equals("addForm")) {
		
			forward(request, response, "addForm");
			
		} else if(action.equals("doAdd")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			System.out.println(title);
			System.out.println(body);
			System.out.println("데이터를 저장합니다.");
			
			// 재요청 -> redirect
			response.sendRedirect("TestServlet?action=list");
			
		} else if(action.equals("default") || action.equals("list")) {
			
			ArrayList<Article> articles = dao.getArticles();
			
			request.setAttribute("articles", articles);

			forward(request, response, "list");
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
