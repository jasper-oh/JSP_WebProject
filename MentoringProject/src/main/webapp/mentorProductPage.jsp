<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mentor의 product page</title>
</head>
<body>
		<h3>나의 Product</h3>
	<form action="/MentoringProject/mentorProductUpdate.do">
	<table border="1">
		<tr>
			<td>id</td>
			<td colspan="2"><input type="text" name="productpk" value="${ProductPage.productpk }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>전공</td>
			<td colspan="2">${ProductPage.majorname }</td>
		</tr>
		<tr>
			<td>부전공</td>
			<td colspan="2">${ProductPage.submajorname }</td>
		</tr>
		<tr>
			<td>title</td>
			<td colspan="2"><input type="text" name="title" value = "${ProductPage.title }"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td colspan="2"><input type="text" name="price" value = "${ProductPage.price }"></td>
		</tr>
		<tr>
			<td>소개</td>
			<td colspan="2"><input type="text" name="introduce" value = "${ProductPage.introduce }"></td>
		</tr>
		<tr>
			<td colspan="3">스케쥴리스트</td>
		</tr>
		<tr>
			<td><input type="submit" value="수정"></td>			
			<td colspan="3"><a href="/MentoringProject/mentorProductList.do">돌아가기</a></td>
		</tr>					
	</table>
		</form>
		<table>
			<tr>
				<td colspan="3">스케쥴리스트</td>
				<td colspan="1"></td><td colspan="1"></td>
				<td><a href="/MentoringProject/insertScheduleView.do?productpk=${ScheduleDto.productpk }">스케쥴추가하기</a></td>
			</tr>
	<c:forEach var="ScheduleDto" items="${MentorScheduleList }" varStatus="status" >
		<tr>
		  	<td align="center"><input type="text" size="3" value="${status.count }" name="count"/></td>
			<td align="center"><input type="text" size="10" value="${ScheduleDto.startday }" name="startday"/></td>
			<td align="center">
  				<input type="text" size="3" value="${ScheduleDto.starttime }" name="starttime"/>~
  				<input type="text" size="3" value="${ScheduleDto.endtime }" name="endtime"/>
  			</td>
  			<td align="center"><input type="text" size="8" value="${ScheduleDto.totalprice }" name="totalprice"/></td>
			<td align="center">
			  <input type="hidden" name=pk${status.index} value=""/>
			  	<a href="/MentoringProject/deleteSchedule.do?schedulepk=${ScheduleDto.schedulepk}">삭제</a>
			</td>
		</tr>
	</c:forEach>
		</table>
		<table border="0">
		<tr>
			<th>유저네임</th>
			<th>리뷰 타이틀</th>
			<th>리뷰 점수</th>
			<th>리뷰 작성된 날짜</th>
		</tr>
		<c:forEach items="${mentorReviewView }" var="ReviewDto">
		<tr>
			<td><input type="text" name="username" size="20" value= "${ReviewDto.username }" disabled="disabled"></td>
			<td><input type="text" name="reviewtitle" value = "${ReviewDto.reviewtitle }" disabled="disabled" size="50"></td>
			<td><input type="text" name="reviewtext" value = "${ReviewDto.reviewtext }" disabled="disabled" size="50"></td>
			<td><input type="text" name="reviewscore" value = "${ReviewDto.reviewscore }" disabled="disabled" size="50"></td>
			<td><input type="text" name="indate" value = "<fmt:formatDate value="${ReviewDto.indate }" pattern="yyyy.MM.dd" />" disabled="disabled" size="50"></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>