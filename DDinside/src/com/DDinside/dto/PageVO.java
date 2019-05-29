package com.DDinside.dto;

public class PageVO {
	private int page = 1; // 시작페이지   totalcount - ((page.page-1)*page.displayRow)
	private int totalCount; //테이블에 등록된 총 게시글 수
	private int beginPage; //시작 페이지
	private int endPage; //끝 페이지
	private int displayRow = 10; //한페이지에 보여질 게시글 수
	private int displayPage = 5; // 하단 목록에서 보여질 수 1~10, 11~20
	boolean prev; // 뒤로가기
	boolean next; // 앞으로 가기
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		paging();
	}
	
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	private void paging() {
		endPage = ((page+(displayPage-1))/displayPage)*displayPage;
					// ((1) / 9 = 1) * 10   // 1  ,    
		//endPage = ((int)Math.ceil(page/(double)displayPage))*displayPage;
		beginPage = endPage - (displayPage - 1);
		// 시작페이지 =  마지막페이지(10) - (페이지갯수 -1) = 1
		int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
		//  총 페이지 = (반올림) 총페이지 / 한페이지에 보여질 게시글 수, 291 / 10 = 29.1> 반올림하면 30
		if(totalPage < endPage) { //ex) 토탈35 < 끝페이지 (10 20 30 40)
			endPage = totalPage; // 끝페이지를  총페이지로 표시하고
			next = false;  // 다음 페이지 버튼을 비활성화
		} else {
			next = true;  // 아니면 활성화
		}
		//  prev = (beginPage==1)?false:true;//page가 11이상에만 나온다.
		if(beginPage == 1) {
			prev = false;
		} else {
			prev = true;
		}
	}
}
