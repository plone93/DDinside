<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="javax.naming.*"%>
    
<!-- popup for login -->
<div id="popup3" class="popup-effect">
	<div class="popup">
		<div class="login px-sm-4 mx-auto mw-100">
			<h5 class="text-center mb-4">ログイン</h5>
			
			<form action="controller" method="post">
			<input type="hidden" name="command" value="Login">
				<div class="form-group">
					<label class="mb-2">ID</label>
					<input type="text" name="login_id" class="form-control" id="password1" >
				</div>
				
				<div class="form-group">
					<label class="mb-2">パスワード</label>
					<input type="password" name="login_pass" class="form-control" id="password1">
				</div>
				
				<button type="submit" class="btn02 btn-primary submit mt-2">ログイン</button>
				<p class="text-center mt-2">
					<a href="#popup4"> アカウント登録</a>
				</p>
				<p class="text-center mt-2">
					<a href="#popup10"> 管理者ログイン </a>
				</p>
			</form>
		</div>

		<a class="close" href="#">&times;</a>
	</div>
</div>
<!-- //popup for login -->

<!-- 관리자 로그인 -->
<div id="popup10" class="popup-effect">
	<div class="popup">
		<div class="login px-sm-4 mx-auto mw-100">
			<h5 class="text-center mb-4">管理者ログイン</h5>
			
			<form action="controller" method="post">
			<input type="hidden" name="command" value="AdminLogin">
				<div class="form-group">
					<label class="mb-2">ID</label>
					<input type="text" name="login_id" class="form-control" id="password1" >
				</div>
				
				<div class="form-group">
					<label class="mb-2">パスワード</label>
					<input type="password" name="login_pass" class="form-control" id="password1" >
				</div>
				
				<button type="submit" class="btn02 btn-primary submit mt-2">ログイン</button>
			</form>
		</div>

		<a class="close" href="#">&times;</a>
	</div>
</div>
<!-- //popup for login -->



<!-- popup for register -->
<div id="popup4" class="popup-effect">
	<div class="popup">
		<div class="login px-sm-4 mx-auto mw-100">
			<h5 class="text-center mb-4">アカウント登録</h5>
					<a class="close" href="#">&times;</a>
			<form action="controller" method="post" name="form" onsubmit="return joinCheck()">
			<input type="hidden" name="command" value="Register">
				<div class="form-group">
				
				<div class="form-group">
					<label class="mb-2">ID</label>     
					<input id="id" type="text" name="id" class="form-control">
					<button id="idCheck" type="button" value="0" class="btn00 btn-primary submit">IDチェック</button>
					<input type="hidden" name="idcheck">
				</div>
				
				<div class="form-group">
					<label class="mb-2">パスワード</label>
					<input type="password" name="pass" class="form-control" id="password1" >
				</div>
				
				<div class="form-group">
					<label>パスワード確認</label>
					<input type="password" name="pass1" class="form-control" id="password2" >
				</div>
				
					<label>お名前</label>
					<input type="text" name="name" class="form-control" id="validationDefault01" >
				</div>
				
				<div class="form-group">
					<label>メール</label>
					<input type="email" name="email" class="form-control" id="validationDefault02" >
				</div>

				<button type="submit" class="btn02 btn-primary submit">登録</button>
				<p class="text-center mt-3">
					<a href="#">やめる</a>
				</p>
			</form>
		</div>

	</div>
</div>
<!-- //popup for register -->


<!-- 아이디 중복체크 이벤트창 -->


	<script>
/* 	var input = document.getElementById("id").value;
	var id = document.getElementById("id").getAttribute("id"); 
	지역변수 개념이 있어서 클릭 메서드 안에서 값을 호출해야함
	*/
		 $("#idCheck").click(function(){
			 var value = $('#id').val();
			 $.ajax({
				 type:"post",
				 dataType:"json",
				 url:"controller?command=IdCheck",
				 data: {id:value},
				 success:function(data){
					 alert(data.message);
					 if(data.result != 1){
						 $('#idCheck').val('1');
					 } else {
						 $('#idCheck').val('0');
					 }
				 },
				 error: function(request, status, error){
					 alert("エラーが発生しました。");
				 }
			 });
		 });
	 
	</script>
	
	<!-- 회원가입 체크 -->
	<script>
		function joinCheck() {
			if(document.form.id.value=="") {
				alert("IDを入力してください。");
				form.id.focus();
				return false;
			}
			if(document.form.id.value.length<4) {
				alert("IDは4字以上入力してください。");
				form.id.focus();
				return false;
			}
			if(form.idCheck.value==0) {
				alert("IDチェックをしてください。");
				form.id.focus;
				return false;
			}
			if(document.form.pass.value.length==0) {
				alert("パスワードを入力してください。");
				form.pass.focus();
				return false;
			}
			if(document.form.pass.value.length<4) {
				alert("パスワードは4字以上入力してください。");
				form.pass.focus();
				return false;
			}
			if(document.form.pass.value!=document.form.pass1.value) {
				alert("パスワードが一致していません。");
				form.pass.focus();
				return false;
			}
			if(document.form.name.value=="") {
				alert("名前を入力してください。");
				form.name.focus();
				return false;
			}
			return true;
	}
	</script>

<c:if test="${edit eq null }">
</c:if>
<c:if test="${edit ne null }">	

<!-- 회원정보 수정 -->
<div id="popup5" class="popup-effect">
	<div class="popup">
		<div class="login px-sm-4 mx-auto mw-100">
			<h5 class="text-center mb-4">プロフィール修正</h5>
					<a class="close" href="#">&times;</a>
					
			<form action="controller" method="post">
			<input type="hidden" name="command" value="GetProfile">
			
				<div class="form-group">
					<input type="hidden" name="id" value="${loginUser.id }">
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

				<button type="submit" class="btn btn-primary submit">完了</button>
			</form>
			
		</div>

	</div>
</div>

</c:if>
<!-- //popup for register -->
	
	
	
	<!--  글쓰기 -->
<div id="BoardWrite" class="popup-effect">
	<div class="popup1">
		<div class="login px-sm-4 mx-auto mw-100">
		<a class="close" href="#">&times;</a>
			<h5 class="text-center mb-4">投稿</h5>
			
			<form action="controller?command=BoardWrite&board_id=${board_id}" method="post" enctype="multipart/form-data" name="boardWrite" onsubmit="return writeCheck()">
	
				<div class="form-group">
					<label class="mb-2">題目</label>
					<input type="text" name="title" class="form-control01">
				</div>
				
<!-- 				<div class="form-group">
					<label class="mb-2">비밀번호</label>
					<input type="password" name="pass" class="form-control02" id="password1">
				</div> -->
				
				<div class="form-group">
					<label class="mb-2">内容</label>
					<textarea name="content" class="form-control03"></textarea>
				</div>
				
				 <div class="form-group">
			 	   <label class="mb-2">ファイル</label>
			 	   <div >
			 	  	 <input name="item" type="file" class="file" >
			       </div>
			     </div>
			     
			     <c:if test="${loginUser ne null and Admin eq null}">
				<div>			
					<input type="hidden" name="name" value="${loginUser.name }">
					<input type="hidden" name="userid" value="${loginUser.id }">
				</div>
				</c:if>
				<c:if test="${loginUser eq null and Admin ne null }">
					<input type="hidden" name="name" value="${Admin.name }">
					<input type="hidden" name="userid" value="${Admin.id }">
				</c:if>
				
				<button type="submit" class="btn01 btn-primary submit mt-2">投稿</button>
			</form>
		</div>

		
	</div>
</div>
<!-- //게시판 끝 -->

<!-- 글쓰기 체크 -->
	<script>
		function writeCheck() {
			if(document.boardWrite.title.value=="") {
				alert("題目を入力してください。");
				boardWrite.title.focus();
				return false;
			}
			if(document.boardWrite.content.value=="") {
				alert("内容を入力してください。");
				boardWrite.content.focus();
				return false;
			}

			return true;
	}
	</script>


	