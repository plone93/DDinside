<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="javax.naming.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file ="../header.jsp" %>

<c:set var="board_id" value="${board_id}"/>
	<%
	String message = (String)request.getAttribute("message");
	%>
	<c:if test="${message ne null}">
		<script>
			alert("<%=message%>");
		</script>
	</c:if>
	
<!-- 게시판  -->
<div class="container" style="padding:80px 0 0 0;">
	<h1 class="" style="text-align:center; padding:0 0 50px 0; color:#6a67ce;">${board_id } 掲示板</h1>



<h5 style="color:#6a67ce;">総 ${listCount }件のスレッド</h5>
<table class="table table-hover">
	<thead>
	<tr>
		<th style="width:10%;">番号</th>
		<th style="width:60%;">題目</th>
		<th style="width:10%;">投稿者</th>
		<th style="width:10%;">日付</th>
		<th style="width:10%;">ビュー</th>
	</tr>
	</thead>
	
<!-- 공지사항게시판 목록   NoticeList  -->
	<c:if test="${board_id eq 'お知らせ' or board_id eq '申告管理' }">
	</c:if>
	<c:if test="${board_id ne 'お知らせ' and board_id ne '申告管理' }">
		<c:forEach var="NoticeList" items="${NoticeList }" begin="0" step="1" end="3" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="controller?command=BoardView&num=${NoticeList.num}&board_id=${NoticeList.board_id }">${NoticeList.title }</a></td>  
				<td>${NoticeList.name }</td>
				<td><fmt:formatDate value="${NoticeList.writedate }"/></td>
				<td>${NoticeList.readcount }</td>
			</tr>
		</c:forEach>
	</c:if>
	
<!-- 게시판 목록   NoticeList  -->	
	
	<c:forEach var="boardlist" items="${boardList}" varStatus="status">
	<tr>
		<td>${listCount-status.index-((page.page-1)*page.displayRow)}</td>
		<td><a href="controller?command=BoardView&num=${boardlist.num}&board_id=${board_id}">${boardlist.title}</a>
		<span class="btn01 btn-primary submit">${boardlist.commentcount}</span></td>  
		<td>${boardlist.name}</td>
		<td><fmt:formatDate value="${boardlist.writedate}"/></td>
		<td>${boardlist.readcount}</td>
	</tr>
	</c:forEach>
	
	
	
</table>

 <!-- Pagination -->

  <ul class="pagination justify-content-center">
  
	  <c:if test="${page.prev}">
	    <li class="page-item">
	      <a class="page-link" href="controller?command=Page&page=${page.beginPage-1}&board_id=${board_id}" aria-label="Previous">
	            <span aria-hidden="true">&laquo;</span>
	            <span class="sr-only">Previous</span>
	          </a>     
	    </li>
	  </c:if>

 <c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}" step="1">
	<c:choose>    
	     <c:when test="${page.page eq i}">
	     	<li class="page-item">
	     		 <a class="page-link">${i}</a> 
	      	</li>  
	     </c:when>
    	 <c:otherwise>
    		 <li class="page-item">
    	  		 <a class="page-link" href="controller?command=BoardList&page=${i}&board_id=${board_id}">${i}</a>
    	  	 </li>  
         </c:otherwise>
	</c:choose>
 </c:forEach>
    
  <c:if test="${page.next}">
    <li class="page-item">
      <a class="page-link" href="controller?command=Page&page=${page.beginPage+1}&board_id=${board_id}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
    </li>
  </c:if> 
  
  </ul> 
  
  
  <!-- 글쓰기 버튼 --> 
  <div class="col-md-12 text-right">
  	<c:if test="${board_id ne '高評価' and board_id ne '低評価'  and board_id ne 'アホ'}">
		<c:if test="${loginUser eq null or Admin eq null}">
		</c:if>
		<c:if test="${loginUser ne null or Admin ne null}">
			<c:if test="${board_id eq 'お知らせ' }">
				<c:if test="${Admin ne null }">
					<a href="#BoardWrite" class="btn btn-primary">投稿</a>
				</c:if>
			</c:if>
			<c:if test="${board_id ne 'お知らせ' }">
				<a href="#BoardWrite" class="btn btn-primary">投稿</a>
			</c:if>
		</c:if>
	</c:if>	
  </div>
  
  	<!-- 검색  -->
	<div id="searchbar toppadding01" class="" style="padding:50px;"> 
		<form action="controller?command=Search&board_id=${board_id}" method="post">
				<div class="form-group">
					<input type="text" name="keyword" class="form-control05">
					<button type="submit" class="btn01 btn-primary submit mt-2">検索</button>
				</div>
			</form>
	</div>
	<!-- 검색 끝 -->

</div>





<%@ include file ="../popup.jsp" %>
<%@ include file ="../footer.jsp" %>