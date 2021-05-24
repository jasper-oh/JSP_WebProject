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



</body>
</html>