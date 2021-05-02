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
}
