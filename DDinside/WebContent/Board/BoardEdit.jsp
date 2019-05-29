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
	<h2 class="text-center p8060">スレッド更新</h2>
	</div>
	
		<form action="controller?command=BoardReWrite&board_id=${board_id}" method="post" enctype="multipart/form-data" name="boardCheck" onsubmit="return boardCheck()">
	
				<div class="form-group">
					<label class="mb-2">題目</label>
					<input type="text" name="title" class="form-control01" value="${BoardEditView.title }">
				</div>
				
<%-- 				<div class="form-group">
					<label class="mb-2">비밀번호</label>
					<input type="password" name="pass" class="form-control02" id="password1" value="${BoardEditView.pass }">
				</div> --%>
					
				<div class="form-group">
					<label class="mb-2">内容</label>
					<textarea name="content" class="form-control03">${BoardEditView.content } </textarea>
				</div>
				
				<div>			
				<input type="hidden" name="num" value="${BoardEditView.num }">
				<input type="hidden" name="board_id" value="${BoardEditView.board_id }">
				</div>
				
			    <div class="form-group">
				    <label for="exampleInputFile" class="col-sm-02 control-label">ファイル</label>
				    <div class="col-sm-060">
				    <input name="item" type="file" id="exampleInputFile">
				  </div>
			    </div>
									
				<button type="submit" class="btn00 btn-primary submit mt-2">完了</button>
				
		</form>

</div>

<!-- 글쓰기 체크 -->
	<script>
		function boardCheck() {
			if(document.boardCheck.title.value=="") {
				alert("題目を入力してください。");
				boardWrite.title.focus();
				return false;
			}
			if(document.boardCheck.content.value=="") {
				alert("内容を入力してください。");
				boardWrite.content.focus();
				return false;
			}

			return true;
	}
	</script>


<%@ include file ="../footer.jsp" %>