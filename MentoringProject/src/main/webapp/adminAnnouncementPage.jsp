<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 출력 페이지</title>
</head>
<body>
	<h2>공지사항 출력</h2>
	<table border="0" >
		<tr>
			<td colspan="4"><a href="adminAnnouncementWritePage.jsp">글작성</a></td>
		</tr>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
				<c:forEach items="${announcementList }" var="noticeDto">
		<tr>
			<td>${noticeDto.noticePk }</td>
			<td>${noticeDto.noticeTitle }</td>
			<td>${noticeDto.noticeText }</td>
			<td>${noticeDto.adminPk }</td>
			<td>${noticeDto.inDate }</td>
		</tr>		
		</c:forEach>
		
	</table>


</body>
</html>

