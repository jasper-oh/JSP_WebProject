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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/subpage.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/slick.min.js"></script>
</head>
	<script>
	function goPopup(){
		var pop = window.open("/MentoringProject/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	function jusoCallBack(roadFullAddr){
		var addressEI = document.querySelector("#address");
		addressEI.value = roadFullAddr;
	}
	function setThumbnail(event) {
		var reader = new FileReader(); 
		reader.onload = function(event) { 
				var img = document.createElement("img"); 
				img.setAttribute("src", event.target.result); 
				document.querySelector("div#image_container").appendChild(img); 
						}; 
				reader.readAsDataURL(event.target.files[0]); 
				}
	
	function showButton(){
		document.forms["mentorBasicProfile"].submit();
		
	}
		
		
	</script>
	
<body>
<!-- 유저가 제다이 -->
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


	<!-- 헤더 구역 끝 -->
	<!-- 본문 시작 -->
	<section>
		<article class="subpage page1"> <!-- 단계별로 page뒤에 단계숫자 붙이기-->
			<div class="row">
				<div class="step cf">
					<ul>
						<li>
							1단계
						</li>
						<li>
							2단계
						</li>
						<li>
							3단계
						</li>
						<li>
							4단계
						</li>
					</ul>
				</div>
				<div class="title">
					<h1>1단계 : 개인정보를 입력해 주세요!</h1>
				</div>
				<form action="mentorProfile.do" method="post" id="mentorBasicProfile" enctype="multipart/form-data">
					<div class="container cf">
						<div class="photo">
							<div class="photobox">
								<div id="image_container">
									
								</div>
							</div>
							<button><input type="file" name="mentorimage" id="image" accept="image/*" onchange="setThumbnail(event);"></button>
						</div>
						<div class="content">
							<table>
								<colgroup>
									<col>
									<col>
								</colgroup>
								<tr>
									<th>성별 </th>
									<td>
										<input type="radio" name="mentorgender" value="1" checked="checked">남
										<input type="radio" name="mentorgender" value="0"> 여 
									</td>
								</tr>
								<tr>
									<th>생년월일 </th>
									<td>
										<input type="text" name="year" size="5">년
										<input type="text" name="month" size="5">월
										<input type="text" name="day" size="5">일
									</td>
								</tr>
								<tr>
									<th>주소</th>
									<td>
										<input type="text"  size="50"  name="mentoraddress" id="address" readonly="readonly"  placeholder="도로명 주소">
										<input type="button" onClick="goPopup();" value="주소 검색"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<button>
						<!-- <a href="userBeMentorPage2.html">등록하고 다음으로 넘어가기</a> -->
						<input id= "insertMentorProfile" type="submit" value="등록하고 다음으로 넘어가기" onclick="showButton()">
					</button>
				</form>
			</div>
		</article>
	</section>
	<!-- 본문 끝  -->
	<!-- footer 시작 -->
	<footer id="footer">
        <div class="row">
            <p>
                <a href="#none">회사소개</a>
                <a href="#none">사업분야</a>
                <a href="#none">갤러리</a>
                <a href="#none">온라인문의</a>
                <a href="#none">고객센터</a>
            </p>
            <p><span>주소 : 부산광역시 해운대구 좌동 273-10</span> <span class="hide"> / </span> <span>상호 : 디자인선사인</span> <span
                    class="hide"> / </span>사업자등록번호 : 123-456-7890<br>
                <a href="tel:070-7155-19749">Tel : 070-7155-19749</a> <span class="hide"> / </span><span>Fax :
                    02-2139-1142</span> <span class="hide"> / </span><a href="mailto:gijung23@nate.com">E-mail :
                    gijung23@nate.com</a></p>
            <p>Copyright &copy; Sunsine.com All Rights Reserved.</p>
        </div>
    </footer>
    <div class="gotop"><a href="#"><i class="fas fa-angle-up"></i><br><span>top</span></a></div>

	<script>
		function goPopup(){
			var pop = window.open("/MentoringProject/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		}
		function jusoCallBack(roadFullAddr){
			var addressEI = document.querySelector("#address");
			addressEI.value = roadFullAddr;
		}
		function setThumbnail(event) {
			var reader = new FileReader(); 
			reader.onload = function(event) { 
					var img = document.createElement("img"); 
					img.setAttribute("src", event.target.result); 
					document.querySelector("div#image_container").appendChild(img); 
							}; 
					reader.readAsDataURL(event.target.files[0]); 
					}
		
		function showButton(){
			document.forms["mentorBasicProfile"].submit();
			
		}
	</script>	
	
</body>
</html>