<%@page import="com.project.mentoring.dto.ShareVar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>스케쥴 예약하기</title>
    <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
</head>
<body>
<h3>원하는 날짜를 선택하세요</h3>
	
<form  action="paymentdatatview.do" method="get">
	<table>		
<tr >
			<th>번호</th>
			<th>날짜</th>
			<th>시간</th>
			<th>가격</th>
			<!-- <th>선택</th> -->
</tr>
		<c:forEach var="dto" items="${ScheduleSelect }" varStatus="status" >
		<tr>
    <td align="center"><input type="text" size="3" value="${status.count }" name="count"/></td>
    <td align="center"><input type="text" size="10" value="${dto.startday }" name="startday"/></td>
    <td align="center">
    <a href="/Project/paymentdatatview.do?schedulepk=${dto.schedulepk}">${dto.starttime }~
    ${dto.endtime }</a>
    </td>
    <td align="center"><input type="text" size="8" value="${dto.totalprice }" name="totalprice"/></td>
    <%-- <td align="center"><input type="hidden" name=schedulepk value="${dto.schedulepk}"/>
<input type="radio" name="schedulepk" value="${dto.schedulepk}" ></td> --%>
		
		</tr>
	</c:forEach>
		</table>
		<!-- <input type="submit" value="선택">
		</form> -->

</body>
</html>