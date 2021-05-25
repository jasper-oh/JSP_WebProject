<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<title>ADMIN PAGE</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,600;1,600&display=swap');
* {
  box-sizing: border-box; 
}
body {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
  margin: 0;
}
#main {
  display: flex;
  flex: 1;
}
#main > article {
	text-align: center;
  flex: 1;
}
#main > nav, 
#main > aside {
  flex: 0 0 17vw;
  background: ;
}
#main > nav {
  order: -1;
}
header {
  background: #285943;
  height: 35vh;
  position: relative;
  text-align: right;
}
 footer {
  background: #285943;
  height: 25vh;
  position: relative;
  text-align: right;
}
header, footer, article, nav, aside {
  padding: 1em;
}
button {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}
button {
    width:180px;
    background-color: #285943;
    border: none;
    color:#D7FFF1;
    padding: 30px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-family: 'Montserrat', sans-serif;
    font-size: 20px;
    margin: 5px;
    cursor: pointer;
    border-radius:10px 0 10px 0;
}
button.now {
    background-color: #8CD790;
}
</style>
<head>
   <link rel="stylesheet" type="text/css" href="css/starwars.css">
  <!--  <link rel="stylesheet" type="text/css" href="css/adminstyle.css"> -->
</head>
<body>
  <header>
  <div class="starwars-demo">
    <img src="//cssanimation.rocks/demo/starwars/images/star.svg" alt="Star" class="star">
    <img src="//cssanimation.rocks/demo/starwars/images/wars.svg" alt="Wars" class="wars">
    <h2 class="byline" id="byline">The Force Awakens</h2>
  </div>
  </header>
  <div id="main">
    <article>
    
 	<button type="button" onclick="location.href='AdminAnnouncementList.do' ">Announcement</button>
 	<button type="button" onclick="location.href='adminUserListShowPage.do' ">User</button>
 	<button type="button" onclick="location.href='adminMajorListShowPage.do' ">Force</button> <br>
 	<button type="button" onclick="location.href='adminReviewList.do' ">Review</button>
 	<button type="button" onclick="location.href='adminQnaList.do' ">QnA</button>
 	<button type="button" onclick="location.href='' ">Payment</button>
  	
	<div class="container">
		
		<div class="person" id="finn">
			<div class="ear left"></div>
			<div class="ear right"></div>
			<div class="hair"></div>
			<div class="face">
				<div class="eyes"></div>
				<div class="nose"></div>
				<div class="mouth"></div>
			</div>
			
			<div class="neck"></div>
			<div class="body">
				<div class="jacket jacket-left"></div>
				<div class="jacket jacket-right"></div>
			</div>
		</div>

		<div class="person" id="rey">
			<div class="hair"></div>
			<div class="face">
				<div class="eyes"></div>
				<div class="nose"></div>
				<div class="mouth"></div>
			</div>
			<div class="hair-left"></div>
			<div class="hair-right"></div>
			<div class="bangs"></div>
			<div class="neck"></div>
			<div class="body">
				<div class="fold-right"></div>
				<div class="fold-left"></div>
			</div>
			<div class="lightsaber"></div>
		</div>
		
		<div class="person" id="poe">
			<div class="helmet-back"></div>
			<div class="face">
				<div class="eyes"></div>
				<div class="nose"></div>
				<div class="mouth"></div>
				<div class="visor"></div>
			</div>
			<div class="helmet">
				<div class="helmet-triangle"></div>
				<div class="helmet-ornament"></div>
			</div>
			<div class="helmet-face"></div>
			<div class="neck"></div>
			<div class="body"></div>
			<div class="flight-suit">
				<div class="buttons">
					<div class="b1"></div>
					<div class="b2"></div>
					<div class="b3"></div>
				</div>
				<div class="tube"></div>
			</div>
		</div>
	</div>
  	
</article>
    <nav>
    </nav>
    <aside></aside>
  </div>
  <footer></footer>
  
</body>
