<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>공지사항 출력</h2>
	<table border="1" >
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
				<c:forEach items="${noticeList }" var="adminAnnouncementDto">
		<tr>
			<td>${noticeDto.noticePk }</td>
			<td>${noticeDto.admin_adminpk }</td>
			<td>${noticeDto.noticetitle }</td>
			<td><a href="adminAnnouncementContentView?noticepk=${adminAnnouncementDto.noticepk }">${adminAnnouncementDto.noticetext }</a></td>
			<td>${adminAnnouncementDto.indate }</td>

			
		</tr>		
		</c:forEach>
	</table>
		<tr>
			<td colspan="4"><a href="adminAnnouncementWriteView.do">글작성</a></td>
		</tr>
		
</body>
</html>