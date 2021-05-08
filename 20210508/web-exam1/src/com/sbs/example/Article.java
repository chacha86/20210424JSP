package com.sbs.example;

public class Article {
	private int id;
	private String title;
	private String body;
	private int boardId;
	private int memberId;
	private String writer; 
	private String passwd;
	private String regDate;
	private int hit;
	
	public Article(int id, String title, String body, int boardId, int memberId, String writer, String passwd, String regDate, int hit) {
		super();
		this.regDate = regDate;
		this.id = id;
		this.title = title;
		this.body = body;
		this.boardId = boardId;
		this.memberId = memberId;
		this.writer = writer;
		this.passwd = passwd;
		this.hit = hit;
	}
	
	public Article() {}
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
