package com.sbs.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
	abstract public String doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;

}
