<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:choose>
<c:when test="${result == 1 }">
	<script>

	alert("수정되었습니다.");
	window.open('', '_self', '');
    opener.parent.location.reload();
    window.close();
	</script>	
</c:when>
<c:when test="${result == 0}">
	<script>

	alert("수정 실패되었습니다.");
	
	</script>	
</c:when>
</c:choose>
<meta charset="UTF-8">
<title>Major Name을 변경하세요</title>
</head>
<body>

<form action="adminMajorUpdateAction.do" method="get" name="updateForm">
<table>
		<tr>
			<td align="left"><input type="text" name="majorpk" value="${Major.majorPk }"></td>
		</tr>
		<tr>
			<td align="left"><input type="text" size="20" name="majorname" value="${Major.majorName }"></td>
		</tr>
		<td align="center">
<input type="button" value="수정" onclick="result()"> <input type="button" value="취소" onclick="self.close()">
		</td>
</table>
</form>
</body>
<script type="text/javascript">
function result(){
    var updateForm = document.updateForm;
    var majorname = updateForm.majorname.value;
    
    if(!majorname){
        alert("빈칸을 채워주세요.")
    }else{
    	updateForm.submit();
    }
}
</script>
</html>