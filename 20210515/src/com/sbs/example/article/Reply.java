package com.sbs.example.article;

public class Reply {

	private int id;
	private String body;
	private int articleId;
	private int memberId;	
	
	public Reply(int id, String body, int articleId, int memberId) {
		super();
		this.id = id;
		this.body = body;
		this.articleId = articleId;
		this.memberId = memberId;
	}
	
	public Reply() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
