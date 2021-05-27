<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN ANSWER</title>

</head>
<body>
<form action="adminAnswerUpdateAction.do" method="get">
<table>
		<tr>
			<td align="left"><input type="hidden" name="answerpk" value="${AnswerData.questionpk }"></td>
			<td></td>
			<td></td>
		</tr>
		<%-- <tr>
			<td align="left">작성자 ${AnswerData.username }</td>
		</tr> --%>
		<tr>
			<td align="left">작성날짜 ${AnswerData.indate }</td>
			<td align="left">삭제날짜 ${AnswerData.outdate }</td>
		</tr>
		<tr>
			<td align="left" colspan="3"><textarea rows="3" cols="50">${AnswerData.questiontitle }</textarea>
		</tr>
<td td align="center" colspan="5">
<input type="submit" value="수정"> <input type="button" value="취소" onclick="self.close()">
</td>
</table>
</form>
</body>
</html>