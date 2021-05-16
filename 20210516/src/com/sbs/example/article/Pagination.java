package com.sbs.example.article;

public class Pagination {
	private int currentPageNo;
	private int articlesCntPerPage;
	private int startIndex;
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getStartIndex() {
		return  articlesCntPerPage * (currentPageNo - 1); 
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getArticlesCntPerPage() {
		return articlesCntPerPage;
	}

	public void setArticlesCntPerPage(int articlesCntPerPage) {
		this.articlesCntPerPage = articlesCntPerPage;
	}

}
