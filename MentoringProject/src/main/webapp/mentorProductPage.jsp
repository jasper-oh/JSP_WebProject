<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mentor의 product page</title>
</head>
<body>
		<h3>나의 Product</h3>

	<table border="1">
		<tr><td>id</td><td colspan="2">${ProductPage.productpk }</td></tr>
		<tr><td>전공</td><td colspan="2">${ProductPage.majorname }</td></tr>
		<tr><td>부전공</td><td colspan="2">${ProductPage.submajorname }</td></tr>
		<tr><td>title</td><td colspan="2">${ProductPage.title }</td></tr>
		<tr><td>가격</td><td colspan="2">${ProductPage.price }</td></tr>
		<tr><td>소개</td><td colspan="2">${ProductPage.introduce }</td></tr>			
	</table>
	<tr><td colspan="6"><a href="/MentoringProject/mentorScheduleListView.do?productpk=${ProductPage.productpk }">스케쥴보러가기</a></td></tr>



</body>
</html>