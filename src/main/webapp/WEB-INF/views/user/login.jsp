<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
<link rel="stylesheet" href="/resources/css/login.css" type="text/css">
=======
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css">
>>>>>>> branch 'master' of https://github.com/SongGwangIl/fillDispensor.git
</head>
<body>
	<div id="wrap">
		<h1>로그인</h1>
<<<<<<< HEAD
		<form action="${pageContext.request.contextPath}/login.do" method="post">
			<div class="input">
                <span>아이디</span> <input type="text" name="userId"><br>
                <span>비밀번호</span><input type="password" name="userPass"><br>
                <input type="submit" value="로그인" id="btn">
            </div>
		</form>
=======
		<form action="${pageContext.request.contextPath}/login" method="post">
			<ul class="input">
				<li>
	                <label>아이디</label>
	                <input type="text" name="userId">
	            <li>
	                <label>비밀번호</label>
	                <input type="password" name="userPwd">
				</li>
            </ul>
	    	<input type="submit" value="로그인" id="btn">				
		</form>
		<a href="${pageContext.request.contextPath}/singup">회원가입</a><br>
		<a href="#">아이디를 잃어버렸습니까?</a><br>
		<a href="#">비밀번호를 잃어버렸습니까?</a>
>>>>>>> branch 'master' of https://github.com/SongGwangIl/fillDispensor.git
	</div>
</body>
</html>