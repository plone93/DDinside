<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="javax.naming.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file ="../header.jsp" %>

<c:set var="board_id" value="Idol"/>

<!-- 게시판  -->
<div class="container toppadding">
	<h1>아이돌 게시판입니다</h1>

	<!-- 검색  -->
	<div id="searchbar toppadding01" class="">
		<form action="controller?command=${board_id}_Search" method="post">
				<div class="form-group">
					<input type="text" name="keyword" class="form-control05">
					<button type="submit" class="btn01 btn-primary submit mt-2">검색</button>
				</div>
			</form>
	</div>
	<!-- 검색 끝 -->


<table class="table table-hover">
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	</thead>
	
<!-- 공지사항게시판 목록   NoticeList  -->
	<div>
	<c:forEach var="NoticeList" items="${NoticeList }">
	<tr>
		<td>${NoticeList.num }</td>
		<td><a href="controller?command=Notice_BoardView&num=${NoticeList.num}">${NoticeList.title }</a></td>  
		<td>${NoticeList.name }</td>
		<td><fmt:formatDate value="${NoticeList.writedate }"/></td>
		<td>${NoticeList.readcount }</td>
	</tr>
	</c:forEach>
	</div>
	
<!-- 게시판 목록   NoticeList  -->	
	<div>
	<c:forEach var="boardlist" items="${boardList}" varStatus="status">
	<tr>
		<td>${listCount-status.index-((page.page-1)*page.displayRow)}</td>
		<td><a href="controller?command=${board_id}_BoardView&num=${boardlist.num}">${boardlist.title}</a></td>  
		<td>${boardlist.name}</td>
		<td><fmt:formatDate value="${boardlist.writedate}"/></td>
		<td>${boardlist.readcount}</td>
	</tr>
	</c:forEach>
	</div>
	
</table>

 <!-- Pagination -->

  <ul class="pagination justify-content-center">
  
	  <c:if test="${page.prev}">
	    <li class="page-item">
	      <a class="page-link" href="controller?command=${board_id}_Page&page=${page.beginPage-1}" aria-label="Previous">
	            <span aria-hidden="true">&laquo;</span>
	            <span class="sr-only">Previous</span>
	          </a>     
	    </li>
	  </c:if>

 <c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}" step="1">
 
  <c:set var="link" value="${board_id}_BoardList"/>   <!-- 커맨드 주소 -->
	<c:choose>    
	     <c:when test="${page.page eq i}">
	     	<li class="page-item">
	     		 <a class="page-link">${i}</a> 
	      	</li>  
	     </c:when>
    	 <c:otherwise>
    		 <li class="page-item">
    	  		 <a class="page-link" href="controller?command=${link }&page=${i}">${i}</a>
    	  	 </li>  
         </c:otherwise>
	</c:choose>
 </c:forEach>
    
  <c:if test="${page.next}">
    <li class="page-item">
      <a class="page-link" href="controller?command=${board_id}_Page&page=${page.beginPage+1}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
    </li>
  </c:if> 
  
  </ul> 
  
  
  <!-- 글쓰기 버튼 --> 
  <div class="col-md-12 text-right">
		<c:if test="${loginUser eq null or Admin eq null}">
		</c:if>
		<c:if test="${loginUser ne null or Admin ne null}">
			<a href="#IdolWrite" class="btn btn-primary">글쓰기</a>
		</c:if>
  </div>

</div>




<%@ include file ="../popup.jsp" %>
<%@ include file ="../footer.jsp" %>