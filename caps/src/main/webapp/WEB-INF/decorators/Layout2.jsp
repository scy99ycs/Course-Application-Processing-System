<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">

<head>

<meta charset="UTF-8">

<link rel="shortcut icon" type="image/x-icon" href="image/owl.ico" />
<link rel="mask-icon" type=""
	href="https://static.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
	color="#111" />
<title>Team 10 CAPS</title>
<link
	href='https://fonts.googleapis.com/css?family=Montserrat+Alternates:700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.min.css'>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<!-- <link rel="STYLESHEET" type="text/css" href="/css/style.css" /> -->
<style>
h2{
	font-size: 40px;
	font-weight: bolder;
}
thead {
    background-color: black;
    opacity: 0.5;
    color: white;
    font-weight: bold;
    font-size: large;
}
.caps{
    font-family: fontawesome;
    text-decoration: none;
    line-height: 1;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    font-size: 37px;
    letter-spacing: 3px;
    color: #555555;
    display: block;
    position: relative;
}
.header {
  overflow: hidden;

  padding: 0px 10px;

}
html {
	font-family: 'average', serif;
}

a {
	color: #FFF;
}

#mainnav {
	position: absolute;
	font-family: 'Montserrat Alternates', sans-serif;
	z-index: 1;
}

#mainnav li {
	margin: 35px 0;
	left: -550px;
	position: relative;
	display: none;
	font-size: 0.5em;
}

#mainnav a {
	color: #fff;
	text-shadow: 2px 2px 0 #000;
	text-decoration: none;
	font-size: 3.5em;
}

.hamb {
	position: absolute;
 	top: 0px;
	left: 20px;
	font-size: 2.5em;
	z-index: 1;
}

.hamb a {
	color: #fff;
	text-decoration: none;
}

html, body, .hero {
	height: 100%;
}

.hero {
	width: 100%;
	min-height: 550px;
	background-image: linear-gradient(to bottom, #d59254, #cf7693);
 	margin-top: 55px;
	height: auto;
}

h1 {
	font-size: 5em;
	text-align: center;
	font-weight: 700;
	font-family: 'Montserrat Alternates', sans-serif;
	color: #fff;
	width: 100%;
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

#bubble {
	width: 100%;
	height: 100%;
	opacity: 0.999 0.9;
	position: fixed;
	display: none;
	z-index: 1;
	background: linear-gradient(to left, rgba(0,0,0,0.39), rgba(0,0,0,0.75));
}

/* Page content */
.content {
  padding: 16px;
}

/* The sticky class is added to the header with JS when it reaches its scroll position */
.sticky {
  position: fixed;
  top: 0;
  width: 100%
}

/* Add some top padding to the page content to prevent sudden quick movement (as the header gets a new position at the top of the page (position:fixed and top:0) */
.sticky + .content {
  padding-top: 102px;
}
</style>

<script>
	window.console = window.console || function(t) {
	};
</script>



<script>
	if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	}
</script>


</head>


<body translate="no">

	<header>
	
		<%@ include file="Header.jsp" %>
		
	</header>

	


	<div class="hero">
		<center style="	margin: 55px">
		<h2></h2>
		<br>	
			<dec:body />
				
		</center>
			
	</div>
<%@ include file="Footer.jsp" %>
	<canvas id="bubble"></canvas>
	

	
	<script
		src="//static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>

	<script
		src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='//code.jquery.com/ui/1.10.3/jquery-ui.js'></script>



	<script>
		//canvas code borrowed/tweaked from: https://codepen.io/otsukatomoya/pen/gbDxF

		//navigation inspiration from: http://www.aleeforoughi.com/

		//canvas (this is borrowed code)
		var w = window.innerWidth, h = window.innerHeight, canvas = document
				.getElementById('bubble'), ctx = canvas.getContext('2d'), rate = 60, arc = 100, time, count, size = 7, speed = 20, lights = new Array, colors = [
				'#d59254', '#ffffff', '#1f2839', '#cf7693' ];

		canvas.setAttribute('width', w);
		canvas.setAttribute('height', h);

		function init() {
			time = 0;
			count = 0;

			for (var i = 0; i < arc; i++) {
				lights[i] = {
					x : Math.ceil(Math.random() * w),
					y : Math.ceil(Math.random() * h),
					toX : Math.random() * 5 + 1,
					toY : Math.random() * 5 + 1,
					c : colors[Math.floor(Math.random() * colors.length)],
					size : Math.random() * size
				}
			}
		}

		function bubble() {
			ctx.clearRect(0, 0, w, h);

			for (var i = 0; i < arc; i++) {
				var li = lights[i];

				ctx.beginPath();
				ctx.arc(li.x, li.y, li.size, 0, Math.PI * 2, false);
				ctx.fillStyle = li.c;
				ctx.fill();

				li.x = li.x + li.toX * (time * 0.05);
				li.y = li.y + li.toY * (time * 0.05);

				if (li.x > w) {
					li.x = 0;
				}
				if (li.y > h) {
					li.y = 0;
				}
				if (li.x < 0) {
					li.x = w;
				}
				if (li.y < 0) {
					li.y = h;
				}
			}
			if (time < speed) {
				time++;
			}
			timerID = setTimeout(bubble, 1000 / rate);
		}
		init();
		bubble();

		//navigation (this is my code)
		var animation = 'easeOutCubic';
		delay = 60;

		$(document).on('click', '.fa-bars', function() {
			var i = 0;
			$('nav').before($('#bubble'));
			$('#bubble').fadeIn();
			$('#mainnav').find('li').each(function() {
				var that = $(this);
				i++;
				(function(i, that) {
					setTimeout(function() {
						that.animate({
							'left' : '20px'
						}, {
							duration : 350,
							easing : animation
						}).fadeIn({
							queue : false
						});
					}, delay * i)
				}(i, that))
			});
			$('.fa-bars').fadeOut(100, function() {
				$(this).removeClass('fa-bars').addClass('fa-times').fadeIn();
			});
		}).on(
				'click',
				'#bubble, .fa-times',
				function() {
					$('#bubble').fadeOut();
					$('#mainnav').find('li').animate({
						'left' : '-550px'
					}, {
						duration : 250
					}).fadeOut({
						queue : false
					});

					$('.hamb').fadeOut(
							100,
							function() {
								$(this).find($('i')).removeClass('fa-times')
										.addClass('fa-bars').end().fadeIn();
							});
				})
		//# sourceURL=pen.js
	</script>






	<script
		src="https://static.codepen.io/assets/editor/live/css_reload-5619dc0905a68b2e6298901de54f73cefe4e079f65a75406858d92924b4938bf.js"></script>
</body>

</html>