<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mentor의 product list</title>
</head>
<body>
		<h3>나의 ProductList</h3>
	<table border="1">
		<tr>
			<th>id</th>
			<th>전공</th>
			<th>부전공</th>
			<th>title</th>
			<th>가격</th>
		
		</tr>
		<c:forEach items="${ProductList }" var="dto">
		<tr>
			<td>${dto.productpk }</td>
			<td>${dto.majorname }</td>
			<td>${dto.submajorname }</td>
			<td><a href="/Project/mentorproductpage.do?productpk=${dto.productpk }">${dto.title }</a></td>
			<td>${dto.price }</td>
			
			
		</tr>		
		</c:forEach>

	</table>

</body>
</html>