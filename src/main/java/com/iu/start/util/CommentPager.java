package com.iu.start.util;

public class CommentPager {
	private Long startRow;
	private Long lastRow;
	private Long bookNum;
	private Long page;
	private Long perPage;
	private Long totalPage;
	
	//전체 페이지 개수 계산
	public void makePage(Long totalCount)throws Exception{
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			this.totalPage++;
		}
	}
	
	
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage() - 1)*this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 0) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 5L;
		}
		return perPage;
	}	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
}
