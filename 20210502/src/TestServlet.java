package com.sbs.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//dao 에서 게시물리스트를 가져온다. 
		
		System.out.println("servlet 실행");
		
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
			
			ArrayList<Article> articles = new ArrayList<>();
			Article a1 = new Article("제목1", "내용1");
			Article a2 = new Article("제목2", "내용2");
			Article a3 = new Article("제목3", "내용3");
			articles.add(a1);
			articles.add(a2);
			articles.add(a3);
			
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
