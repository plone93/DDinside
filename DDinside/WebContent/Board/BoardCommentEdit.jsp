<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="javax.naming.*"%>

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
	<h2 class="text-center p8060">댓글 수정</h2>
	</div>
	
		<form action="controller?command=BoardCommentReWrite&board_id=${board_id}" method="post">
				<div class="form-group">
					<label class="mb-2">내용</label>
					<textarea name="content" class="form-control03">${commentEditView.content } </textarea>
				</div>
				
				<div>
					<input type="hidden" name="comment_num" value="${commentEditView.num }">			
					<input type="hidden" name="board_num" value="${board_num }">
					<input type="hidden" name="board_num" value="${commentEditView.board_id }">
				</div>		
							
				<button type="submit" class="btn00 btn-primary submit mt-2">수정완료</button>			
		</form>
</div>



<%@ include file ="../footer.jsp" %>