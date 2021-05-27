<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
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
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/slick.min.js"></script>
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script>
            $(function () {
            	$("#datepicker1").datepicker({ dateFormat: "yy-mm-dd" }).val()
                $("#datepicker1").datepicker();
            });
            $(function () {
            	$("#datepicker2").datepicker({ dateFormat: "yy-mm-dd" }).val()
                $("#datepicker2").datepicker();
            });
        </script>
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
                <h1><a href="/MentoringProject/mentorHomePage.do">LOGO</a></h1>
            </div>
            <nav>
	            <ul>
	                <li><a href="mentorBeAnotherMentor2.jsp">포스정보 추가등록</a></li> 
                <li><a href="/MentoringProject/help.do">도움말</a></li>
                <li><a href="/MentoringProject/showMentorMyPage.do">마이페이지</a></li>
                <li><a href="/MentoringProject/logout.do">로그아웃</a></li>
	            </ul>
                <!-- 멘토가 들어왔을때랑 멘티가 들어왔을때랑 달라짐 -->
                <!-- <ul>
	                <li><a href="/MentoringProject/mentorBookingList.do">예약 신청 내역</a></li>
					<li><a href="/MentoringProject/mentorMentoringList.do">포터링 결제 내역 확인</a></li>
                    <li><a href="/MentoringProject/mentorProductList.do">포스 관리</a></li>
                    <li><a href="/MentoringProject/mentorScheduledList.do">예약관리</a></li>
                   	<li> <a href="/MentoringProject/mentorPayReceiveList.do">정산완료내역</a></li>
					<li><a href="/MentoringProject/mentorReviewView.do">리뷰 보기</a></li>
				</ul> -->
                <!-- 멘토가 들어왔을때랑 멘티가 들어왔을때랑 달라짐 -->
            </nav>
        </div>
        </header>
        
    <section id="section">
        <div class="schedules">
            <div class="row">
              <h3>포터링 가능날짜를 선택하세요</h3>
		         <div class="calendarDesign" >
		    	<jsp:include page="customCalendar.jsp" flush="true"/>
		    	</div>
              <div class="MenteeMentoringListNav subTitle">
            </div>
              <form action="insertScheduleAction.do?" method="get">
                  <table>      
                    <colgroup>
                    <col>
                    <col>
                    <col>
                    <col>
                    </colgroup>
                    <tr >
                          <th>시작 날짜</th>
                          <th>끝 날짜</th>
                          <th>시작시간</th>
                          <th>끝시간</th>
                    </tr>
                    <tr> 
                        <td>
                          <label for="datepicker" />
                          <input type="text" name="startday" id="datepicker1" autocomplete="off">
                        </td>
                        <td>
                          <label for="datepicker" />
                          <input type="text" name="endday" id="datepicker2" autocomplete="off">
                        </td>
                        <td>
                          <select name="starttime">
                              <%
                              for(int i = 10;i<22;i++) { %>
                                  <option value= <%= i %> > <%= i %></option>
                              <% } %>
                              </select>                         
                        </td>
                        <td>
                          <select name="endtime">
                              <%for(int i = 10 ;i<22;i++) { %>
                                  <option value= <%= i %> > <%= i %></option>
                              <% } %>
                          </select>  
                        </td>
                    </tr>
                    <tr>
                        <td><a href="javascript:history.back()">Back</a></td>
                        <td colspan="2"> </td>
                        <td><input type="submit" value="입력"></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
    </section>
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
</body>
</html>