<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색리스트</title>
</head>
<body>
<body>
		<h3>ProductList</h3>
	<table border="1">
		<tr>
			<th>전공</th>
			<th>부전공</th>
			<th>멘토이름</th>
			<th>프로덕트pk</th>
		
		</tr>
		<c:forEach items="${ProductSelect }" var="dto">
		<tr>
			<td>${dto.majorname }</td>
			<td>${dto.submajorname }</td>
			<td><a href="/Project/appointment.do?productpk=${dto.productpk }">${dto.username }</a></td>
			<td>${dto.productpk }</td>
			
			
		</tr>		
		</c:forEach>

	</table>
</body>

</body>
</html>