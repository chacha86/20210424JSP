package com.sbs.example;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestServlet3")
public class TestServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("login")) {
			System.out.println("login 성공");
			
 			// 로그인 유지 -> 로그인 한 유저의 정보를 어딘가에 저장.
			// request에 저장
			request.setAttribute("loginedUser", "chacha");
			
			// ServletContext에 저장
			ServletContext application = request.getServletContext();
			application.setAttribute("loginedUser", "chacha");
			
			// Session에 저장
			HttpSession session = request.getSession();
			
			String loginId = request.getParameter("loginId");
			
			if(loginId.equals("hong")) {
				application.setAttribute("loginedUser", "hong");
				session.setAttribute("loginedUser", "hong");
				
			} else if(loginId.equals("chacha")) {
				application.setAttribute("loginedUser", "chacha");
				session.setAttribute("loginedUser", "chacha");
			}		
			
		} else if(action.equals("test")) {
			
//			ServletContext application = request.getServletContext();
//			String user = (String)application.getAttribute("loginedUser");
			
			HttpSession session = request.getSession();
			
			String user = (String)session.getAttribute("loginedUser");
	
			if(user.equals("hong")) {
				System.out.println("안녕하세요 홍길동님!!");
			} else if(user.equals("chacha")) {
				System.out.println("안녕하세요 차태진님!!");
			}
			
		}
		
	}
}
