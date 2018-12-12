<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
</style>

</head>
<body>
	<h1>Who are you??</h1>
	<!-- 	<h1> -->
	<!-- 	<ul> -->
	<div class="container">
		<div class="row" style="position: absolute; top: 70%; width: 100%;">
			<div class="col-sm">
<!-- 				<button class="btn btn-success"> -->
					<a href="${pageContext.request.contextPath}/adminlogin">Login
						as Administrator</a>
<!-- 				</button> -->
			</div>
			<div class="col-sm">
<!-- 				<button class="btn btn-success"> -->
					<a href="${pageContext.request.contextPath}/lecturerlogin">Login
						as Lecturer</a>
<!-- 				</button> -->
			</div>
			<div class="col-sm">
<!-- 				<button class="btn btn-success"> -->
					<a href="${pageContext.request.contextPath}/studentlogin">Login
						as Student</a>
<!-- 				</button> -->
			</div>
		</div>
	</div>
	<!-- 	</ul> -->
	<!-- 	</h1> -->

</body>

</html>