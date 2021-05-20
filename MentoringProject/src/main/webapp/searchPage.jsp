<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/components/searchResult.css">
<title>검색 결과 출력 </title>
</head>
<body>


	<div class="main-box">
	    <h1>당신의 검색결과입니다!</h1>
	    
	    <div class="buttons">
	    	  <div class="back-button">
	        	<a href="/">Go back home</a>
	      	</div>  
	    </div>
    
	    <section>
	      <c:forEach items="${mentorSearchList }" var="mentorList">
		      <div class="job-contain-box">
		      	<div>
		      		<img src="${mentorList.mentorImage }" alt="mentor img">
		      	</div>
		        <h3> ${mentorTitle } </h3>
		        <h4> ${mentorList.mentorMajor }</h4>
		        <span>${mentorList.subMajor }</span>
		        <span>${mentorList.mentorName } </span>
		        <span>${mentorList.mentorPrice }</span> 
		        <a href="/reservation.do?productpk=${mentorList.productPk }" >예약하기!</a>
		      </div>
	      </c:forEach>
	      
	    </section>
  </div>  
	

</body>
</html>