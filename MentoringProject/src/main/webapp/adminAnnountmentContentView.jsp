<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="0">
		<form action="adminAnnouncement.do" method="post">
			<input type="hidden" name="bId" value="${adminAnnouncementContentView.bId }">
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" value="${adminAnnouncementContentView.bTitle}">></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" col="50" name="bContent">${adminAnnouncementContentView.bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list.do">목록보기</a>
				&nbsp;&nbsp;&nbsp;<a href="delete.do?bId=${adminAnnouncementContentView.bId }">삭제</a></td>
			</tr>
		
		
		</form>
	</table>
</body>
</html>