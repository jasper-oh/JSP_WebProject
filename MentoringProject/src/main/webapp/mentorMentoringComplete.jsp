<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="mentorHeader.jsp" %>
	<h1>축하드립니다</h1>
	
	<h3>포터링을 성공적으로 마치셨습니다.</h3>
	
	<h4>당신의 멘티에게서 받은 토큰 번호를 입력하면 돈이 바로 송금 됩니다!</h4>
	
	<form action="/MentoringProject/mentorMentoringCompleteTokenCheck.do" method="post">
		
		<input type="text" name="schedulepk" value="<%out.print(request.getParameter("scheduledpk"));%>">
		<input type="text" name="token">
		
		
		<input type="submit" value="토큰 번호 입력">
	
	</form>
	<%@include file="everyFooter.jsp" %>
</body>
</html>