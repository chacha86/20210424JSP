package com.sbs.example.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sbs.example.Controller;

public class MemberController extends Controller {
	private MemberDao mdao;
	
	public MemberController() throws IOException {
		mdao = new MemberDao();
	}
	
	public String doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String)request.getAttribute("action");
		String view = "";

		if (action == null) {
			action = "default";
		}

		if (action.equals("showLoginForm.do")) {
			view = showLoginForm(request, response);
			
		} else if (action.equals("login.do")) {
			view = login(request, response);
			
		} else if (action.equals("logout.do")) {
			view = logout(request, response);
		}
		
		return view;
	}

	
	private String showLoginForm(HttpServletRequest request, HttpServletResponse response) {
		return "member/loginForm";
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		return "r:/article/list.do";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");

		Member member = new Member();
		member.setLoginId(loginId);
		member.setLoginPw(loginPw);

		Member loginedMember = mdao.getMemberByLoginIdAndLoginPw(member);

		System.out.println(loginedMember);

		if (loginedMember == null) {
			// 에러페이지
			request.setAttribute("errorMsg", "회원정보가 일치하지 않습니다.");
			return "error/error";

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginedMember", loginedMember);
			// request.setAttribute("loginedMember", loginedMember);
			return "r:/article/list.do";
		}
	}	
}
