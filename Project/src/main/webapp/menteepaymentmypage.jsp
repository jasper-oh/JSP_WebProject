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

		<h3>멘티 결제 마이페이지</h3>
	<table border="0">
		<tr>
			<th>결제번호</th>
			<th>전공이름</th>
			<th>부전공이름</th>
			<th>멘토이름</th>
			<th>가격</th>
			<th>날짜</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.paymentpk }</td>
			<td>${dto.majorname }</td>
			<td>${dto.majorname }</td>
			<td>${dto.submajorname }</td>
			<td>${dto.mentorname }</td>
			<td>${dto.price }</td>
			<td>${dto.startday }</td>


		</tr>		
		</c:forEach>
		<tr>

			
		</tr>
	</table>
		
	

</body>
</html>