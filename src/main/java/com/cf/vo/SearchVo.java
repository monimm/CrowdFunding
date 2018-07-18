package com.cf.vo;

public class SearchVo {
	private String keyWord;
	private String searchType;
	private String searchState;
	private String searchOrder;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchState() {
		return searchState;
	}

	public void setSearchState(String searchState) {
		this.searchState = searchState;
	}

	public String getSearchOrder() {
		return searchOrder;
	}

	public void setSearchOrder(String searchOrder) {
		this.searchOrder = searchOrder;
	}

	public String toString() {
		return "[keyWord:" + keyWord + ",searchType:" + searchType + ",searchState:" + searchState + ",searchOrder"
				+ searchOrder + "]";
	}

	
}
