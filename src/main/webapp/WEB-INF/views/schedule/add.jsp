<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케쥴 등록 화면</title>

<style>

</style>

</head>

<body>
	<div id=insertList">
		<form action="${pageContext.request.contextPath}/schedule/add.do" method="post">
			<fieldset>
				<legend>스케쥴 등록</legend>
					<ul>
						<label for="scheTitle">스케쥴 제목</label>
						<input type="text" id="scheTitle">  
					</ul>
					<ul>
						<label for="scheStartDate">처방일자</label>
						<input type="date" id="scheStartDate">	
					</ul>
					<ul>
						<label for="scheSelect">처방기간</label>
						<select>
							<option value="1주" selected>1주</option>
							<option value="2주">2주</option>
							<option value="3주">3주</option>
							<option value="4주">4주</option>
							<option value="5주">5주</option>
							<option value="6주">6주</option>
							<option value="기타">직접 입력</option>
						</select>	
						스크립트 추가예정
					</ul>
					<ul>
						<label for="scheEndDate">만료일자</label>
						<input type="date" id="scheEndDate">
					</ul>
					
				</label>
			<input type="submit" value="등록">
			</fieldset>
		</form>
	</div>
</body>

<script>
	

</script>
</html>