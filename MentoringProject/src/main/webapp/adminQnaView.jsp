<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA PAGE</title>
</head>
<body>
<!-- 질문내용 -->
<table>
		<tr>
			<td align="left">작성자 ${QuestionData.username }</td>
		</tr>
		<tr>
			<td align="left">작성날짜 ${QuestionData.indate }</td>
		</tr>
		<tr>
			<td align="left">작성날짜 ${QuestionData.outdate }</td>
		</tr>
		<tr>
			<td align="left">제목 ${QuestionData.questiontitle }</td>
		</tr>
		<tr>
			<td align="left">${QuestionData.questionpk }</td>
		</tr>
		<tr>
			<td><textarea rows="40" cols="70">${QuestionData.questiontext }</textarea> </td>
		</tr>
</table>
<div id="adminanswerlist">
<table border="1">
<c:forEach items="${AnswerList }" var="dto2">

		<tr>
			<td style="visibility:hidden">${dto2.questionpk }</td>
		    <td>${dto2.username }</td>
			<td><fmt:formatDate value="${dto2.indate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><fmt:formatDate value="${dto2.outdate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><c:if test="${empty dto2.outdate }">
			       <a href="/MentoringProject/adminAnswerBlock.do?answerpk=${dto2.questionpk }&check=0">삭제</a>
			    </c:if>
			<c:if test="${!empty dto2.outdate }">
			       <a href="/MentoringProject/adminAnswerBlock.do?answerpk=${dto2.questionpk }&check=1">삭제취소</a>
			    </c:if>
			</td>
			</tr>
			<tr>
			<td colspan="4">
		    <c:if test="${!empty dto2.outdate }">
			      <del>${dto2.questiontitle }</del>
		    </c:if>
			<c:if test="${empty dto2.outdate }">
			      ${dto2.questiontitle }
		    </c:if>
			</td>
			<td>
	       <a href="adminAnswerUpdateView.do?answerpk=${dto2.questionpk }" 
				onclick="window.open(this.href, '_blank', 'width=600, height=200'); return false;">
				수정
			</a>
			</td>
			</tr>		
		</c:forEach>
</table>
</div>
<!-- 입력칸 -->
<form action="answerInsertAction.do" method="get">
<table>
<tr><td><textarea name="answertext" cols="70" rows="4"></textarea></td></tr>
<tr><td><input type="submit" value="입력"></td></tr>
</table>
</form>



</body>
<script>
function refrashAnswer(){  
      $("#adminanswerlist").load(window.location.href + "#adminanswerlist");
}
</script>
</html>