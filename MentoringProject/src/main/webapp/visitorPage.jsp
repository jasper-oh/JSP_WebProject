<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 방문자가 보는 페이지 -->
   
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Take Your Time</title>    
    <link rel="stylesheet" href="css/styles.css">
    <link rel="shortcut icon" sizes="76x76" type="image/x-icon"
        href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
</head>
</head>
<body>
    <header>
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
                <ul>
                    <li><a href="#">도움말</a></li>
                    <li><a href="userSignUpPage.jsp">회원가입</a></li>
                    <li><a href="userLoginPage.jsp">로그인</a></li>
                </ul>
            </div>
        </nav>
        <section>
            <div class="search__box">
                <div class="search__title">당신의 멘토를<br /> 검색해 보세요.</div>
               	<form action="" method="post">
	                <table>
	                    <tr>
	                        <td colspan="2" class="search__sub__title">위치로 검색하기</td>
	                    </tr>
	                    <tr>
	                        <td colspan="2"><input class="search__input" type="text" placeholder=" 모든 위치"></td>
	                    </tr>
	                    <tr>
	                        <td class="search__sub__title">분야별 검색하기</td>
	                    </tr>
	                    <tr>
	                        <td colspan="2">
	                            <select class="search__input" >
	                                <option>프로그래밍</option>
	                                <option>디자인</option>
	                                <option>경영/경제</option>
	                                <option>예술</option>
	                            </select>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2" class="search__sub__title">이름으로 검색하기</td>
	                    </tr>
	                    <tr>
	                        <td><input class="search__input"  type="text" /></td>
	                    </tr>
	                </table>
                </form>
                <div class="search__button"><button>검색</button></div>
            </div>
        </section>
    </header>
    <main>
        <section>
            <div class="sec__title">
                Take Your Time 분야별 둘러보기
            </div>
            
            <div class="card__box">
            		<a href="#">
	                	<div class="card">
	                    	<div class="card__img1 card__img"></div>
	                    	<div class="card__content">프로그래밍</div>
	                	</div>
                	</a>
                	<a href="#">
		                <div class="card">
		                    <div class="card__img2 card__img"></div>
		                    <div class="card__content">디자인</div>
		                </div>
                	</a>
                <a href="#">
	                <div class="card">
	                    <div class="card__img3 card__img"></div>
	                    <div class="card__content">예술</div>
	                </div>
                </a>
                <a href="#">
	                <div class="card">
	                    <div class="card__img4 card__img"></div>
	                    <div class="card__content">운동</div>
	                </div>
                </a>
            </div>
        </section>
        <section>
            <div class="ad1"></div>
        </section>
        <section>
            <div class="sec__title">분야별 최고의 멘토</div>
            <div class="choo__box">
                <div class="choo_img1"></div>
                <div class="choo_img2"></div>
                <div class="choo_img3"></div>
                <div class="choo_img4"></div>
                <div class="choo_img5"></div>
            </div>
        </section>
        <section>
            <div class="sec__title2">Take Your Time Premium 을 만나보세요!</div>
            <div class="sec__content">퀄리티와 실력이 검증된 멘토 PICK!</div>
            <div class="ad2"></div>
        </section>
    </main>
</body>
</html>