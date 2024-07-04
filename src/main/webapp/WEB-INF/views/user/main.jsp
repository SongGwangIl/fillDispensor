<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="data:,"> 
<meta charset="UTF-8">
<title>임시메인페이지</title>
</head>
<body>
	<h1>임시메인페이지</h1>
	<c:url var="regUrl" value="/schedule/list.do" ></c:url>
	<a href="${regUrl}">스케쥴 리스트로 가기</a>
</body>
</html>