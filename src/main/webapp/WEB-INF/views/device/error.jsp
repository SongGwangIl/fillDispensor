<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/recordlist.css" rel="stylesheet">
</head>
<body>

	<h1>기기등록</h1>
	
	<img alt="" src="${pageContext.request.contextPath}/resources/img/dispensor.jpg">
	
	<div id="wrap">
		
		<p>잘못된 시리얼 코드 입력입니다. 다시 입력해주세요.</p>
		<a href="${pageContext.request.contextPath}/device">다시 등록하기</a>
		<a href="${pageContext.request.contextPath}/main">나중에 할게요</a>
	</div>

</body>
</html>