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
<title>SUB FORCE MANAGEMENT</title>
<c:choose>
<c:when test="${subMajorDeleteResult == 1 }">
	<script>

	alert("삭제되었습니다.");
	
	</script>	
</c:when>
<c:when test="${subMajorDeleteResult == 0}">
	<script>

	alert("사용중인 데이터는 삭제할 수 없습니다.");
	
	</script>	
</c:when>
</c:choose>
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
	<h3> SUB FORCE "<%=request.getParameter("majorname") %>"</h3>
		<table border="0">
		<thead>
		<tr>
		<th>관리번호</th>
		<th>이름</th>
		<th></th>
		<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${subMajorList }" var="subMajorDto">
		<tr>
		<td>${subMajorDto.submajorPk }</td>
		<td><input type="text" readonly="readonly" name="submajornameid" value="${subMajorDto.submajorName }" size="20"> </td>
		<td><a href="adminSubMajorUpdateView.do?submajorpk=${subMajorDto.submajorPk}" 
		onclick="window.open(this.href, '_blank', 'width=200, height=50'); return false;">
					수정
		</a></td>
		<td><input type="button" value="삭제" class="confirmation" onclick="location.href='adminSubmajorDeleteAction.do?submajorpk=${subMajorDto.submajorPk }&majorname=<%=request.getParameter("majorname") %>&majorpk=<%=request.getParameter("majorpk") %>'"> </td>
		</tr>
		</c:forEach>
		</tbody>
		<tr>
		<td colspan="3"><a href="adminManagementSubMajorInsertPage.jsp?majorpk=<%=request.getParameter("majorpk") %>&majorname=<%=request.getParameter("majorname")%>">세부전공 추가</a></td>
		</tr>
		</table>
</article>
<nav>
	<button type="button" onclick="location.href='AdminAnnouncementList.do' ">Announcement</button>
 	<button type="button" onclick="location.href='adminUserListShowPage.do' ">User</button>
 	<button type="button" class="now" onclick="location.href='adminMajorListShowPage.do' ">Force</button>
 	<button type="button" onclick="location.href='adminReviewList.do' ">Review</button>
 	<button type="button" onclick="location.href='adminQnaList.do' ">QnA</button>
 	<button type="button" onclick="location.href='adminPageShowPayResult.do' ">결제 내역 관리</button>
</nav>
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
	<script type="text/javascript">
    var elems = document.getElementsByClassName('confirmation');
    var confirmIt = function (e) {
        if (!confirm('정말 삭제하시겠습니까?')) e.preventDefault();
    };
    for (var i = 0, l = elems.length; i < l; i++) {
        elems[i].addEventListener('click', confirmIt, false);
    }
</script>
</html>