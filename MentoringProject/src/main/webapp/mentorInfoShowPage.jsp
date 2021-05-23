<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 정보 조회, 수정 페이지</title>
</head>
<script>
function goPopup(){
	var pop = window.open("/MentoringProject/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
function jusoCallBack(roadFullAddr){
	var addressEI = document.querySelector("#address");
	addressEI.value = roadFullAddr;
}
function setThumbnail(event) {
	var reader = new FileReader(); 
	reader.onload = function(event) { 
			var img = document.createElement("img"); 
			img.setAttribute("src", event.target.result); 
			document.querySelector("div#image_container").appendChild(img); 
					}; 
			reader.readAsDataURL(event.target.files[0]); 
			}


</script>
<body>


<!-- 절대 공백으로 두면 안됨 !!! 공백 처리 해줄것 !!!  -->

	<form action="/MentoringProject/mentorInfoUpdate.do" method="post" enctype="multipart/form-data">
		<c:forEach items="${mentorMyPageInfo }" var="userInfo">
		<div class="mentorInfoBox">
			<div class="mentorImage">
				<img alt="멘토 이미지입니다." src="${userInfo.mentorimage }"><br>
				<span>바꿀 이미지</span><div id="image_container"></div>
				<input type="file" name="mentorimage" id="image" accept="image/*" onchange="setThumbnail(event);">
			</div>
			<div >
				<input type="text" value="${userInfo.userpk }" hidden="true" name="userpk">
				<input type="text" value="${userInfo.mentorpk }" hidden="true" name="mentorpk">
			</div>
			<div class="mentorShortInfo">
				<span>아이디 : </span><input type="text" value="${userInfo.userid }" name="userid" ><br>
				<span>이메일 : </span><input type="email" value="${userInfo.useremail }" name="useremail"><br>
				<span>전화 번호 : </span><input type="text" value="${userInfo.userphone }" name="userphone"><br>
				<span>주소 : </span><input type="text" value="${userInfo.mentoraddress }" id="address" name="mentoraddress" size="50"><br>
				<input type="button" onClick="goPopup();" value="주소 검색"/>
			</div>
			<div>
				<input type="submit" value="저장 하기">
			</div>
		</div>
		</c:forEach>
	</form>
	


</body>
</html>