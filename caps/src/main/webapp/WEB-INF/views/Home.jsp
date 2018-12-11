<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Who are you??</h1>

	<a href="${pageContext.request.contextPath}/adminlogin">Login as
		Administrator</a>
	<br />
	<a href="${pageContext.request.contextPath}/lecturerlogin">Login as
		Lecturer</a>
	<br />
	<a href="${pageContext.request.contextPath}/studentlogin">Login as
		Student</a>
	<br />

</body>

</html>