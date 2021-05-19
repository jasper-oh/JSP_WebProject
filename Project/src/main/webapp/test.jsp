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
	<table>
	
		
<tr >
			<th>id</th>
			<th>날짜</th>
			<th>시간</th>
			<th>가격</th>
			<th>선택</th>

   
</tr>

		<c:forEach var="dto" items="${ScheduleSelect }" varStatus="status" >
		<tr>
   
    <td align="center"><input type="text" size="3" value="${status.count }" name="schedulepkview"/></td>
    <td align="center"><input type="text" size="10" value="${dto.startday }" name="startday"/></td>
    <td align="center">
    <input type="text" size="3" value="${dto.starttime }" name="starttime"/>~
    <input type="text" size="3" value="${dto.endtime }" name="endtime"/></td>
    <td align="center"><input type="text" size="8" value="${dto.totalprice }" name="totalprice"/></td>
    <td align="center"><input type="hidden" name=schedulepk${dto.schedulepk} value="${dto.schedulepk}"/>
<input type="radio" name="schedulepk" value="${dto.schedulepk}"></td>
		
		</tr>
	</c:forEach>
		</table>
	
<section>
    <p>----------------------</p>
    <div><label><input type="radio" name="method" value="카드" checked/>신용카드</label></div>
    <div><label><input type="radio" name="method" value="가상계좌" checked/>가상계좌</label></div>
    <p>----------------------</p>
  <button id="payment-button" >결제하기</button>
</section>
<script src="https://js.tosspayments.com/v1"></script>

<script>
var tossPayments = TossPayments("test_ck_kZLKGPx4M3MLwj1E9yd8BaWypv1o");
var button = document.getElementById("payment-button");

var orderId = new Date().getTime();

button.addEventListener("click", function () {
    var method = document.querySelector('input[name=method]:checked').value; // "카드" 혹은 "가상계좌"

    var paymentData = {
        amount: 19000,
        orderId: orderId,
        orderName: "토스 티셔츠",
        customerName: "이토페",
        successUrl: window.location.origin + "/jsp-sample/success.jsp",
        failUrl: window.location.origin + "/jsp-sample/fail.jsp",
    };
    
    if (method === '가상계좌') {
        paymentData.virtualAccountCallbackUrl = window.location.origin + '/jsp-sample/VirtualAccountCallback.jsp'
    }

    tossPayments.requestPayment(method, paymentData);
});
</script>
</body>
</html>