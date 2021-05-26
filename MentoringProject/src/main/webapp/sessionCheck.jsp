<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션값 확인 출력공간</title>
</head>
<body>
	<% out.println(session.getAttribute("userid")); %>
	<%out.println(session.getAttribute("userpk")); %>
	<%out.println(session.getAttribute("userCheck")); %>
	<%out.println(session.getAttribute("username")); %>

</body>
</html>