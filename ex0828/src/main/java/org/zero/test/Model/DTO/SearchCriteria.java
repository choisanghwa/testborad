package org.zero.test.Model.DTO;

public class SearchCriteria extends PageCriteria{	
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
	
	
	@Override
	public String toString() {
		//PageCriteria [Page="+page+", "+ "perPageNum"+perPageNum+"]"
		return super.toString() + " SearchCriteria [searchType=" +searchType +", "+"keyword="+ keyword +"]";
		
	}
	
	
	
}
