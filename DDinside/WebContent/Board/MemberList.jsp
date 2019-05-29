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



<h5 style="color:#6a67ce;">総 ${listCount }件のアカウントが検索されました。</h5>
<table class="table table-hover">
	<thead>
	<tr>
		<th>番号</th>
		<th>ID</th>
		<th>パスワード</th>
		<th>お名前</th>
		<th>メール</th>
		<th>加入日</th>
		<th>アカウント削除</th>
	</tr>
	</thead>
	
	
<!-- 게시판 목록   NoticeList  -->	
	
	<c:forEach var="MemberList" items="${memberList}" varStatus="status">
	<tr>
		<td>${MemberList.num}</td>
		<td>${MemberList.id}</td>
		<td>${MemberList.pass}</td>
		<td>${MemberList.name}</td>
		<td>${MemberList.email}</td>      
		<td><fmt:formatDate value="${MemberList.joindate}"/></td>
		<td><a href="controller?command=MemberDelete&num=${MemberList.num }&board_id=${board_id}">削除</a></td>    
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