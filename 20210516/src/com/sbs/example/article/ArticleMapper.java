package com.sbs.example.article;

import java.util.ArrayList;

public interface ArticleMapper {

	public ArrayList<Article> getArticles();
	public void insertArticle(Article article);
	public Article getArticleById(int id);
	public void deleteArticleById(int id);
	public void updateArticle(Article article);
	public ArrayList<Reply> getRepliesByArticleId(int articleId);
	public void insertReply(Reply reply);
}
