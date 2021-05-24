<%@page import="com.project.mentoring.dto.ShareVar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케쥴 리스트</title>
</head>
<body>
		<table>
			<tr>
				<td colspan="3">스케쥴리스트</td>
				<td colspan="1"></td><td colspan="1"></td>
			</tr>
			<tr>
				<td><a href="/MentoringProject/insertScheduleView.do?productpk=${dto.productpk }">스케쥴추가하기</a></td>
				<td colspan="3"><a href="/MentoringProject/mentorProductPage.do?productpk=<%=ShareVar.productpk%>">돌아가기</a></td>	
			</tr>
	<c:forEach var="dto" items="${MentorScheduleList }" varStatus="status" >
		<tr>
		  	<td align="center"><input type="text" size="3" value="${status.count }" name="count"/></td>
			<td align="center"><input type="text" size="10" value="${dto.startday }" name="startday"/></td>
			<td align="center">
  				<input type="text" size="3" value="${dto.starttime }" name="starttime"/>~
  				<input type="text" size="3" value="${dto.endtime }" name="endtime"/>
  			</td>
  			<td align="center"><input type="text" size="8" value="${dto.totalprice }" name="totalprice"/></td>
			<td align="center">
			  <input type="hidden" name=pk${status.index} value=""/>
			  	<a href="/MentoringProject/deleteSchedule.do?schedulepk=${dto.schedulepk}">삭제</a>
			</td>
		</tr>
	</c:forEach>
		</table>
</body>
<script type="text/javascript">
function deleteAction(schedulepk) {
	    var answer=confirm("선택하신 스케쥴을 마스터의 포스에서 삭제하시겠습니까?");
	         if(answer){
	            var url = 'deleteSchedule.do?schedulepk=' + schedulepk.value;
	                window.open(url, "_self",  '');
	        } 
	    }
}
</script>
</html>