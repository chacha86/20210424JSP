package com.sbs.example;

import java.util.ArrayList;

public interface ArticleMapper {

	public ArrayList<Article> getArticles();
	public void insertArticle(Article article);
	public Article getArticleById(int id);
	public void deleteArticleById(int id);
	public void updateArticle(Article article);
}
