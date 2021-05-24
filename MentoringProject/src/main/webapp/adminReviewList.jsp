<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REVIEW LIST</title>
</head>
<body>
<h3>REVIEW LIST</h3>
	<form action="adminReviewList.do" method="get">
	<table border="0">
		<tr>
		<td colspan="2"></td>
		<td>
		<input type="button" name="button" value="All" onclick="getClick(event)">
		</td>
		<td>
		<input type="button" name="button" value="Block" onclick="getClick(event)">
		</td>
		<td>
		<input type="button" name="button" value="General" onclick="getClick(event)">
		</td>
		<td>
		<select name="where">
		<option value="username">작성자</option>
		<option value="review">리뷰내용</option>
		<option value="title">작성된 포스</option>
		</select>
		</td>
	<!-- 	<td>
		<select name="orderby">
		<option value="asc">오름차순</option>
		<option value="desc">내림차순</option>
		</select>
		</td> -->
		<td>
		<input type="text" name="keyword">
		</td>
		<td>
		<input type="submit" value="검색">
		</td>
		</tr>
		<tr>
	</table>
	</form>
	<table>
		<tr>
			<th>review pk</th>
			<th>producttitle</th>
			<th>작성자</th>
			<th>리뷰제목</th>
			<th>리뷰내용</th>
			<th>score</th>
			<th>작성시간</th>
			<th>차단시간</th>
			<th>-</th>

		</tr>
		<c:forEach items="${ReviewData }" var="dto">
		<tr>
			<td>${dto.reviewpk }</td>
			<td>${dto.title }</td>
		    <td>${dto.username }</td>
			<td>${dto.reviewtitle }</td>
			<td>${dto.reviewtext }</td>
			<td>${dto.reviewscore }</td>
			<td><fmt:formatDate value="${dto.indate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><fmt:formatDate value="${dto.outdate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
<td>
	<c:if test="${empty dto.outdate }">
       <a href="/MentoringProject/adminReviewBlock.do?paymentpk=${dto.reviewpk }&id=0&reviewpk=${dto.reviewpk }">차단하기</a>
    </c:if>
	<c:if test="${!empty dto.outdate }">
       <a href="/MentoringProject/adminReviewBlock.do?paymentpk=${dto.reviewpk }&id=1&reviewpk=${dto.reviewpk }&button=">차단해제</a>
    </c:if>
</td> 
		</tr>		
		</c:forEach>
	</table>
	
</body>
<script type="text/javascript">
function getClick(event) {
		  location.href="adminReviewList.do?button="+event.target.value;;
	}
</script>
</html>
