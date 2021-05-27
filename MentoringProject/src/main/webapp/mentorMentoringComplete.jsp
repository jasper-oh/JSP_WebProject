<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/subpage.css">
        <link rel="stylesheet" href="css/subpage.css">
    </head>
    <body class="align">
        <h3>축하합니다!!</h3>
        <h3>당신의 제다이에게서 받은 토큰 번호를 입력하면 돈이 바로 송금 됩니다!</h3>
	<form action="/MentoringProject/mentorMentoringCompleteTokenCheck.do" method="post">
          <div class="form__field">
                <input type="text" name="schedulepk" class="form__input" pattern=".{6,}" required value="<%out.print(request.getParameter("scheduledpk"));%>">
                <input type="text" name="token"class="form__input" pattern=".{6,}" required ><span class="icon"></span>
            </div>
            <div class="tokenbutton" align = "center">
                <input button type="submit" value="토큰 입력">
            </div>
        </form>
        <a href="/MentoringProject/mentorScheduledCompleteListPage.do">토큰번호는 6자리로 입력해주세요 / 돌아가기</a>      
      </body>
</html>