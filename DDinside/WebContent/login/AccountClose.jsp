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
	<h2 class="text-center p8060">アカウント削除確認</h2>
	</div>
	
		<form action="controller" method="post" name="Passcheck" onsubmit="return PassCheck()">
			<input type="hidden" name="command" value="AccountCloseComplete">
			
				<div class="form-group">
					<input type="hidden" name="num" value="${loginUser.num }">
				</div>
				
				<div class="form-group">
					<label class="mb-2">パスワードを入力してください。</label>
					<input type="password" name="pass" class="form-control" id="password1" >
				</div>

				<button type="submit" class="btn00 btn-primary submit">完了</button>
			</form>
			
</div>

<!--  체크 -->
	<script>
		function PassCheck() {
			if(document.Passcheck.pass.value.length==0) {
				alert("パスワードを入力してください。");
				Passcheck.pass.focus();
				return false;
			}
			if(document.Passcheck.pass.value.length<4) {
				alert("パスワードは4字以上入力してください。");
				Passcheck.pass.focus();
				return false;
			}
			return true;
	}
	</script>


<%@ include file ="../footer.jsp" %>