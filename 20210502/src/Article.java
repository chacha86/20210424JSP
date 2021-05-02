package com.sbs.example;

public class Article {
	private String title;
	private String body;
	
	public Article(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}
	
	public Article() {
		super();
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
