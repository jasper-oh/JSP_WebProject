<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER QNA LIST</title>
</head>
<body>
<input type="button" value="질문하기" onclick="location.href='userQuestionInsert.jsp'">
<table>
<tr>
<td></td>
<td></td>
<td>작성자</td>
<td>제목</td>
<td>작성일</td>
<td>답변상태</td>
</tr>
<c:forEach items="${QuestionList }" var="dto" varStatus="status">

		<tr>
			<td style="visibility:hidden">${dto.questionpk }</td>
		    <td>${status.count }</td>
		    <td>${dto.username }</td>
			<td>
			 <a href="userQanView.do?questionpk=${dto.questionpk }">${dto.questiontitle }
			</td>
			<td><fmt:formatDate value="${dto.indate }" pattern="yyyy.MM.dd HH:mm" /></td>
			<td>
			
			</td>
			</tr>		
		</c:forEach>
</table>

</body>
</html>