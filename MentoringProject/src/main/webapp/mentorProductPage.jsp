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
	<form action="">
	<table border="1">
		<tr><td>id</td><td colspan="2">${ProductPage.productpk }</td></tr>
		<tr><td>전공</td><td colspan="2">${ProductPage.majorname }</td></tr>
		<tr><td>부전공</td><td colspan="2">${ProductPage.submajorname }</td></tr>
		<tr><td>title</td><td colspan="2">${ProductPage.title }</td></tr>
		<tr><td>가격</td><td colspan="2">${ProductPage.price }</td></tr>
		<tr><td>소개</td><td colspan="2">${ProductPage.introduce }</td></tr>
		<tr><td><input type="submit" value="수정"></td><td><a href="/MentoringProject/mentorScheduleInsert.do?productpk=${ProductPage.productpk }">스케쥴추가하기</a></td><td>삭제</td></tr>
		<tr><td colspan="3"><a href="/MentoringProject/mentorProductList.do">돌아가기</a></td></tr>					
	</table>
		</form>
			
		<table>
			<tr><td colspan="5">스케쥴리스트</td></tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	<c:forEach var="dtoS" items="${ProductList }" varStatus="status" >
		<tr>
    <td align="center"><input type="text" size="3" value="${status.count }" name="count"/></td>
    <td align="center"><input type="text" size="10" value="${dtoS.startday }" name="startday"/></td>
    <td align="center">
    <input type="text" size="3" value="${dtoS.starttime }" name="starttime"/>~
    <input type="text" size="3" value="${dtoS.endtime }" name="endtime"/></td>
    <td align="center"><input type="text" size="8" value="${dtoS.totalprice }" name="totalprice"/></td>
    <td align="center"><input type="hidden" name=schedulepk value="${dtoS.schedulepk}"/>
	<input type="radio" name="schedulepk" value="${dtoS.schedulepk}" ></td>
		</tr>
	</c:forEach>
		</table>

</body>
</html>