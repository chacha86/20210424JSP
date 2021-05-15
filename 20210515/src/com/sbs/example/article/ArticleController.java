package com.sbs.example.article;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.example.Controller;

public class ArticleController extends Controller {
	private ArticleDao dao;

	public ArticleController() throws IOException {
		dao = new ArticleDao();
	}

	public void doService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = (String) request.getAttribute("action");
		
		if (action == null) {
			action = "default";
		}

		if (action.equals("addForm")) {

			forward(request, response, "article/addForm");

		} else if (action.equals("doAdd")) {
			doAdd(request, response);

		} else if (action.equals("detailForm")) {
			detailForm(request, response);

		} else if (action.equals("default") || action.equals("list.do")) {
			list(request, response);

		} else if (action.equals("doDelete")) {
			doDelete(request, response);

		} else if (action.equals("showUpdateForm")) {
			showUpdateForm(request, response);

		} else if (action.equals("doUpdate")) {
			doUpdate(request, response);
		}
	}
	
	
	
	

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setBody(body);

		dao.updateArticle(article);

		response.sendRedirect("TestServlet?action=detailForm&id=" + id);

	}

	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);

		request.setAttribute("article", article);
		forward(request, response, "article/updateForm");
	}

	private void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteArticleById(id);

		response.sendRedirect("TestServlet?action=list");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Article> articles = dao.getArticles();
		request.setAttribute("articles", articles);
		forward(request, response, "article/list");
	}

	private void detailForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);
		ArrayList<Reply> replies = dao.getRepliesByArticleId(id);

		request.setAttribute("article", article);
		request.setAttribute("replies", replies);

		forward(request, response, "article/detail");

	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		Article article = new Article();
		article.setTitle(title);
		article.setBody(body);

		dao.insertArticle(article);

		// 재요청 -> redirect
		response.sendRedirect("TestServlet?action=list");
	}
}
