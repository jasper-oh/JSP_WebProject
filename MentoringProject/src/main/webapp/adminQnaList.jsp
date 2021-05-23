<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA LIST</title>
</head>
<body>
<h3>QNA LIST</h3>
	<table border="0">

		
	<!-- 	<tr>
		<td colspan="5"></td>
		<td>
		전부보기<input type="button" name="button" value="null" onclick="getClick(event)" >
		</td>
		<td>
		답변대기<input type="button" name="button" value="wait" onclick="getClick(event)" >
		</td>
		<td>
		답변완료<input type="button" name="button" value="complite" onclick="getClick(event)" >
		</td>
		<td>
		
		</td>
		</tr> -->
		<tr>
			<th style="visibility:hidden">pk</th>
			<th>질문ID</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성날짜</th>
			<th>삭제날짜</th>
			<th>답변상태</th>		
		</tr>
		<c:forEach items="${QuestionData }" var="dto">

		<tr>
		
			<td style="visibility:hidden"></td>
		    <td>${dto.questionpk }</td>
			<td>${dto.username }</td>
			<td><a href="adminQnaView.do?questionpk=${dto.questionpk }">${dto.questiontitle }</a></td>
			<td><fmt:formatDate value="${dto.indate }" pattern="yyyy.MM.dd HH:mm" /></td>
			<td><fmt:formatDate value="${dto.outdate }" pattern="yyyy.MM.dd HH:mm" /></td>
		</tr>		
		</c:forEach>
			



	</table>
</body>
<script type="text/javascript">
function getClick(event) {
		  location.href="adminQanList.do?type="+event.target.value;;
	}

</script>
</html>