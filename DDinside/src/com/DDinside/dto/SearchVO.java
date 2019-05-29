package com.DDinside.dto;

public class SearchVO {
	private String keyWord;
	
	public SearchVO() {}

	public SearchVO(String keyWord) {
		super();
		this.keyWord = keyWord;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return "SearchVO [keyWord=" + keyWord + "]";
	}
	
	
}
