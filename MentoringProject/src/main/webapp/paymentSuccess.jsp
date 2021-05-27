<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64"%>
<%@ page import="java.util.Base64.Encoder"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.Reader" %>
<%@ page import="java.nio.charset.StandardCharsets" %>

<%
 // 결제 승인 API 호출하기 
 
  String orderId = request.getParameter("orderId");
  String paymentKey = request.getParameter("paymentKey");
  String amount = request.getParameter("amount");

  String secretKey = "test_ak_JQbgMGZzorzYpJ1D4XkVl5E1em4d" + ":";
  
  Encoder encoder = Base64.getEncoder(); 
  byte[] encodedBytes = encoder.encode(secretKey.getBytes("UTF-8"));
  String authorizations = "Basic "+ new String(encodedBytes, 0, encodedBytes.length);
  
  URL url = new URL("https://api.tosspayments.com/v1/payments/" + paymentKey);
  
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  connection.setRequestProperty("Authorization", authorizations);
  connection.setRequestProperty("Content-Type", "application/json");
  connection.setRequestMethod("POST");
  connection.setDoOutput(true);

  JSONObject obj = new JSONObject();
  obj.put("orderId", orderId);
  obj.put("amount", amount);
  
  OutputStream outputStream = connection.getOutputStream();
  outputStream.write(obj.toString().getBytes("UTF-8"));
  
  int code = connection.getResponseCode();
  boolean isSuccess = code >= 200 && code < 300 ? true : false;
  
  InputStream responseStream = isSuccess? connection.getInputStream(): connection.getErrorStream();
  
  Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);

  JSONParser parser = new JSONParser();
  JSONObject jsonObject = (JSONObject) parser.parse(reader);
  responseStream.close();

%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TakeYourTime</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/subpage.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/slick.min.js"></script>

</head>
<body>
<!--헤더 구역  -->
 <header id="header">
        <div class="topmenu">
            <div class="row">
                <a href="#none"><i class="fab fa-facebook-square"></i></a>
                <a href="#none"><i class="fab fa-twitter"></i></a>
                <a href="#none"><i class="fab fa-instagram"></i></a>
                <a href="#none"><i class="fas fa-comment-dots"></i></a>
            </div>
        </div>
        <div class="menubar row">
            <div class="logo cf">
                <!-- <svg viewBox="0 0 1000 1000" role="presentation" aria-hidden="true" focusable="false"
                        style="height: 1em; width: 1em; display: inline-block; fill: currentcolor;">
                        <path
                            d="m499.3 736.7c-51-64-81-120.1-91-168.1-10-39-6-70 11-93 18-27 45-40 80-40s62 13 80 40c17 23 21 54 11 93-11 49-41 105-91 168.1zm362.2 43c-7 47-39 86-83 105-85 37-169.1-22-241.1-102 119.1-149.1 141.1-265.1 90-340.2-30-43-73-64-128.1-64-111 0-172.1 94-148.1 203.1 14 59 51 126.1 110 201.1-37 41-72 70-103 88-24 13-47 21-69 23-101 15-180.1-83-144.1-184.1 5-13 15-37 32-74l1-2c55-120.1 122.1-256.1 199.1-407.2l2-5 22-42c17-31 24-45 51-62 13-8 29-12 47-12 36 0 64 21 76 38 6 9 13 21 22 36l21 41 3 6c77 151.1 144.1 287.1 199.1 407.2l1 1 20 46 12 29c9.2 23.1 11.2 46.1 8.2 70.1zm46-90.1c-7-22-19-48-34-79v-1c-71-151.1-137.1-287.1-200.1-409.2l-4-6c-45-92-77-147.1-170.1-147.1-92 0-131.1 64-171.1 147.1l-3 6c-63 122.1-129.1 258.1-200.1 409.2v2l-21 46c-8 19-12 29-13 32-51 140.1 54 263.1 181.1 263.1 1 0 5 0 10-1h14c66-8 134.1-50 203.1-125.1 69 75 137.1 117.1 203.1 125.1h14c5 1 9 1 10 1 127.1.1 232.1-123 181.1-263.1z">
                        </path>
                       <h2>Take Your Time</h2>
                    </svg> -->
                <h1><a href="/MentoringProject/userHomePage.do">LOGO</a></h1>
            </div>
            <nav>
                <ul>
                    <li><a href="userBeMentorPage.jsp">마스터가 되어보세요</a></li> 
                <li><a href="/MentoringProject/help.do">도움말</a></li>
                <li><a href="/MentoringProject/menteeMyPageOpen.do">마이페이지</a></li>
                <li><a href="/MentoringProject/logout.do">로그아웃</a></li>

                </ul>
            </nav>
        </div>
    </header>

<!--헤더 구역  -->


<section id="section">
<div class="success">
<div class="row">
<% if(isSuccess) { %>
      <h1>결제 성공</h1>
        <h3> 예약신청내역 확인</h3>

	<table>
                    <colgroup>
                    <col>
                    <col>
                    </colgroup>
                    <tr>
                        <th>order id</th>
                        <td>${Payment.paymentpk}</td>
                    </tr>
                    <tr>
                        <th>예약날짜</th>
                        <td>${Payment.startday}</td>
                    </tr>
                    <tr>
                        <th>시간</th>
                        <td>${Payment.starttime}~${Payment.endtime}</td>
                    </tr>
                    <tr>
                        <th>금액</th>
                        <td>${Payment.totalprice}</td>
                    </tr>
                    <tr>
                        <th>전공/부전공</th>
                        <td>${Payment.majorname}/${Payment.submajorname}</td>
                    </tr>
                    <tr>
                        <th>Mentor 이름</th>
                        <td>${Payment.username}</td>
                    </tr>
                    <tr>
                        <th class="scbtn"><a href="/MentoringProject/menteeBookinglist.do">메인으로</a></th>
                        <td class="scbtn"><a href="/MentoringProject/menteeBookingList.do">예약리스트 보러가기</a></td>
                    </tr>
                </table>
        <input type="hidden" value="결과 데이터: <%= jsonObject.toJSONString() %>">
    <% } else { %>
    <h1>결제 실패</h1>
    <p>HTTP error code: <%= code %> </p>
    <p><%= jsonObject.get("message") %></p>
    <span>에러코드: <%= jsonObject.get("code") %></span>
<% } %>
 			</div>
        </div>
</section>

</body>
</html>