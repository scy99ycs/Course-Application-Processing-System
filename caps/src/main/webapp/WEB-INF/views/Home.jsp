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
	<form action="./adminlogin" method="POST">

		<button name="action" value="admin">Admin</button>

	</form>
	<a href="./home/adminlogin">go to admin login</a>
	
	<form action="./LecturerLogin">
		<button name="action" value="lecturer">Lecturer</button>
	</form>
	
	<form action="./studentLogin">
		<button name="action" value="student">Student</button>
	</form>
	
	<a href="${pageContext.request.contextPath}/adminlogin">adminlogic</a>
</body>

</html>