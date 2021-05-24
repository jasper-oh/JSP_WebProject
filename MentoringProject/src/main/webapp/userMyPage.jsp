<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저의 마이페이지 입니다.</h1>
	
	<a href="/MentoringProject/menteeBookingList.do">예약 신청 내역</a>
	<a href="/MentoringProject/menteeMentoringList.do">멘토링 결제 내역 확인</a>
	
	<form action="/MentoringProject/MenteeMyPageModify.do" method="post">
	
	<table>
	<c:forEach items="${MenteeMyPageOpen }" var="dto">
	<tr>
		<td>ID : </td>
		<td><input type="text"  name="userid" value="${dto.userid }" readonly="readonly" ></td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td><input type="text" name="username" value="${dto.username }" readonly="readonly" ></td>
	</tr>
	<tr>
		<td>핸드폰번호 : </td>
		<td><input type="text" name="userphone" value="${dto.userphone }" ></td>

	</tr>
	<tr>
		<td>이메일 : </td>
		<td><input type="text" name="useremail" value="${dto.useremail }" ></td>
	</tr>
	<tr>
	
		<td><input type="submit" value="수정하기"></td>

	</tr>
	
	</c:forEach>	
	</table>
	</form>
	
</body>
</html>