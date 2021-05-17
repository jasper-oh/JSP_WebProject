<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="0">
		<form action="userSignUpPage.do" method="post">
			
			<tr>
				<td>ID : </td>
				<td><input type="text" name="userid" placeholder="아이디를 입력해 주세요"></td>
			</tr>
			
			<tr>
				<td>PW : </td>
				<td> <input type="password" name="userpw" placeholder="비밀번호를 입력해 주세요"></td>
			</tr>
			<tr>
				<td> NAME : </td>
			 	<td> <input type="text" name="username" placeholder="이름을 입력해 주세요"> </td>
			</tr>
			<tr>
				<td>EMAIL : </td>
				<td><input type="email" name="useremail"></td>
			</tr>
			<tr>
				<td>PHONE : </td>
				<td><input name="fuserphone" value="010" readonly="readonly" > - <input type="text" name="muserphone"> - <input type="text" name="euserphone"></td>
			</tr>
			<tr>
				<td><input type="submit" value="가입하기"></td>
			</tr>
		</form>
	</table>
</body>
</html>