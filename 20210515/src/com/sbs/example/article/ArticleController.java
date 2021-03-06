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

		if (action.equals("addForm.do")) {
			forward(request, response, "article/addForm");

		} else if (action.equals("add.do")) {
			add(request, response);

		} else if (action.equals("detailForm.do")) {
			detailForm(request, response);

		} else if (action.equals("default") || action.equals("list.do")) {
			list(request, response);

		} else if (action.equals("delete.do")) {
			delete(request, response);

		} else if (action.equals("showUpdateForm.do")) {
			showUpdateForm(request, response);

		} else if (action.equals("update.do")) {
			update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setBody(body);

		dao.updateArticle(article);

		response.sendRedirect("/article/detailForm.do?id=" + id);

	}

	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);

		request.setAttribute("article", article);
		forward(request, response, "article/updateForm");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteArticleById(id);

		response.sendRedirect("/article/list.do");
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

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		Article article = new Article();
		article.setTitle(title);
		article.setBody(body);

		dao.insertArticle(article);

		// ????????? -> redirect
		response.sendRedirect("/article/list.do");
	}
}
