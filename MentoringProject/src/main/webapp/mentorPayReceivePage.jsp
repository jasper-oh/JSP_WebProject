<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TakeYourTime</title>
   	<link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/subpage.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/slick.min.js"></script>
</head>
<body>
<%@include file="mentorHeader.jsp" %>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>	
<div class="section">
	<h3>정산이 모두 완료된 리스트</h3>
	<table border="1">
		<tr>
			<th>결제번호</th>
			<th>포스 타이틀</th>
			<th>포터링 날짜</th>
			<th>정산금액</th>
			<th>정산받은 날짜</th>
			
		
		</tr>
		<c:forEach items="${mentorPayReceiveList }" var="dto">
		<tr>
		    <td>${dto.paymentPk }</td>
			<td>${dto.producttitle }</td>
			<td>${dto.startday }</td>
			<td>${dto.totalprice }</td>
			<td>${dto.paymentsenddate }</td>
			
			<td><a href="/MentoringProject/mentorProfile.do">멘토마이페이지로</a></td>
			
			
		</tr>		
		</c:forEach>
	</table>
</div>
<br>
<br>
<br>
<br><br>
<br>
<br>
<br><br>
<br>
<br>
<br><br>
<br>
<br>
<br><br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="everyFooter.jsp" %>

</body>
</html>