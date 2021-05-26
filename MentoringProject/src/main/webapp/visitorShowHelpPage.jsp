<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TakeYourTime</title>
	<link rel="stylesheet" href="css/components/loginPage.css">
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
    
    <div class="cont">
		
    
 
		<div class="tab">
		  <button class="tablinks active" onclick="openTab(event, 'tab1')">도움말</button>
		</div>
		
		<div id="tab1" class="tabcontent" style="display: block;">
		 <ol id="help-content"> 
	  <li>
	   <span id="faq-title">일반</span> 
		<div class="faq-content">
		  <button class="question" id="que-1-1"><span id="que-1-1-toggle" ></span>
		  <span>'마스터'란 무엇인가요?</span></button>
		  <div class="answer" id="ans-1-1" style="display: none">
		  		마스터란 해당분야의 전문지식이 있는 사용자를 지칭합니다.<br>
				마스터는 제다이와의 만남을 통해 제다이에게 포스를 전수해 줄 수 있습니다.<br>
				일반적으로 멘토의 역할이 됩니다.<br>
				마스터는 관리자 인증 절차를 거쳐야 진정한 마스터로 거듭날 수 있습니다.</div>
		</div>
		<div class="faq-content">
		<button class="question" id="que-1-2"><span id="que-1-2-toggle"></span>
		<span>'제다이'란 무엇인가요?</span></button>
		<div class="answer" id="ans-1-2" style="display: none">
				제다이란 전문지식이 있는 사용자의 도움을 필요로 하는 사용자를 지칭합니다.<br>
				제다이는 마스터와의 만남을 통해 포스를 전수 받을 수 있습니다.<br>
				일반적으로 멘티의 역할이 됩니다.<br>
				제다이는 가입만 한다면 누구나 될 수 있습니다.</div>
		</div>
		<div class="faq-content">
		  <button class="question" id="que-1-3"><span id="que-1-3-toggle"></span>
		  <span>'포스'란 무엇인가요?</span></button>
		  <div class="answer" id="ans-1-3" style="display: none">
		  		포스란 전문지식을 세분화 한 것을 지칭합니다.<br>
				마스터는 제다이에게 포스를 전수해 줄 수 있으며,<br>
				제다이는 마스터에게 포스를 전수 받을 수 있습니다<br>
				일반적으로 메인포스는 대분류이며 서브포스는 세부분류 입니다.<br>
				포스는 마스터만 등록 할 수 있습니다.</div>
		</div>
		<div class="faq-content">
		  <button class="question" id="que-1-4"><span id="que-1-4-toggle"></span>
		  <span>'포터링'이란 무엇인가요?</span></button>
		  <div class="answer" id="ans-1-4" style="display: none">
		  		포터링이란 마스터와 제다이의 만남을 통해 포스가 전수 되어지는 일련의 행위를 지칭 합니다.<br>
				포터링을 통하여 제다이는 조금 더 마스터에 다다를 수 있으며, 마스터는 포스력을 쌓아갑니다.<br>
				일반적으로 멘토링의 행위 입니다.<br>
				포터링이 이루어지기 위해서는 제다이가 마스터에게 포터링 신청을 하고 마스터가 수락을 해야 합니다.</div>
		</div>
		</li>
		<br>
	  <li>
	  <span id="faq-title">가입/변경/탈퇴</span>
		<div class="faq-content">
		  <button class="question" id="que-2-1"><span id="que-2-1-toggle"></span>
		  <span>마스터로 가입하려면 어떻게하면 되나요?</span></button>
		  <div class="answer" id="ans-2-1" style="display: none">
		  		처음부터 멘토로 가입하시는 것은불가능 합니다.<br>
				최초로 일반 유저로 회원가입 하신 후 멘토가 되어보세요를 클릭하시면 멘토로 가입신청이 가능합니다.</div>
		</div>
		<div class="faq-content">
		<button class="question" id="que-2-2"><span id="que-2-2-toggle"></span>
		<span>등록된 전화번호를 바꾸고 싶어요.</span></button>
		<div class="answer" id="ans-2-2" style="display: none">
				내 프로필 > 프로필 관리 > 개인정보 변경 메뉴에서 전화번호 인증을 거친 후에<br>
				새로운 전화번호로 변경할 수 있습니다.<br>
				내 프로필 > 프로필 설정 > 개인정보 변경 메뉴에 진입해 바꾸고 싶은 전화번호로 변경해보세요.<br>
                한번 변경 후에는 더이상 수정이 불가하니 신중하게 선택해주세요.</div>
		</div>
		<div class="faq-content">
		  <button class="question" id="que-2-3"><span id="que-2-3-toggle"></span>
		  <span>탈퇴하고 싶어요.</span></button>
		  <div class="answer" id="ans-2-3" style="display: none">
		  		내 프로필 > 프로필 관리 > 회원탈퇴 메뉴에서 탈퇴 할 수 있습니다.<br>
				탈퇴는 가입시 등록되어 있던 회원님의 회원 정보를 모두 삭제하는 기능입니다.<br>
                한 번 탈퇴한 후에는 기존의 데이터는 사용할 수 없습니다.</div>
		</div>
		<div class="faq-content">
		  <button class="question" id="que-2-4"><span id="que-2-4-toggle"></span>
		  <span>탈퇴 후 재가입이 가능한가요?</span></button>
		  <div class="answer" id="ans-2-4" style="display: none">
		  		탈퇴 후 재가입은 가능 하지만 기존에 사용한 것과 동일한 이메일 또는<br>
				동일한 연락처로는 가입이 불가능 합니다.</div>
		</div>
		</li>
		<br>
	  <li>
	  	  <span id="faq-title">신고/이용제한</span>
		<div class="faq-content">
		  <button class="question" id="que-3-1"><span id="que-3-1-toggle"></span>
		  <span>불량 사용자를 신고하고싶어요.</span></button>
		  <div class="answer" id="ans-3-1" style="display: none">
		  		신고는 QnA를 통하여 가능합니다.<br>
				불량 사용자로 신고를 당하거나 취지에 맞지 않는 행위를 한 사용자에게는<br>
				관리자 직권으로 이용제한을 할 수 있습니다.<br>
				이용제한이 잦거나 사안이 심각 한 경우 영구 제한될 수 있으므로 주의해주세요.</div>
		</div>
		<div class="faq-content">
		<button class="question" id="que-3-2"><span id="que-3-2-toggle"></span>
		<span>당일 예약취소를 하면 어떻게 되나요?</span></button>
		<div class="answer" id="ans-3-2" style="display: none">
				일방적인 당일 예약취소를 할 경우 선 예약 취소자에게 패널티가 부과되며<br>
				당일 예약취소를 반복할 경우 계정이 제한되므로 주의해주세요.</div>
		</div>
		</li>
		<br>
	  <li>
	  	  <span id="faq-title">스케쥴</span>
		<div class="faq-content">
		  <button class="question" id="que-4-1"><span id="que-4-1-toggle"></span>
		  <span>스케쥴 관리는 어떻게하면 되나요?</span></button>
		  <div class="answer" id="ans-4-1" style="display: none">
		  		내 프로필 > 프로필 관리 > 스케쥴 관리 메뉴에서 스케쥴을 관리 할 수 있습니다.<br>
				단, 이미 완료된 스케쥴이거나 현재시점보다 과거는 스케쥴을 등록/수정/삭제를 할 수 없으니 주의해 주세요.</div>
		</div>
	  </li>
	  <br>
	  <li>
	  	  <span id="faq-title">이용요금/결제 및 환불</span>
		<div class="faq-content">
		  <button class="question" id="que-5-1"><span id="que-5-1-toggle"></span>
		  <span>서비스는 무료인가요?</span></button>
		  <div class="answer" id="ans-5-1" style="display: none">
		  		저희는 멘토링 서비스를 제공하며, 고객님은 자유롭게 궁금한 종목을 검색하여 <br>
		  		해당 종목을 등록한 마스터와 그 세부 종목을 확인할 수 있습니다.<br>
		  		이 모든 서비스는 무료로 제공됩니다.<br>
				단, ‘포터링’ 서비스의 경우 마스터와의 만남을 예약하면서 비용을 결제하게 되는데,<br>
				이는 저희가 아닌 만남을 제공하는 마스터에게 지불되는 것입니다.</div>
		</div>
		<div class="faq-content">
		<button class="question" id="que-5-2"><span id="que-5-2-toggle"></span>
		<span>결제 완료 후 인증 토큰이 생성 되지 않아요. 어떻게 하나요?</span></button>
		<div class="answer" id="ans-5-2" style="display: none">
				1. 결제 계좌번호를 올바르게 입력하셨는지 다시 한번 확인해주세요.<br>
                결제 계좌번호 입력창에는 해당 은행과 본인 명의의 계좌번호 그리고 입금자명을 정확히 입력해 주셔야 합니다.<br>
                예) ㅇㅇ은행 000-0000-0000 홍길동<br><br>
                
                2. 일부 지역의 경우 인터넷 사정에 따라 결제가 완료되기까지 다소 시간이 걸릴 수 있습니다.<br>
                하루가 지나도 인증토큰이 발행되지 않을 경우 고객센터를 통해 문의해주세요.</div>
		</div>
		<div class="faq-content">
		  <button class="question" id="que-5-3"><span id="que-5-3-toggle"></span>
		  <span>결제 취소 후 환불 완료까지는 얼마나 걸리죠?</span></button>
		  <div class="answer" id="ans-5-3" style="display: none">
		  		신용카드및 체크카드의 경우, 결제 취소 후 취소 완료(환불 완료)까지 3~4일 정도 소요되며,<br>
				계좌이체 및 실시간이체의 경우 일주일 정도 소요될 수 있습니다.</div>
		</div>
	  </li> 
	  <br> 
	  <li>
	  	  <span id="faq-title">기타</span>
		<div class="faq-content">
		  <button class="question" id="que-6-1"><span id="que-6-1-toggle"></span>
		  <span>해외에서 사용하고 싶어요. 어떻게 하나요?</span></button>
		  <div class="answer" id="ans-6-1" style="display: none">
		  		해외지역은 현재 서비스 준비중 입니다.<br>
				추후에 지역 입력란에 해당 국가를 선택하신 후, 위치 인증을 거치시면<br>
				사용이 가능하도록 서비스를 준비 중에 있으니 조금만 기다려 주세요!<br>
				감사합니다.</div>
		</div>
		<div class="faq-content">
		<button class="question" id="que-6-2"><span id="que-6-2-toggle"></span>
		<span>검색결과에 원하는 내용이 없는 경우에는 어떻게 하나요?</span></button>
		<div class="answer" id="ans-6-2" style="display: none">
				검색한 키워드와 유사한 키워드로 재검색하시거나,<br>
				화면 하단에 마스터 포스 키워드 / 분야 키워드를 참고하여 재검색해보세요.</div>
		</div>
		<div class="faq-content">
		  <button class="question" id="que-6-3"><span id="que-6-3-toggle"></span>
		  <span>추가 문의하기</span></button>
		  <div class="answer" id="ans-6-3" style="display: none">
		  		원하시는 답변을 찾지못하셨다면, 고객센터로 문의해 주세요.<br>
				<a href="">직접입력하여 문의하기</a></div>
		</div>
	  </li>  
	  </div>
	 </div> 
	 
	<!-- </ol><br> -->
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
		
	<style>
		
		.tab {
		  width: 100%;
		  height: 50px;
		}
		
		.tablinks {
		  float: left;
		  width: 33%;
		  height: 100%;
		  border: none;
		  outline: none;
		  font-size: 16px;
		  font-weight: bold;
		  color: #a6a6a6;
		  background-color: #fff;
		}
		
		.tablinks.active {
		  color: #000;
		  background-color: #a6a6a6;
		}
	</style>
	
	    <!-- 목차 클릭시 내용 접기/ 펴기 스타일-->
	<style>
	  .answer {
	    display: none;
	    padding-bottom: 30px;
	  }
	  #faq-title {
	    font-size: 25px;
	  }
	  .faq-content {
	    border-bottom: 1px solid #e0e0e0;
	  }
	  .question {
	    font-size: 15px;
	    padding: 20px 0;
	    cursor: pointer;
	    border: none;
	    outline: none;
	    background: none;
	    width: 100%;
	    text-align: left;
	  }
	  .question:hover {
	    color: #2962ff;
	  }
	  [id$="-toggle"] {
	    margin-right: 10px;
	  }
	</style>
	
	

			
	<!-- 목차 탭 스크립트-->	  			
			
	<script>
		function openTab(evt, tabName) {
		    var i, tabcontent, tablinks;
		    tabcontent = document.getElementsByClassName("tabcontent");
		    for (i = 0; i < tabcontent.length; i++) {
		      tabcontent[i].style.display = "none";
		    }
		    tablinks = document.getElementsByClassName("tablinks");
		    for (i = 0; i < tablinks.length; i++) {
		      tablinks[i].className = tablinks[i].className.replace(" active", "");
		    }
		    document.getElementById(tabName).style.display = "block";
		    evt.currentTarget.className += " active";
		}
	
	</script>			
      
    	
	<script>
	  const items = document.querySelectorAll('.question');
	
	  function openCloseAnswer() {
	    const answerId = this.id.replace('que', 'ans');
	
	    if(document.getElementById(answerId).style.display === 'block') {
	      document.getElementById(answerId).style.display = 'none';
	      document.getElementById(this.id + '-toggle').textContent = '+';
	    } else {
	      document.getElementById(answerId).style.display = 'block';
	      document.getElementById(this.id + '-toggle').textContent = '-';
	    }
	  }
	
	  items.forEach(item => item.addEventListener('click', openCloseAnswer));
	</script>

	</body>
</html>