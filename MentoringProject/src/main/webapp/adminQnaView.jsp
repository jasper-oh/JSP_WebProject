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
div.row {
	color:#D7FFF1;
}
a.footer{
	color:#77AF9C;
}
</style>
<head>
   <link rel="stylesheet" type="text/css" href="css/starwars.css">
 <link rel="stylesheet" href="css/adminstyle.css">
<meta charset="UTF-8">
<title>NOTICE</title>
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
			<td align="left">작성자</td><td> ${QuestionData.username }</td>
		</tr>
		<tr>
			<td align="left">작성날짜</td><td> ${QuestionData.indate }</td>
		</tr>
		<tr>
			<td align="left">삭날짜</td><td> ${QuestionData.outdate }</td>
		</tr>
		<tr>
			<td align="left">제목</td><td> ${QuestionData.questiontitle }</td>
		</tr>
		<tr>
			<td colspan="2"><textarea rows="15">${QuestionData.questiontext }</textarea> </td>
		</tr>
</table>
<div id="adminanswerlist">
<table>
<c:forEach items="${AnswerList }" var="dto2">

		<tr>
			<td style="visibility:hidden">${dto2.questionpk }</td><td class="l">${dto2.username }</td>
			<td class="l"><fmt:formatDate value="${dto2.indate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td class="l"><fmt:formatDate value="${dto2.outdate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><c:if test="${empty dto2.outdate }">
			       <a href="/MentoringProject/adminAnswerBlock.do?answerpk=${dto2.questionpk }&check=0">삭제</a>
			    </c:if>
			<c:if test="${!empty dto2.outdate }">
			       <a href="/MentoringProject/adminAnswerBlock.do?answerpk=${dto2.questionpk }&check=1">삭제취소</a>
			    </c:if>
			</td>
			</tr>
			<tr>
			<td></td><td colspan="3" class="l">
		    <c:if test="${!empty dto2.outdate }">
			      <del>${dto2.questiontitle }</del>
		    </c:if>
			<c:if test="${empty dto2.outdate }">
			      ${dto2.questiontitle }
		    </c:if>
			</td>
			<td>
	       <a href="adminAnswerUpdateView.do?answerpk=${dto2.questionpk }" 
				onclick="window.open(this.href, '_blank', 'width=460, height=150'); return false;">
				수정
			</a>
			<td align="left" hidden="">${QuestionData.questionpk }</td>
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
 	<button type="button" onclick="location.href='adminPageShowPayResult.do' ">결제 내역 관리</button>
</nav>
<aside></aside>
  </div>
  <footer>
   <div class="row">
            <p>
                <a href="#none" class="footer">회사소개</a>
                <a href="#none" class="footer">사업분야</a>
                <a href="#none" class="footer">갤러리</a>
                <a href="#none" class="footer">온라인문의</a>
                <a href="#none" class="footer">고객센터</a>
            </p>
            <p><span>주소 : 부산광역시 해운대구 좌동 273-10</span> <span class="hide"> / </span> <span>상호 : 디자인선사인</span> <span
                    class="hide"> / </span>사업자등록번호 : 123-456-7890<br>
                <a href="tel:070-7155-19749" class="footer">Tel : 070-7155-19749</a> <span class="hide"> / </span><span>Fax :
                    02-2139-1142</span> <span class="hide"> / </span><a href="mailto:gijung23@nate.com" class="footer">E-mail :
                    gijung23@nate.com</a></p>
            <p>Copyright &copy; Sunsine.com All Rights Reserved.</p>
        </div>
  </footer>
  
</body>
<script>
function refrashAnswer(){  
      $("#adminanswerlist").load(window.location.href + "#adminanswerlist");
}
</script>
</html>
