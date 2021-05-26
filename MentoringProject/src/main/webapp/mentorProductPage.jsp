<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
            </nav>
        </div>
    </header>
    <section>
		<article class="subpage mppage">
			<div class="row">
				<div class="box1">
					<div class="myforcebox">
						<h2>나의 Force</h2>
						<form action="/MentoringProject/mentorProductUpdate.do">
							<table>
								<colgroup>
									<col>
									<col>
								</colgroup>
								<tbody>
									<tr>
										<th>Force Number</th>
										<td><input type="text" name="productpk" value="${ProductPage.productpk }" readonly="readonly"></td>
									</tr>
									<tr>
										<th>전공</th>
										<td colspan="2">${ProductPage.majorname }</td>
									</tr>
									<tr>
										<th>부전공</th>
										<td colspan="2">${ProductPage.submajorname }</td>
									</tr>
									<tr>
										<th>title</th>
										<td colspan="2"><input type="text" name="title" value = "${ProductPage.title }"></td>
									</tr>
									<tr>
										<th>가격</th>
										<td colspan="2"><input type="text" name="price" value = "${ProductPage.price }"></td>
									</tr>
									<tr>
										<th>소개</th>
										<td colspan="2"><input type="text" name="introduce" value = "${ProductPage.introduce }"></td>
									</tr>
									<tr>
										<td><input type="submit" value="수정"></td>			
										<td colspan="3"><a href="/MentoringProject/mentorProductList.do">돌아가기</a></td>
									</tr>		
								</tbody>
							</table>
						</form>
					</div>
					<!-- 시작 -->
					<div class="productbox">
						<h2>스케줄 리스트</h2>
						
						<table>
							<colgroup>
							<col>
							<col>
							<col>
							<col>
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>가능날짜</th>
									<th>시작시간</th>
									<th>끝시간</th>
									<th>총 가격</th>
									<th><a href="/MentoringProject/insertScheduleView.do?productpk=${ScheduleDto.productpk }">스케쥴추가하기</a></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="ScheduleDto" items="${MentorScheduleList }" varStatus="status" >
								<tr>
			  						<td align="center">
			  							<input type="text" size="3" value="${status.count }" name="count"/>
			  						</td>
									<td align="center">
										<input type="text" size="10" value="${ScheduleDto.startday }" name="startday"/>
									</td>
									<td align="center">
	  										<input type="text" size="3" value="${ScheduleDto.starttime }" name="starttime"/>
	  										~
	  										<input type="text" size="3" value="${ScheduleDto.endtime }" name="endtime"/>
	  								</td>
	  								<td align="center">
	  										<input type="text" size="8" value="${ScheduleDto.totalprice }" name="totalprice"/>
	  								</td>
									<td align="center">
				  						<input type="hidden" name=pk${status.index} value=""/>
				  						<a href="/MentoringProject/deleteSchedule.do?schedulepk=${ScheduleDto.schedulepk}">삭제</a>
									</td>
								</tr>
							</c:forEach>
									<tr>
										<td colspan="4" align="center">
							<!-- 페이징 부분 -->
										<c:forEach items="${pageList }" var="page">
										<a href="mentorProductPage.do?page=${page }">${page}</a>
							</c:forEach>
									</td>
									</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="reviewbox">
					<h2>리뷰 리스트</h2>
					<table>
						<colgroup>
						<col>
						<col>
						<col>
						<col>
						</colgroup>
						<thead>
							<tr>
								<th>작성자명</th>
								<th>리뷰 제목</th>
								<th>리뷰내용</th>
								<th>리뷰 점수</th>
								<th>리뷰 작성된 날짜</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${mentorReviewView }" var="ReviewDto">
							<tr>
								<td><input type="text" name="username" size="10" value= "${ReviewDto.username }" disabled="disabled"></td>
								<td><input type="text" name="reviewtitle" value = "${ReviewDto.reviewtitle }" disabled="disabled" size="50"></td>
								<td><input type="text" name="reviewtext" value = "${ReviewDto.reviewtext }" disabled="disabled" size="50"></td>
								<td><input type="text" name="reviewscore" value = "${ReviewDto.reviewscore }" disabled="disabled" size="10"></td>
								<td><input type="text" name="indate" value = "<fmt:formatDate value="${ReviewDto.indate }" pattern="yyyy.MM.dd" />" disabled="disabled" size="20"></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</article>
	</section>
    
<%-- 		<h3>나의 Product</h3>
	<form action="/MentoringProject/mentorProductUpdate.do">
	<table border="1">
		<tr>
			<td>id</td>
			<td colspan="2"><input type="text" name="productpk" value="${ProductPage.productpk }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>전공</td>
			<td colspan="2">${ProductPage.majorname }</td>
		</tr>
		<tr>
			<td>부전공</td>
			<td colspan="2">${ProductPage.submajorname }</td>
		</tr>
		<tr>
			<td>title</td>
			<td colspan="2"><input type="text" name="title" value = "${ProductPage.title }"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td colspan="2"><input type="text" name="price" value = "${ProductPage.price }"></td>
		</tr>
		<tr>
			<td>소개</td>
			<td colspan="2"><input type="text" name="introduce" value = "${ProductPage.introduce }"></td>
		</tr>
		<tr>
			<td colspan="3">스케쥴리스트</td>
		</tr>
		<tr>
			<td><input type="submit" value="수정"></td>			
			<td colspan="3"><a href="/MentoringProject/mentorProductList.do">돌아가기</a></td>
		</tr>					
	</table>
		</form>
		<table>
			<tr>
				<td colspan="3">스케쥴리스트</td>
				<td colspan="1"></td><td colspan="1"></td>
				<td><a href="/MentoringProject/insertScheduleView.do?productpk=${ScheduleDto.productpk }">스케쥴추가하기</a></td>
			</tr>
			<c:forEach var="ScheduleDto" items="${MentorScheduleList }" varStatus="status" >
			<tr>
			  	<td align="center"><input type="text" size="3" value="${status.count }" name="count"/></td>
				<td align="center"><input type="text" size="10" value="${ScheduleDto.startday }" name="startday"/></td>
				<td align="center">
	  				<input type="text" size="3" value="${ScheduleDto.starttime }" name="starttime"/>~
	  				<input type="text" size="3" value="${ScheduleDto.endtime }" name="endtime"/>
	  			</td>
	  			<td align="center"><input type="text" size="8" value="${ScheduleDto.totalprice }" name="totalprice"/></td>
				<td align="center">
				  <input type="hidden" name=pk${status.index} value=""/>
				  	<a href="/MentoringProject/deleteSchedule.do?schedulepk=${ScheduleDto.schedulepk}">삭제</a>
				</td>
			</tr>
	</c:forEach>
		</table>
		<table border="0">
		<tr>
			<th>유저네임</th>
			<th>리뷰 타이틀</th>
			<th>리뷰 점수</th>
			<th>리뷰 작성된 날짜</th>
		</tr>
		<c:forEach items="${mentorReviewView }" var="ReviewDto">
		<tr>
			<td><input type="text" name="username" size="20" value= "${ReviewDto.username }" disabled="disabled"></td>
			<td><input type="text" name="reviewtitle" value = "${ReviewDto.reviewtitle }" disabled="disabled" size="50"></td>
			<td><input type="text" name="reviewtext" value = "${ReviewDto.reviewtext }" disabled="disabled" size="50"></td>
			<td><input type="text" name="reviewscore" value = "${ReviewDto.reviewscore }" disabled="disabled" size="50"></td>
			<td><input type="text" name="indate" value = "<fmt:formatDate value="${ReviewDto.indate }" pattern="yyyy.MM.dd" />" disabled="disabled" size="50"></td>
		</tr>
	</c:forEach>
	</table> --%>
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