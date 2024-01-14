package com.winter.app.util;

public class Pager {

	private Long startRow;
	private Long endRow;
	private Long perPage=10L;
	private Long page;
	
	private Long totalPage;
	private Long startNum;
	private Long endNum;
	
	private boolean start;
	private boolean end;
	
	private String search;
	private String kind;
	
	public void makeRow() {
		this.endRow = this.getPage()*this.getPerPage();
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
	}
	public void makeNum(Long totalCount) {
		//1.
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		this.setTotalPage(totalPage);
		//2.
		Long perBlock=5L;
		Long totalBlock=0L;
		totalBlock=this.getTotalPage()/perBlock;
		if(this.getTotalPage()%perBlock!=0) {
			totalBlock++;
		}
		//3.
		Long curBlock = 0L;
		curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		//4.
		Long endNum=curBlock*perBlock;
		Long startNum=endNum-perBlock+1;
		
		this.setEndNum(endNum);
		this.setStartNum(startNum);
		//5.
		if(curBlock==1) {
			this.setStart(true);
		}
		if(curBlock==totalBlock) {
			this.setEndNum(totalPage);
			this.setEnd(true);
		}
	}
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getEndRow() {
		return endRow;
	}
	public void setEndRow(Long endRow) {
		this.endRow = endRow;
	}
	public Long getPerPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getEndNum() {
		return endNum;
	}
	public void setEndNum(Long endNum) {
		this.endNum = endNum;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
}
