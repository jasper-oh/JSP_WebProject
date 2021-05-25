<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<form action="AdminAnnouncementModify.do?noticepk=${adminAnnouncementContentPage.noticepk }" method="post" name="updateForm">
			<table border="0">
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticetitle" size="50" value="${adminAnnouncementContentPage.noticetitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="noticetext">${adminAnnouncementContentPage.noticetext }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="수정" onclick="update()">&nbsp;&nbsp;&nbsp;<a href="AdminAnnouncementList.do">목록보기</a>
				&nbsp;&nbsp;&nbsp;<a href="AdminAnnouncementDelete.do?noticepk=${adminAnnouncementContentPage.noticepk }" class="confirmationB">삭제</a></td>
			</tr>
			</table>
		</form>
		</article>
		  <nav>
	<button type="button" onclick="location.href='AdminAnnouncementList.do' ">Announcement</button>
 	<button type="button" onclick="location.href='adminUserListShowPage.do' ">User</button>
 	<button type="button" class="now" onclick="location.href='adminMajorListShowPage.do' ">Force</button> <br>
 	<button type="button" onclick="location.href='adminReviewList.do' ">Review</button>
 	<button type="button" onclick="location.href='adminQnaList.do' ">QnA</button>
 	<button type="button" onclick="location.href='adminPageShowPayResult.do' ">결제 내역 관리</button>
</nav>
    <aside></aside>
  </div>
  <footer></footer>
		
</body>
<script type="text/javascript">
    var elems = document.getElementsByClassName('confirmationB');
    var confirmIt = function (e) {
        if (!confirm('정말 삭제하시겠습니까?')) e.preventDefault();
    };
    for (var i = 0, l = elems.length; i < l; i++) {
        elems[i].addEventListener('click', confirmIt, false);
    }
    function update(){
        var updateForm = document.updateForm;
        var noticetext = updateForm.noticetext.value;
        var noticetitle = updateForm.noticetitle.value;
        
        if(!noticetext || !noticetitle){
            alert("빈칸을 채워주세요.")
        }else{
        	  if (!confirm('정말 현재 입력한 내용으로 수정하시겠습니까?')) e.preventDefault();
        	    for (var i = 0, l = elems.length; i < l; i++) {
        	        elems[i].addEventListener('click', confirmIt, false);
        	    }
        	updateForm.submit();
        }
    }
</script>
</html>