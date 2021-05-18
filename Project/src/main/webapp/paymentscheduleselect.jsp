<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케쥴 선택</title>
</head>
<body>
<h3>원하는 날짜를 선택하세요</h3>
	<table>
	
	<form action="payment.do" method="post" >
		<tr>
			<th>id</th>
			<th>날짜</th>
			<th>시간</th>
			<th>선택</th>
		
		</tr>
		<c:forEach items="${ScheduleSelect }" var="dto">
		<tr>
			<td>${dto.schedulepk }</td>
			<td>${dto.startday }</td>
			<td>${dto.starttime }~${dto.endtime }</td>
			<td><input type="radio" name="schedulepk" value="${dto.schedulepk }"></td>
			
		</tr>	
		</c:forEach>
		<input type="submit" value="예약하기"> 
		</form>
		
		</table>
</body>
</html>