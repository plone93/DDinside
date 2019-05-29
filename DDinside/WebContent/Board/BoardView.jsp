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

<c:set var="board_id" value="${board_id}"/>

	<%
	String message = (String)request.getAttribute("message");
	%>
	<c:if test="${message ne null}">
		<script>
			alert("<%=message%>");
		</script>
	</c:if>
	

<div class="container toppadding">

<div class="col-md-12">
	<h2 class="text-center p8060">${boardView.title } </h2>
</div>
		
	<div class="toppadding011 font-white">
		<a class="form-control04 btn-primary"role="button">ビュー</a>
		<a class="form-control04 btn-primary"role="button">投稿者</a>
		<a class="form-control04 btn-primary"role="button">作成日</a>
	</div>

				<div class="form-group toppadding0">					
					<label class="form-control04">${readcount }</label>
					<label class="form-control04">${boardView.name }  </label>
					<label class="form-control04"><fmt:formatDate value="${boardView.writedate }"/></label>
				</div>
								
				<div class="form-group">		
					<label class="form-control03 img_size">
					<c:if test="${boardView.item ne null}">
					<img src="upload/${boardView.item }"><br>
					</c:if>
					${boardView.content }  
					</label>
				</div>
				
				<div>			
					<input type="hidden" name="name" value="${loginUser.name }">
				</div>			
							
		<div class="text-right">
			<c:if test="${loginUser.id eq writer or Admin ne null}" >
				<a class="btn btn-primary submit mt-2" href="controller?command=PostEdit&num=${boardView.num}&board_id=${board_id}" role="button">修正</a>
				<a class="btn btn-primary submit mt-2" href="controller?command=BoardDelete&num=${boardView.num}&board_id=${board_id}" role="button">削除</a>
				<a class="btn btn-primary submit mt-2" href="controller?command=BoardList&board_id=${board_id}" role="button">リスト</a>
			</c:if>		
			<c:if test="${loginUser.id ne writer and Admin eq null}" >		
				<a class="btn btn-primary submit mt-2" href="controller?command=BoardList&board_id=${board_id}" role="button">リスト</a>	
			</c:if>	
			<a class="btn btn-primary submit mt-2" href="controller?command=PostReport&num=${boardView.num}&board_id=${board_id}" role="button">申告</a>				
		</div>
		
				<div class="text-center">
					<a class="btn btn-primary00 submit mt-2" href="controller?command=PostUp&num=${boardView.num}&board_id=${board_id}" role="button">いいね&nbsp;+${PostCount.up }</a>
					<a class="btn btn-primary01 submit mt-2" href="controller?command=PostDown&num=${boardView.num}&board_id=${board_id}" role="button">くそ&nbsp;-${PostCount.down }</a>
					<a class="btn btn-primary02 submit mt-2" href="controller?command=PostAho&num=${boardView.num}&board_id=${board_id}" role="button">アホ&nbsp;+${PostCount.aho }</a>												
				</div>
		
		
		<div class="toppadding02">
		<table class="table table-hover">
			<thead>
			<tr>
				<th style="width:30%;">作成者</th>
				<th style="width:70%;">内容</th>
			</tr>
			</thead>
			<c:forEach var="comment" items="${comment }">
			<tr>	
				<td>${comment.writer_name } | <fmt:formatDate value="${comment.writedate }"/> |
				<c:if test="${loginUser.id eq comment.writer_id or Admin ne null}" >
					<a href="controller?command=CommentEdit&num=${comment.num}&board_num=${comment.board_num}&board_id=${board_id}" > 修正</a>
					<a href="controller?command=CommentDelete&num=${comment.num}&board_num=${comment.board_num}&board_id=${board_id}" >削除</a>
				</c:if>	
				 </td>
				<td style="text-align:left;">${comment.content }

				</td>	
			</tr>
			</c:forEach>
			</table>
		</div>
		

							
			<c:if test="${loginUser eq null}">
			</c:if>
			<c:if test="${loginUser ne null}">
				  	<!-- 검색  -->
			<div id="searchbar toppadding01" class="" style="padding:50px;"> 
				<form action="controller?command=BoardComment&board_id=${board_id}" method="post">
						<div class="form-group">
							<input type="text" name="content" class="form-control05">
							<input type="hidden" name="num" value="${boardView.num}">
							<input type="hidden" name="title" value="${boardView.title}">
							<input type="hidden" name="id" value="${loginUser.id }">
							<input type="hidden" name="name" value="${loginUser.name }">
							<button type="submit" class="btn01 btn-primary submit mt-2">作成</button>
						</div>
				</form>
			</div>
			<!-- 검색 끝 -->
				
			</c:if>
			
	
		

</div>

    
    <hr>
    



<%@ include file ="../popup.jsp" %>
<%@ include file ="../footer.jsp" %>