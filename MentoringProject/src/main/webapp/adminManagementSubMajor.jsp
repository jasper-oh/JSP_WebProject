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
	<h2><%=request.getParameter("majorname") %> 전공 의 세부전공 관리 페이지 입니다.</h2>
		<table border="0">
		<tr>
		<th>관리번호</th>
		<th>이름</th>
		</tr>
		<c:forEach items="${subMajorList }" var="subMajorDto">
		<tr>
		<td>${subMajorDto.submajorPk }</td>
		<td><input type="text" name="submajornameid" value="${subMajorDto.submajorName }" size="20"> </td>
		<td><a href="adminSubMajorUpdateView.do?submajorpk=${subMajorDto.submajorPk}" 
		onclick="window.open(this.href, '_blank', 'width=200, height=50'); return false;">
					수정
		</a></td>
		<td><input type="button" value="삭제" onclick="location.href='adminSubmajorDeleteAction.do?submajorpk=${subMajorDto.submajorPk }&majorname=<%=request.getParameter("majorname") %>&majorpk=<%=request.getParameter("majorpk") %>'"> </td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="2"><a href="adminManagementSubMajorInsertPage.jsp?majorpk=<%=request.getParameter("majorpk") %>&majorname=<%=request.getParameter("majorname")%>">세부전공 추가</a></td>
		</tr>
		</table>
</article>
<nav>
	<button type="button" onclick="location.href='AdminAnnouncementList.do' ">Announcement</button>
 	<button type="button" onclick="location.href='adminUserListShowPage.do' ">User</button>
 	<button type="button" class="now" onclick="location.href='adminMajorListShowPage.do' ">Force</button>
 	<button type="button" onclick="location.href='adminReviewList.do' ">Review</button>
 	<button type="button" onclick="location.href='adminQnaList.do' ">QnA</button>
 	<button type="button" onclick="location.href='' ">결제 내역 관리</button>
</nav>
<aside></aside>
  </div>
<footer></footer>
  
</body>
</html>