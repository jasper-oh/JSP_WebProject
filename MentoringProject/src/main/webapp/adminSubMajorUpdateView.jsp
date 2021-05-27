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

<form action="adminSubMajorUpdateAction.do" method="get">
<table>
		<tr>
			<td align="left"><input type="text" name="submajorpk" value="${Submajor.submajorPk }"></td>
		</tr>
		<tr>
			<td align="left"><input type="text" size="20" name="submajorname" value="${Submajor.submajorName }"></td>
		</tr>
</table>
<input type="submit" value="수정"> <input type="button" value="취소" onclick="self.close()">
</form>
</body>
</html>