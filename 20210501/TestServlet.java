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
		
		ArrayList<Article> articles = new ArrayList<>();
		Article a1 = new Article("제목1", "내용1");
		Article a2 = new Article("제목2", "내용2");
		Article a3 = new Article("제목3", "내용3");
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
		request.setAttribute("articles", articles);
						
		RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/list.jsp");
		rd.forward(request, response);
	}


}
