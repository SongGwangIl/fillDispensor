<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 복약 기록 조회 </title>
<style>
	h1 {
		font-size: 25px;
		width : 300px;
		margin : 0 auto;
	}
	table{
		width: 650px;
		font-size: 15px;
		text-align: center;
		border: 1px solid black;
		border-collapse: collapse;
		margin: 0 auto;
    }
	table th{
		border: 1px solid black;
		padding : 5px;
	}
	table td{
		border: 1px solid black;
		padding : 5px;
	}
	p {
		text-align : center;
		margin : 0 auto;
	}
</style>
</head>
<body>

<p><br>
<jsp:include page="/WEB-INF/views/common/header.jsp"/> </p>

<h1> 오늘의 복약 로그 조회 </h1>
<table>
	<thead>
		<tr>
			<th>
				복약로그 ID
			</th>
			<th>
				복약한 사용자 ID
			</th>
			<th>
				복약한 시간 알림 ID
			</th>
			<th>
				복약한 날짜
			</th>
			<th>
				복약 성공 여부
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dvo" items="${recordSelectByDate}">
		<tr>
			<td> ${dvo.takeId} </td>
			<td> ${dvo.userId} </td>
			<td> ${dvo.timeId} </td>
			<td> <fmt:formatDate value="${dvo.takeDate}" pattern="MM월 dd일 HH:mm 복용"/> </td>
			<td> ${dvo.takeSuccess} </td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<h1> 복약 로그 모두 조회 </h1>
<table>
	<thead>
		<tr>
			<th>
				복약로그 ID
			</th>
			<th>
				복약한 사용자 ID
			</th>
			<th>
				복약한 시간 알림 ID
			</th>
			<th>
				복약한 날짜
			</th>
			<th>
				복약 성공 여부
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="avo" items="${recordSelectByAll}">
		<tr>
			<td> ${avo.takeId} </td>
			<td> ${avo.userId} </td>
			<td> ${avo.timeId} </td>
			<td> <fmt:formatDate value="${avo.takeDate}" pattern="MM월 dd일 HH:mm 복용"/> </td>
			<td> ${avo.takeSuccess} </td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<p> 추가 구현해야 할 기능 </p>
<p> : 로그인 정보를 받아서 로그인 한 사용자의 로그만 조회할 수 있도록 (구현 완료)</p>
<p> : 브라우저에서 date 값을 설정할 수 있는 장치 (원하는 날짜로 바꿔서 조회) </p>


</body>
</html>