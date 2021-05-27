<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 QNA</title>
</head>
<body>
<form action="userQuestionUpdate.do" >
<table>
		<tr>
			<td align="left">작성자 :</td> <td align="left">${QuestionData.username }</td>
		</tr>
		<tr>
			<td align="left">작성날짜 :</td> <td align="left">${QuestionData.indate }</td>
		</tr>
		<tr>
			<td align="left">제목 :</td><td align="left"><input type="text" name="questiontitle" size="15" readonly="readonly" value="${QuestionData.questiontitle }"></td>
		</tr>
		<tr>
			<td align="left" style="visibility:hidden">${QuestionData.questionpk }</td>
		</tr>
		<tr>
			<td align="right"><input type="button" value="삭제하기" onclick="location.href='userQuestionBlock.do?questionpk=${QuestionData.questionpk }'">
		</tr>
		<tr>
			<td><textarea rows="40" cols="70" name="questiontext" readonly="readonly">${QuestionData.questiontext }</textarea> </td>
		</tr>
</table>
</form>
<div id="adminanswerlist">

<c:forEach items="${AnswerList }" var="dto2" varStatus="status">

		<nav>
			${status.count }
		   ${dto2.username }
		<fmt:formatDate value="${dto2.indate }" pattern="yyyy.MM.dd HH:mm:ss" />
			
		</nav>
			<nav>
			<textarea cols="70" rows="5">${dto2.questiontitle }</textarea>
				
			</nav>
		</c:forEach>

</div>
</body>
</html>