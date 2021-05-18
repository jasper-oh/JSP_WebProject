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
		<form action="adminAnnouncementDelete.do" method="post">
			<tr>
				<td>제목</td>
				<td><input type="text" name="Title" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" col="50" name="Content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;&nbsp;<a href="adminAnnouncement.do">목록보기</a></td>
			</tr>
		
		</form>
	</table>
</body>
</html>