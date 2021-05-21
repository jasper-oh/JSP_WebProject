<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<title>멘토 product page</title>    
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <style type="text/css">
    div.body {
    	padding: 0px 100px;
    }
    tr.space {
  border-bottom: 10px solid #fff;
}
    </style>
</head>
<body>
		<nav>
 			<div class="logo">
                <svg viewBox="0 0 1000 1000" role="presentation" aria-hidden="true" focusable="false"
                    style="height: 1em; width: 1em; display: inline-block; fill: currentcolor;">
                    <path
                        d="m499.3 736.7c-51-64-81-120.1-91-168.1-10-39-6-70 11-93 18-27 45-40 80-40s62 13 80 40c17 23 21 54 11 93-11 49-41 105-91 168.1zm362.2 43c-7 47-39 86-83 105-85 37-169.1-22-241.1-102 119.1-149.1 141.1-265.1 90-340.2-30-43-73-64-128.1-64-111 0-172.1 94-148.1 203.1 14 59 51 126.1 110 201.1-37 41-72 70-103 88-24 13-47 21-69 23-101 15-180.1-83-144.1-184.1 5-13 15-37 32-74l1-2c55-120.1 122.1-256.1 199.1-407.2l2-5 22-42c17-31 24-45 51-62 13-8 29-12 47-12 36 0 64 21 76 38 6 9 13 21 22 36l21 41 3 6c77 151.1 144.1 287.1 199.1 407.2l1 1 20 46 12 29c9.2 23.1 11.2 46.1 8.2 70.1zm46-90.1c-7-22-19-48-34-79v-1c-71-151.1-137.1-287.1-200.1-409.2l-4-6c-45-92-77-147.1-170.1-147.1-92 0-131.1 64-171.1 147.1l-3 6c-63 122.1-129.1 258.1-200.1 409.2v2l-21 46c-8 19-12 29-13 32-51 140.1 54 263.1 181.1 263.1 1 0 5 0 10-1h14c66-8 134.1-50 203.1-125.1 69 75 137.1 117.1 203.1 125.1h14c5 1 9 1 10 1 127.1.1 232.1-123 181.1-263.1z">
                    </path>
	                <h2>Take Your Time</h2>
                </svg>
            </div>
            <div class="menu">
            </div>
        </nav>
	

	
<div class="body">
	<h3>Product</h3>
<table border="0">
		<tr>
			<td>멘토이름</td><td>${Appointment.username }</td>
		</tr>
		<tr>
			<td>전공이름</td><td>${Appointment.majorname }</td>
		</tr>
		<tr>
			<td>세부전공이름</td><td>${Appointment.submajorname }</td>
		</tr>
		<tr>
			<td>멘토성별</td><td>${Appointment.mentorgender }</td>
		</tr>
		<tr>
			<td>멘토주소</td><td>${Appointment.mentoraddress }</td>
		</tr>
		<tr>
			<td>멘토생년월일</td><td>${Appointment.mentorbirth }</td>	
		</tr>
		<tr class="space"></tr>
		<tr>
		<td colspan="1"><a href="/Project/paymentscheduleselect.do?productpk=<%=request.getParameter("productpk") %>">가능날짜보러가기</a> </td>
		
		<td colspan="1"><a href="/Project/first.do">돌아가기</a> </td> <!-- 검색어 데이터 가져가기 -->
		</tr>
	</table>
	
	<table>
	<tr>
		<th style="visibility:hidden"></th><th>이름</th><th>제목</th><th>내용</th><th>점수</th><th>작성일자</th>
	</tr>
	<c:forEach items="${ReviewList }" var="dtoR">
	<tr>
	<td style="visibility:hidden">${dtoR.reviewpk }</td>
		    <td>${dtoR.username }</td>
			<td>${dtoR.reviewtitle }</td>
			<td>${dtoR.reviewtext }</td>
			<td>${dtoR.reviewscore }</td>
			<td><fmt:formatDate value="${dtoR.indate }" pattern="yyyy.MM.dd" /></td>
	</tr>
	</c:forEach>
	<tr></tr>
	</table>
</div>

</body>
</html>