package com.sbs.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.example.article.ArticleController;
import com.sbs.example.member.MemberController;

@WebServlet("*.do")
public class TestServlet extends HttpServlet {
	private Controller cont;

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
		
		cont.doService(request, response);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

