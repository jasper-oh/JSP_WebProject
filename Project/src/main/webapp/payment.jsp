<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 확인</title>
</head>
<body>

	<h3> 예약신청내역 확인</h3>
	<form action="Paysystem.do" method="post">
	
	멘토이름<input type="text" name="username" readonly="readonly" value="${Payment.username}"></input><br>
	전공이름<input type="text" name="username" readonly="readonly" value="${Payment.majorname}"></input><br>
	세부전공이름<input type="text" name="username" readonly="readonly" value="${Payment.submajorname}"></input><br>
	예약날짜<input type="text" name="username" readonly="readonly" value="${Payment.startday}"></input><br>
	시작시간<input type="text" name="username" readonly="readonly" value="${Payment.starttime}"></input><br>
	끝시간<input type="text" name="username" readonly="readonly" value="${Payment.endtime}"></input><br>
	<input type="submit" value="결제하기">
	
	</form>


</body>
</html>