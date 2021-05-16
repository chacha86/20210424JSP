package com.sbs.example.article;

public class Reply {

	private int id;
	private String body;
	private int articleId;
	private int memberId;
	private String nickname;
	private String regDate;
	
	public Reply(int id, String body, int articleId, int memberId, String nickname, String regDate) {
		super();
		this.regDate = regDate;
		this.id = id;
		this.nickname = nickname;
		this.body = body;
		this.articleId = articleId;
		this.memberId = memberId;
	}
	
	public Reply() {}
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

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
