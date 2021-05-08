package com.sbs.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ArticleDao {
	SqlSessionFactory sqlSessionFactory;

	public ArticleDao() throws IOException {
		// 경로
		String resource = "com/sbs/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		System.out.println(sqlSessionFactory);
	}

	public ArrayList<Article> getArticles() {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		ArrayList<Article> articles = mapper.getArticles();			
		
		return articles;
	}
	
	public void insertArticle(Article article) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		mapper.insertArticle(article);
		session.commit();
	}

	public Article getArticleById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.getArticleById(id);
	}

	public void deleteArticleById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		mapper.deleteArticleById(id);
		session.commit();
	}

	public void updateArticle(Article article) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		mapper.updateArticle(article);
		session.commit();	
	}
}
