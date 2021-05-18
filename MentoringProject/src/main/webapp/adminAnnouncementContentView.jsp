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
		<form action="adminAnnouncementModify.do" method="post">
			<tr>
				<td>번호</td>
				<td><input type="text" name="noticepk" readonly="readonly" value="${adminAnnouncementContentView.noticepk }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="admin_adminpk" size="20" value="${adminAnnouncementContentView.admin_adminpk }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticeTitle" size="50" value="${adminAnnouncementContentView.noticeTitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="noticetext">${adminAnnouncementContentView.noticetext }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="adminAnnouncement.do">목록보기</a>
				&nbsp;&nbsp;&nbsp;<a href="adminAnnouncementDelete.do?noticepk=${adminAnnouncementContentView.noticepk }">삭제</a></td>
			</tr>
		</form>
	</table>
</body>
</html>