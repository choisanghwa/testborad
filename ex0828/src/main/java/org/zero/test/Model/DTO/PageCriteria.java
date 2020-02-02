package org.zero.test.Model.DTO;

public class PageCriteria {
	private int page;
	private int perPageNum;
	
	
	
	
	
	
	public PageCriteria() {
		this.page = 1;
		this.perPageNum =10;
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
	
		this.page = page;
	}

	public int getPerPageNum() {
		
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum >100){
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	//method for mybatis SQL Mapper
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	
	//SearchCriteria [searchType=" +searchType +", "+"keyword="+ keyword +"]";
	@Override
	public String toString() {
		//return "PageCriteria [Page="+page+", "+ "perPageNum"+perPageNum+"]";
		return "PageCriteria [Page="+page+", "+ "perPageNum="+perPageNum+", "+"searchType="+searchType+", "+"keyword="+ keyword+"]";
	}
	
	
	
}
