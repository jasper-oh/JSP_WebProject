<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TakeYourTime</title>
	<link rel="stylesheet" href="css/components/loginPage.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/slick.min.js"></script>
</head>
<body>
	<c:if test= "${userid == '' } && ${ !empty loginResult}">
	
		<script>
		
			alert("아이디 혹은 비밀번호가 틀렸습니다.");
			
		</script>
	</c:if> 
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
                <h1><a href="home.do">LOGO</a></h1>
            </div>
            <nav>
                <ul>
                    <!-- <li><a href="userBeMentorPage.jsp">마스터가 되어보세요</a></li> -->
                        <li><a href="visitorShowHelpPage.jsp">도움말</a></li>
                        <li><a href="userSignUpPage.jsp">회원가입</a></li>
                        <li><a href="userLoginPage.jsp">로그인</a></li>
                        <!-- <li><a href="#article2">Force</a></li>
                        <li><a href="#article4">Master</a></li>
                        <li><a href="#article5"></a></li>
                        <li><a href="#none">도움말</a></li> -->
                </ul>
            </nav>
        </div>
    </header>
    	
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
    	
    	<div class="container">
        <div class="login-details">
            <h2>May the Force Be With You</h2>
            <p>Enter your personal detail to login </p>
        </div>
        <div class="login-box">
                <div class="user-box">
                    <span>Take</span><br>
                    <span>Your</span><br>
                    <span>Force</span><br>
                    <!-- 상단 내용 -->
                </div>
                <form action="userLoginPage.do" method="post" name="loginForm">
                    
                    <input type="text" name="userid" placeholder="아이디를 입력해 주세요!">
                    
                    <input type="password" name="userpw" placeholder="비밀번호를 입력해 주세요!">   
                    <input type="submit" name="submit" value="login">
                      <a href="userSignUpPage.jsp">회원가입하기</a>
                      <a href="userFindId.jsp">Forget ID</a>
                      <a href="userFindPw.jsp">Forget PW</a>
                </form>
            </div>
    </div>

		  <!-- <div class="slogan">
    		The force <br>&nbsp;&nbsp;&nbsp; are<br> awaken
    		</div>
		  <div class="cont">
	        <div class="demo">
	          <div class="login">
	            <div class="login__check">
	                <span>&nbsp;&nbsp;&nbsp;Login</span><br>
	                <span>to</span><br>
	                <span>Take your Force</span>
	            </div>
	            <form action="userLoginPage.do" method="post" name="loginForm" onsubmit="">
	                <div class="login__form">
	                <div class="login__row">
	                    <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
	                    <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
	                    </svg>
	                    <input type="text" class="login__input name" placeholder="UserId" name="userid"/>
	                </div>
	                <div class="login__row">
	                    <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
	                    <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
	                    </svg>
	                    <input type="password" class="login__input pass" placeholder="Password" name= "userpw"/>
	                </div>
	                <input type="submit" class="login__submit" value="Login"/>
	                <p class="login__signup">아직 회원이 아니신가요? &nbsp;<a href="userSignUpPage.jsp">회원가입하기</a></p>
	                <p class="login__signup login__findIdPw">ID 를 잃어버리셨나요? &nbsp;<a href="userFindId.jsp"> Id 찾기</a></p>
	                <p class="login__signup login__findIdPw">PW 를 잃어버리셨나요? &nbsp;<a href="userFindPw.jsp"> PW 찾기</a></p>
	                </div>
	            </form>
	          </div>
	          </div>
	     	</div> -->
	     	
	     	
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
	     	

</body>
</html>