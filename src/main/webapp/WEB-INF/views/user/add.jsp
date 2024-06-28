<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<h1>회원가입</h1>
		<form action="${pageContext.request.contextPath}/singup" method="post">
			<div class="input">
                <span>아이디</span><input type="text" name="userId"><br>
                <span>비밀번호</span><input type="password" name="userPwd" id="userPwd"><br>
                <div id="userPwdMsg"></div>
                <span>비밀번호 확인</span><input type="password" name="checkUserPwd" id="checkUserPwd"><br>
                <div id="checkUserPwdMsg"></div>
                <span>이메일</span><input type="email" name="userEmail" placeholder="이메일 입력" id="inputRef"><br>
                <p>사용방법선택</p>
                <div class="select">
	                <input type="radio" id=user name="userSelect" value="user"><label for="user" class="hover">사용자</label>
	                <input type="radio" id=protector name="userSelect" value="protector"><label for="protector" class="hover">보호자</label>	                
                </div>                
            </div><br>
		    <button type="submit">회원가입</button><br>
		    <button type="button" onclick="location.href='cover'">취소</button><br>        
		</form>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/add.js"></script>
</body>
</html>