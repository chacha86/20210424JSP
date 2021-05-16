package com.sbs.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sbs.example.article.ArticleController;
import com.sbs.example.member.Member;
import com.sbs.example.member.MemberController;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private Controller cont;
	private Map<String, Integer> loginUrlMapper; 
	
	public FrontController() {
		loginUrlMapper = new HashMap<String, Integer>();
		loginUrlMapper.put("/article/addForm.do", 1);
		loginUrlMapper.put("/article/detailForm.do", 1);
		loginUrlMapper.put("/member/logout.do", 1);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 공통처리
		preHandle(request, response);
	
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
		
		if(postHandle(request, response)) {
			String view = cont.doService(request, response);	
			viewResolve(request, response, view);			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	// 요청이 들어오자마자 실행하는 코드
	void preHandle(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	}
	
	boolean postHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestUri = request.getRequestURI();
		if(loginUrlMapper.containsKey(requestUri)) {		
			
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("loginedMember");
			if(member == null) {
				request.setAttribute("errorMsg", "로그인이 필요한 기능입니다.");
				viewResolve(request, response, "error/error");
				return false;
			}
		}
		
		return true;
	}
	
	
	private void viewResolve(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException {
		
		if(view.substring(0, 2).equals("r:")) {
			response.sendRedirect(view.substring(2));
		} else {
			String path = "/WEB-INF/" + view + ".jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);			
		}
		
	}
}

