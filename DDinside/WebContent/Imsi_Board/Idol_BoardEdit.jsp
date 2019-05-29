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
    
<c:set var="board_id" value="Idol"/>

<div class="container toppadding">

<div class="col-md-12">
	<h2 class="text-center p8060">글 수정</h2>
	</div>
	
		<form action="controller?command=${board_id}_BoardReWrite" method="post" enctype="multipart/form-data">
	
				<div class="form-group">
					<label class="mb-2">제목</label>
					<input type="text" name="title" class="form-control01" value="${BoardEditView.title }">
				</div>
				
<%-- 				<div class="form-group">
					<label class="mb-2">비밀번호</label>
					<input type="password" name="pass" class="form-control02" id="password1" value="${BoardEditView.pass }">
				</div> --%>
					
				<div class="form-group">
					<label class="mb-2">내용</label>
					<textarea name="content" class="form-control03">${BoardEditView.content } </textarea>
				</div>
				
				<div>			
				<input type="hidden" name="num" value="${BoardEditView.num }">
				<input type="hidden" name="board_id" value="${BoardEditView.board_id }">
				</div>
				
			    <div class="form-group">
				    <label for="exampleInputFile" class="col-sm-02 control-label">파일 업로드</label>
				    <div class="col-sm-060">
				    <input name="item" type="file" id="exampleInputFile">
				  </div>
			    </div>
									
				<button type="submit" class="btn00 btn-primary submit mt-2">수정완료</button>
				
		</form>

</div>



<%@ include file ="../footer.jsp" %>