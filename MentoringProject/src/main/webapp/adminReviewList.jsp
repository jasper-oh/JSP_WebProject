<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,600;1,600&display=swap');
* {
  box-sizing: border-box; 
}
body {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
  margin: 0;a
}
#main {
  display: flex;
  flex: 1;
}
#main > article {
	text-align: center;
  flex: 1;
}
#main > nav, 
#main > aside {
  flex: 0 0 17vw;
  background: ;
}
#main > nav {
  order: -1;
}
header {
  background: #285943;
  height: 35vh;
  position: relative;
  text-align: right;
}
 footer {
  background: #285943;
  height: 25vh;
  position: relative;
  text-align: right;
}
header, footer, article, nav, aside {
  padding: 1em;
}
button {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}
button {
    width:180px;
    background-color: #285943;
    border: none;
    color:#D7FFF1;
    padding: 30px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-family: 'Montserrat', sans-serif;
    font-size: 20px;
    margin: 5px;
    cursor: pointer;
    border-radius:10px 0 10px 0;
}
button.now {
    background-color: #8CD790;
}
</style>
<head>
   <link rel="stylesheet" type="text/css" href="css/starwars.css">
  <!--  <link rel="stylesheet" type="text/css" href="css/adminstyle.css"> -->
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
<header>
  <div class="starwars-demo">
    <img src="//cssanimation.rocks/demo/starwars/images/star.svg" alt="Star" class="star">
    <img src="//cssanimation.rocks/demo/starwars/images/wars.svg" alt="Wars" class="wars">
    <h2 class="byline" id="byline">The Force Awakens</h2>
  </div>
</header>
  <div id="main">
<article>
<h3>REVIEW LIST</h3>
	<form action="adminReviewList.do" method="get">
	<table border="0">
		<tr>
		<td colspan="2"></td>
		<td>
		<input type="button" name="button" value="All" onclick="getClick(event)">
		</td>
		<td>
		<input type="button" name="button" value="Block" onclick="getClick(event)">
		</td>
		<td>
		<input type="button" name="button" value="General" onclick="getClick(event)">
		</td>
		<td>
		<select name="where">
		<option value="username">작성자</option>
		<option value="review">리뷰내용</option>
		<option value="title">작성된 포스</option>
		</select>
		</td>
		<td>
		<input type="text" name="keyword">
		</td>
		<td>
		<input type="submit" value="검색">
		</td>
		</tr>
		<tr>
	</table>
	</form>
	<table>
		<tr>
			<th>review pk</th>
			<th>producttitle</th>
			<th>작성자</th>
			<th>리뷰제목</th>
			<th>리뷰내용</th>
			<th>score</th>
			<th>작성시간</th>
			<th>차단시간</th>
			<th>-</th>

		</tr>
		<c:forEach items="${ReviewData }" var="dto">
		<tr>
			<td>${dto.reviewpk }</td>
			<td>${dto.title }</td>
		    <td>${dto.username }</td>
			<td>${dto.reviewtitle }</td>
			<td>${dto.reviewtext }</td>
			<td>${dto.reviewscore }</td>
			<td><fmt:formatDate value="${dto.indate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><fmt:formatDate value="${dto.outdate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
<td>
	<c:if test="${empty dto.outdate }">
       <a href="/MentoringProject/adminReviewBlock.do?paymentpk=${dto.reviewpk }&id=0&reviewpk=${dto.reviewpk }">차단하기</a>
    </c:if>
	<c:if test="${!empty dto.outdate }">
       <a href="/MentoringProject/adminReviewBlock.do?paymentpk=${dto.reviewpk }&id=1&reviewpk=${dto.reviewpk }&button=">차단해제</a>
    </c:if>
</td> 
		</tr>		
		</c:forEach>
	</table>
	
		<table>
		<tr>
			<td colspan="4" align="center">
				<!-- 페이징 부분 -->
				<c:forEach items="${pageList }" var="page">
					<a href="adminReviewList.do?page=${page }">${page}</a>
				</c:forEach>
			</td>
		</tr>
	</table>
</article>
<nav>
	<button type="button" onclick="location.href='AdminAnnouncementList.do' ">Announcement</button>
 	<button type="button" onclick="location.href='adminUserListShowPage.do' ">User</button>
 	<button type="button" onclick="location.href='adminMajorListShowPage.do' ">Force</button>
 	<button type="button" class="now" onclick="location.href='adminReviewList.do' ">Review</button>
 	<button type="button" onclick="location.href='adminQnaList.do' ">QnA</button>
 	<button type="button" onclick="location.href='' ">결제 내역 관리</button>
</nav>
<aside></aside>
  </div>
<footer>
</footer>
  
</body>
</html>
