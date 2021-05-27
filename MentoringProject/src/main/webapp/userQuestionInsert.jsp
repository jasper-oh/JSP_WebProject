<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 작성</title>
</head>
<body>
<form action="userQnaInsert.do" method="post">
<table>
<tr><td>제목 : <input type="text" name="questiontitle" size="40"></td></tr>
<tr><td>내용</td></tr>
<tr>
<td><textarea rows="40" cols="40" name="questiontext"></textarea></td>
</tr>
</table>
<input type="submit" value="등록"><a href="MentoringProject/userQnaList.do">돌아가기</a>
</form>

</body>
</html>
