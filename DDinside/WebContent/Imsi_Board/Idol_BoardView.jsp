<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="javax.naming.*"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file ="../header.jsp" %>

	<!-- css files -->
    <link href="../css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="../css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="../css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->
	
	<!-- google fonts -->
	<link href="//fonts.googleapis.com/css?family=Cabin:400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext,vietnamese" rel="stylesheet">
	<!-- //google fonts -->

<c:set var="board_id" value="Idol"/>

<div class="container toppadding">

<div class="col-md-12">
	<h2 class="text-center p8060">${boardView.title } </h2>
</div>
		
	<div class="toppadding011 font-white">
		<a class="form-control04 btn-primary"role="button">조회수</a>
		<a class="form-control04 btn-primary"role="button">작성자</a>
		<a class="form-control04 btn-primary"role="button">작성일</a>
	</div>

				<div class="form-group toppadding0">					
					<label class="form-control04">${readcount }</label>
					<label class="form-control04">${boardView.name }  </label>
					<label class="form-control04">${boardView.writedate }  </label>
				</div>
								
				<div class="form-group">		
					<label class="form-control03 img_size">
					<img src="upload/${boardView.item }"><br>
					${boardView.content }  </label>
				</div>
				
				<div>			
					<input type="hidden" name="name" value="${loginUser.name }">
				</div>			
							
		<div class="text-right">
			<c:if test="${loginUser.id eq writer or Admin ne null}" >
				<a class="btn btn-primary submit mt-2" href="controller?command=${board_id}_PostEdit&num=${boardView.num}" role="button">수정</a>
				<a class="btn btn-primary submit mt-2" href="controller?command=${board_id}_BoardDelete&num=${boardView.num}" role="button">삭제</a>
				<a class="btn btn-primary submit mt-2" href="controller?command=${board_id}_BoardList" role="button">목록</a>
			</c:if>		
			<c:if test="${loginUser.id ne writer and Admin eq null}" >		
				<a class="btn btn-primary submit mt-2" href="controller?command=${board_id}_BoardList" role="button">목록</a>	
			</c:if>	
			<a class="btn btn-primary submit mt-2" href="controller?command=${board_id}_PostReport&num=${boardView.num}" role="button">신고</a>				
		</div>
		
				<div class="text-center">
					<a class="btn btn-primary00 submit mt-2" href="controller?command=${board_id}_PostUp&num=${boardView.num}" role="button">개추&nbsp;+${PostCount.up }</a>
					<a class="btn btn-primary01 submit mt-2" href="controller?command=${board_id}_PostDown&num=${boardView.num}" role="button">비추&nbsp;${PostCount.down }</a>
					<a class="btn btn-primary02 submit mt-2" href="controller?command=${board_id}_PostAho&num=${boardView.num}" role="button">바보추&nbsp;+${PostCount.aho }</a>												
				</div>
		
		
		<div class="toppadding02">
		<table class="table table-hover">
			<thead>
			<tr>
				<th>작성자</th>
				<th>내용</th>
			</tr>
			</thead>
			<c:forEach var="comment" items="${comment }">
			<tr>	
				<td>${comment.writer_name } | <fmt:formatDate value="${comment.writedate }"/> |
				<c:if test="${loginUser.id eq comment.writer_id or Admin ne null}" >
					<a href="controller?command=${board_id}_CommentEdit&num=${comment.num}&board_num=${comment.board_num}" >수정</a>
					<a href="controller?command=${board_id}_CommentDelete&num=${comment.num}&board_num=${comment.board_num}" >삭제</a>
				</c:if>	
				 </td>
				<td>${comment.content }

				</td>	
			</tr>
			</c:forEach>
			</table>
		</div>
		
			
		<c:if test="${loginUser eq null}">
		</c:if>
		<c:if test="${loginUser ne null}">
			<hr>
			<form action="controller?command=${board_id}_BoardComment" method="post">
				<input type="hidden" name="num" value="${boardView.num}">
				<input type="hidden" name="title" value="${boardView.title}">
				<input type="hidden" name="id" value="${loginUser.id }">
				<input type="hidden" name="name" value="${loginUser.name }">
				<textarea class="comment" name="content"></textarea>
				<button type="submit" name="comment" class="btn01 btn-primary submit mt-2 text-right">댓글작성</button>
			</form>
		</c:if>

</div>
    
    <hr>
    
    
  
	
	
    <!--  게시판 리스트 -->

<div class="container toppadding">
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
<!-- 게시판 목록  -->

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
	
	<tobdy>
	<c:forEach var="boardlist" items="${boardList }">
	<tr>
		<td>${boardlist.num }</td>
		<td><a href="controller?command=${board_id}_BoardView&num=${boardlist.num}">${boardlist.title }</a></td>  
		<td>${boardlist.name }</td>
		<td><fmt:formatDate value="${boardlist.writedate }"/></td>
		<td>${boardlist.readcount }</td>
	</tr>
	</c:forEach>
	</tobdy>
	
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
	<c:choose>    
	     <c:when test="${page.page eq i}">
	     	<li class="page-item">
	     		 <a class="page-link">${i}</a> 
	      	</li>  
	     </c:when>
    	 <c:otherwise>
    		 <li class="page-item">
    	  		 <a class="page-link" href="controller?command=${board_id}_Page&page=${i}">${i}</a>
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
		<c:if test="${loginUser eq null}">
		</c:if>
		<c:if test="${loginUser ne null}">
			<a href="#popup33" class="btn btn-primary">글쓰기</a>
		</c:if>
  </div>
  
  
	<!-- 검색  -->
	<div id="searchbar toppadding01" class="">
		<form action="controller?command=${board_id}_Search" method="post">
				<div class="form-group">
					<input type="text" name="keyword" class="form-control05" id="password1">
					<button type="submit" class="btn01 btn-primary submit mt-2">검색</button>
				</div>
			</form>
	</div>
	<!-- 검색 끝 -->


</div>




<%@ include file ="../popup.jsp" %>
<%@ include file ="../footer.jsp" %>