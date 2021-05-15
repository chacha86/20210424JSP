package com.sbs.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
	abstract public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
	
	protected void forward(HttpServletRequest request, HttpServletResponse response, String fname)
			throws ServletException, IOException {
		String path = "/WEB-INF/" + fname + ".jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
