<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마스터의 리뷰 관리 페이지</h1>
 	<table border="0">
		<tr>
			<th>포스 타이틀</th>
			<th>리뷰 타이틀</th>
			<th>리뷰 점수</th>
			<th>리뷰 작성된 날짜</th>
		</tr>
		<c:forEach items="${mentorReviewView }" var="dto">
		<tr>
			<td><input type="text" name="title" size="20" value= "${dto.title }" disabled="disabled"></td>
			<td><a href="/MentoringProject/mentorProductPage.do?productpk=${dto.productpk }" ><input type="text" name="reviewtitle" value = "${dto.reviewtitle }" disabled="disabled" size="50"></a></td>
			<td><input type="text" name="reviewscore" value = "${dto.reviewscore }" disabled="disabled" size="50"></td>
			<td><input type="text" name="indate" value = "${dto.indate }" disabled="disabled" size="50"></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>