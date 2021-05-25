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
  margin: 0;
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
	<h3>공지사항 List</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.noticepk }</td>
			<td><a href="AdminAnnouncementContent.do?noticepk=${dto.noticepk }">${dto.noticetitle }</a></td>
			<td><fmt:formatDate value="${dto.indate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
		</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
				<td colspan="4" align="center">
 					<c:forEach items="${announcementList }" var="page">
						<a href="AdminAnnouncementList.do?page=${page }">${page}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
 					<c:forEach items="${pageList }" var="page">
						<a href="AdminAnnouncementList.do?page=${page }">${page}</a>
					</c:forEach>
				</td>
			</tr>
		<tr>
			<td colspan="5" align="right"><a href="adminAnnouncementWritePage.jsp">글작성</a></td>
		</tr>	
	</table>
</article>
<nav>
	<button type="button" class="now" onclick="location.href='AdminAnnouncementList.do' ">Announcement</button>
 	<button type="button" onclick="location.href='adminUserListShowPage.do' ">User</button>
 	<button type="button" onclick="location.href='adminMajorListShowPage.do' ">Force</button>
 	<button type="button" onclick="location.href='adminReviewList.do' ">Review</button>
 	<button type="button" onclick="location.href='adminQnaList.do' ">QnA</button>
 	<button type="button" onclick="location.href='adminPageShowPayResult.do' ">결제 내역 관리</button>
</nav>
<aside></aside>
  </div>
<footer></footer>
  
</body>
</html>
