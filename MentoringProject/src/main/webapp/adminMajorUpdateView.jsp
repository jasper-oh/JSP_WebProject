<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Major Name을 변경하세요</title>
</head>
<body>

<form action="adminMajorUpdateAction.do" method="get">
<table>
		<tr>
			<td align="left"><input type="text" name="majorpk" value="${Major.majorPk }"></td>
		</tr>
		<tr>
			<td align="left"><input type="text" size="20" name="majorname" value="${Major.majorName }"></td>
		</tr>
</table>
<input type="submit" value="수정"> <input type="button" value="취소" onclick="self.close()">
</form>
</body>
</html>