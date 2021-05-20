<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mentor의 product page</title>
<style type="text/css">
	table{border-spacing:10px; }
</style>
</head>
<body>
		<h3>나의 Product</h3>
	<table>
	<form action=""></form>
		<tr><td>id</td><td colspan="2">${ProductPage.productpk }</td></tr>
		<tr><td>전공</td><td colspan="2">${ProductPage.majorname }</td></tr>
		<tr><td>부전공</td><td colspan="2">${ProductPage.submajorname }</td></tr>
		<tr><td>title</td><td colspan="2">${ProductPage.title }</td></tr>
		<tr><td>가격</td><td colspan="2">${ProductPage.price }</td></tr>
		<tr><td>소개</td><td colspan="2">${ProductPage.introduce }</td></tr>
			<tr><td colspan="3">스케쥴리스트</td></tr>
		<tr><td><input type="submit" value="수정"></td><td><a href="/Project/mentorscheduleinsert.do?productpk=${ProductPage.productpk }">스케쥴추가하기</a></td><td>삭제</td></tr>
		<tr><td colspan="3"><a href="/Project/mentorproductlist.do">돌아가기</a></td></tr>
					
		</form>


	</table>

</body>
</html>