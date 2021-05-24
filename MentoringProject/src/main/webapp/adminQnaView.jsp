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
<!-- 질문내용 -->
<table>
		<tr>
			<td align="left">작성자 ${QuestionData.username }</td>
		</tr>
		<tr>
			<td align="left">작성날짜 ${QuestionData.indate }</td>
		</tr>
		<tr>
			<td align="left">작성날짜 ${QuestionData.outdate }</td>
		</tr>
		<tr>
			<td align="left">제목 ${QuestionData.questiontitle }</td>
		</tr>
		<tr>
			<td align="left">${QuestionData.questionpk }</td>
		</tr>
		<tr>
			<td><textarea rows="40" cols="70">${QuestionData.questiontext }</textarea> </td>
		</tr>
</table>
<div id="adminanswerlist">
<table border="1">
<c:forEach items="${AnswerList }" var="dto2">

		<tr>
			<td style="visibility:hidden">${dto2.questionpk }</td><td>${dto2.username }</td>
			<td><fmt:formatDate value="${dto2.indate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><fmt:formatDate value="${dto2.outdate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><c:if test="${empty dto2.outdate }">
			       <a href="/MentoringProject/adminAnswerBlock.do?answerpk=${dto2.questionpk }&check=0">삭제</a>
			    </c:if>
			<c:if test="${!empty dto2.outdate }">
			       <a href="/MentoringProject/adminAnswerBlock.do?answerpk=${dto2.questionpk }&check=1">삭제취소</a>
			    </c:if>
			</td>
			</tr>
			<tr>
			<td colspan="4">
		    <c:if test="${!empty dto2.outdate }">
			      <del>${dto2.questiontitle }</del>
		    </c:if>
			<c:if test="${empty dto2.outdate }">
			      ${dto2.questiontitle }
		    </c:if>
			</td>
			<td>
	       <a href="adminAnswerUpdateView.do?answerpk=${dto2.questionpk }" 
				onclick="window.open(this.href, '_blank', 'width=600, height=200'); return false;">
				수정
			</a>
			</td>
			</tr>		
		</c:forEach>
</table>
</div>
<!-- 입력칸 -->
<form action="/MentoringProject/answerInsertAction.do" method="get">
<table>
<tr><td><textarea name="answertext" cols="70" rows="4"></textarea></td></tr>
<tr><td><input type="submit" value="입력"></td></tr>
</table>
</form>
</article>
<nav>
	<button type="button" onclick="location.href='AdminAnnouncementList.do' ">Announcement</button>
 	<button type="button" onclick="location.href='adminUserListShowPage.do' ">User</button>
 	<button type="button" onclick="location.href='adminMajorListShowPage.do' ">Force</button>
 	<button type="button" onclick="location.href='adminReviewList.do' ">Review</button>
 	<button type="button" onclick="location.href='adminQnaList.do' ">QnA</button>
 	<button type="button" onclick="location.href='' ">결제 내역 관리</button>
</nav>
<aside></aside>
  </div>
<footer></footer>
  
</body>
<script>
function refrashAnswer(){  
      $("#adminanswerlist").load(window.location.href + "#adminanswerlist");
}
</script>
</html>

