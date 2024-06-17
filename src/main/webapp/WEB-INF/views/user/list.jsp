<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="data:,"> 
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원 목록</h1>             	 							
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>비번</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${lvo}">
				<tr>
					<td>
						<c:out value="${vo.userId}"/>
					</td>
					<td>
						<c:out value="${vo.userPass}"/>
					</td>
				</tr>					
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>