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
    
<%
	String message = (String)request.getAttribute("message");
%>
<c:if test="${message ne null}">
	<script>
		alert("<%=message%>");
	</script>
</c:if>

<div class="container toppadding01">

<div class="col-md-12">
	<h2 class="text-center p8060">プロフィール</h2>
	</div>
	
		<form action="controller" name="profileEdit" method="post" onsubmit="return EditCheck()">
			<input type="hidden" name="command" value="EditProfile">
			
				<div class="form-group">
					<input type="hidden" name="num" value="${loginUser.num }">
				</div>
				
				<div class="form-group">
					<label class="mb-2">パスワード</label>
					<input type="password" name="pass" class="form-control" id="password1" value="${memberVO.pass }" >
				</div>
				
				<div class="form-group">
					<label>パスワード確認</label>
					<input type="password" name="pass1" class="form-control" id="password2" value="${memberVO.pass }">
				</div>
				
					<label>お名前</label>
					<input type="text" name="name" class="form-control" id="validationDefault01" value="${memberVO.name }">
			
				<div class="form-group">
					<label>メール</label>
					<input type="email" name="email" class="form-control" id="validationDefault02" value="${memberVO.email }">
				</div>

				<button type="submit" class="btn00 btn-primary submit">完了</button>
			</form>
			
		
			<a href="controller?command=AccountClose&num=${loginUser.num }" class="btn00 btn-primary submit">アカウント削除</a>
		
</div>


<!--  체크 -->
	<script>
		function EditCheck() {
			if(document.profileEdit.pass.value.length==0) {
				alert("パスワードを入力してください。");
				profileEdit.pass.focus();
				return false;
			}
			if(document.profileEdit.pass.value.length<4) {
				alert("パスワードは4字以上入力してください。");
				profileEdit.pass.focus();
				return false;
			}
			if(document.profileEdit.pass.value!=document.profileEdit.pass1.value) {
				alert("パスワードが一致していません。");
				profileEdit.pass.focus();
				return false;
			}
			if(document.profileEdit.name.value=="") {
				alert("名前を入力してください。");
				profileEdit.name.focus();
				return false;
			}
			return true;
	}
	</script>


<%@ include file ="../footer.jsp" %>