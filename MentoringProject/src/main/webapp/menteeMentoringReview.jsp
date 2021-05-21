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
 <h1>리뷰작성페이지</h1>
 	<table border="0">
	<form action="menteeMentoringReview.do?paymentpk=${param.paymentpk }" method="post">
		<tr>
			<td>결제번호</td>
			<td><input type="text" name="paymentpk" size="20" value= "${param.paymentpk }" disabled="disabled"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="reviewtitle" size="50"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="50" name="reviewtext"></textarea></td>
		</tr>
		<tr>
			<td>점수</td>		
			<td><input type="radio" name="reviewscore" value="1">1점
			<input type="radio" name="reviewscore" value="2">2점
			<input type="radio" name="reviewscore" value="3">3점
			<input type="radio" name="reviewscore" value="4">4점
			<input type="radio" name="reviewscore" value="5">5점</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="저장"></td>
		</tr>
	</form>
	</table>
</body>
</html>