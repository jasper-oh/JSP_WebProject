<%@page import="com.project.mentoring.dto.AdminMajorListDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.mentoring.dao.AdminMajorListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<%
			
			AdminMajorListDao adminMajorListDao = new AdminMajorListDao();
			ArrayList<AdminMajorListDto> adminMajorList = adminMajorListDao.majorList();
			
			
			
%>

<!-- 방문자가 보는 페이지 -->
   
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
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/slick.min.js"></script>
</head>
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
    <section>
        <article id="article1">
            <div class="slide_group">
                <div class="slide slide1"></div>
                <div class="slide slide2"></div>
                <div class="slide slide3"></div>
                <div class="slide slide4"></div>
                <div class="slide slide5"></div>
            </div>
            <div class="search_box">
                <div class="search_title">
                    <h2>당신의 마스터를<br>검색해보세요.</h2>
                </div>
                <form action="userShowSearchListPage.do" method="post" class="cf">
                    <table>
                        <tr>
                            <td colspan="2" class="search_sub_title">위치로 검색하기</td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <select class="search_input" name="mentoraddress">
                                    <option value="서울특별시">서울특별시</option>
                                    <option value="경기도">경기도</option>
                                    <option value="강원도">강원도</option>
                                    <option value="충청북도">충청북도</option>
                                    <option value="충청남도">충청남도</option>
                                    <option value="전라북도">전라북도</option>
                                    <option value="전라남도">전라남도</option>
                                    <option value="경상북도">경상북도</option>
                                    <option value="경상남도">경상남도</option>
                                    <option value="인천광역시">인천광역시</option>
                                    <option value="세종특별자치시">세종특별자치시</option>
                                    <option value="울산광역시">울산광역시</option>
                                    <option value="대구광역시">대구광역시</option>
                                    <option value="부산광역시">부산광역시</option>
                                    <option value="제주특별시">제주특별시</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="search_sub_title">분야별 검색하기</td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <select class="search_input" name="mentorMajor" onchange="handleOnChange(this)">
                            
                                    <option value="0" selected="selected">
                                                전공을 선택해주세요!
                                    </option>
                                                                    
                                    <%for(int i = 0; i < adminMajorList.size() ; i++){ %>
                                    <option value="<%out.print(adminMajorList.get(i).getMajorName()); %>">
                                            <%out.print(adminMajorList.get(i).getMajorName());%>
                                    </option>
                                        <%} %>
                        
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="search_sub_title">세부분야 검색하기</td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="search_input" type="text" name="mentorSubMajor"></td>
                        </tr>
                    </table>
                    <div class="search_button">
                        <input class="button" type="submit" value="검색">
                    </div>
                <!-- <div class="search__button"><a href="searchPage.html">검색</a></div> -->
                </form>
            </div>
        </article>
        <article id="article2">
            <div class="row">
                <div class="sec_title">
                    Take Your Time 분야별 둘러보기
                </div>
                <ul class="cf">
                    <li>
                        <div class="imgbox">
                            <img src="./img/banner01.jpg" alt="">
                            <div class="sbox">
                                <a href="/MentoringProject/HompageCategorySearch.do?majornum=1"><p>소프트웨어개발</p></a>
                            </div>
                            <div class="line">
                                <div class="topline"></div>
                                <div class="bottomline"></div>
                                <div class="rightline"></div>
                                <div class="leftline"></div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="imgbox">
                            <img src="./img/banner02.jpg" alt="">
                            <div class="sbox">
                                <a href="/MentoringProject/HompageCategorySearch.do?majornum=2"><p>디자인</p></a>
                            </div>
                            <div class="line">
                                <div class="topline"></div>
                                <div class="bottomline"></div>
                                <div class="rightline"></div>
                                <div class="leftline"></div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="imgbox">
                            <img src="./img/banner03.jpg" alt="">
                            <div class="sbox">
                                <a href="/MentoringProject/HompageCategorySearch.do?majornum=3"><p>예술</p></a>
                            </div>
                            <div class="line">
                                <div class="topline"></div>
                                <div class="bottomline"></div>
                                <div class="rightline"></div>
                                <div class="leftline"></div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="imgbox">
                            <img src="./img/banner01.jpg" alt="">
                            <div class="sbox">
                                <a href="/MentoringProject/HompageCategorySearch.do?majornum=4"><p>운동</p></a>
                            </div>
                            <div class="line">
                                <div class="topline"></div>
                                <div class="bottomline"></div>
                                <div class="rightline"></div>
                                <div class="leftline"></div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </article>
        <article id="article3">
            <div class="row">
                <div class="art3_box">
                    <img src="img/master_2.jfif" alt="">
                    <div>
                        <h2>Take Your Time Premium을<br>만나보세요!</h2>
                        <p>퀄리티와 실력이 검증된 마스터 PICK!</p>
                        <a href="#none">자세히 알아보기</a>
                    </div>
                </div>
            </div>
        </article>
        <article id="article4">
        </article>
        <article id="article5">
            <div class="row">
                <div class="sec_title">마스터 프로필</div>
                <div class="home__box">
                    <c:forEach items="${mentorProfile1 }" var="mentorProfile1">
                        <div class="home">
                            <div class="home__img1"><img src="${mentorProfile1.mentorImage }" alt="mentorImage"></div>
                            <div class="home__info">
                                <div class="info1">${mentorProfile1.mentorMajor }</div>
                                <div class="info2">${mentorProfile1.mentorTitle }</div>
                                <div class="info3">
                                    <span class="star">${mentorProfile1.mentorSubMajor }</span>
                                    <span class="count">${mentorProfile1.productPk }</span>
                                    <span class="type">${mentorProfile1.mentorName }</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:forEach items="${mentorProfile2 }" var="mentorProfile2">
                        <div class="home">
                            <div class="home__img2"><img src="${mentorProfile2.mentorImage }" alt="mentorImage"></div>
                            <div class="home__info">
                                <div class="info1">${mentorProfile2.mentorMajor }</div>
                                <div class="info2">${mentorProfile2.mentorTitle }</div>
                                <div class="info3">
                                    <span class="star">${mentorProfile2.mentorSubMajor }</span>
                                    <span class="count">${mentorProfile2.productPk }</span>
                                    <span class="type">${mentorProfile2.mentorName }</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
    
                    <c:forEach items="${mentorProfile3 }" var="mentorProfile3">
                        <div class="home">
                            <div class="home__img3"><img src="${mentorProfile3.mentorImage }" alt="mentorImage"></div>
                            <div class="home__info">
                                <div class="info1">${mentorProfile3.mentorMajor }</div>
                                <div class="info2">${mentorProfile3.mentorTitle }</div>
                                <div class="info3">
                                    <span class="star">${mentorProfile3.mentorSubMajor }</span>
                                    <span class="count">${mentorProfile3.productPk }</span>
                                    <span class="type">${mentorProfile3.mentorName }</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
    
                    <c:forEach items="${mentorProfile4 }" var="mentorProfile4">
                        <div class="home">
                            <div class="home__img4"><img src="${mentorProfile4.mentorImage }" alt="mentorImage"></div>
                            <div class="home__info">
                                <div class="info1">${mentorProfile4.mentorMajor }</div>
                                <div class="info2">${mentorProfile4.mentorTitle }</div>
                                <div class="info3">
                                    <span class="star">${mentorProfile4.mentorSubMajor }</span>
                                    <span class="count">${mentorProfile4.productPk }</span>
                                    <span class="type">${mentorProfile4.mentorName }</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </article>
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

    <script src="js/index.js"></script>
</body>

</html>