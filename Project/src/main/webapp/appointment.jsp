<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멘토 product page</title>
</head>
<body>
	<h3>Product</h3>
	

	

<table border="0">
		<tr>
			<th>멘토이름</th>
			<th>전공이름</th>
			<th>세부전공이름</th>
			<th>멘토성별</th>
			<th>멘토주소</th>
			<th>멘토생년월일</th>
		</tr>

		<tr>
			<td>${Appointment.username }</td>
			<td>${Appointment.majorname }</td>
			<td>${Appointment.submajorname }</td>
			<td>${Appointment.mentorgender }</td>
			<td>${Appointment.mentoraddress }</td>
			<td>${Appointment.mentorbirth }</td>
			
		
		</tr>		
		<tr>
			<td colspan="6"><a href="/Project/paymentscheduleselect.do?productpk=<%=request.getParameter("productpk") %>">가능날짜보러가기</a> </td>
		</tr>
	</table>


</body>
</html>