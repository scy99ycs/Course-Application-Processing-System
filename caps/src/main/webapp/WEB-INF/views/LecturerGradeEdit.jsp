<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grade A Student</title>
</head>
<body>

	<h2>Edit Grades</h2>
	<br/>
	
	<!-- Course details -->
	<h3>Course</h3>
	<br/>
	
	<table class="table table-hover">
		<thead>
		<tr>
			<td>Course Name</td>
			<td>${course.courseName}</td>
		</tr>
		</thead>
		<tr>
			<td>Course ID</td>
			<td>${course.courseId}</td>
		</tr>
		<tr>
			<td>Credit</td>
			<td>${course.credit} credits</td>
		</tr>
	</table>
	<br/>


	<!-- Student details -->
	<h3>Student</h3>
	<br/>
	<form:form action="${pageContext.request.contextPath}/lecturer/grade"
		method="POST" modelAttribute="enrollment">
		<table class="table table-hover">
			<thead>
			<tr>
				<td>First and Middle name</td>
				<td>${student.firstMidName}</td>
				<td></td><td></td><td></td>
			</tr>
			</thead>
			<tr>
				<td>Last name</td>
				<td>${student.lastName}</td>
				<td></td><td></td><td></td>
			</tr>
			<tr>
				<td>Student ID</td>
				<td>${student.studentId}</td>
				<td></td><td></td><td></td>
			</tr>
			<tr>
				<td>Score</td>
				<td><form:input path="score" size="10" /></td>
				<td><form:hidden readonly="true" path="enrollmentId" /></td>
				<td><form:hidden readonly="true" path="courseId" /></td>
				<td><form:hidden readonly="true" path="studentId" /></td>
			</tr>
		</table>
		<input type="reset" value="Back" class="btn btn-danger" onclick="history.go(-1)"/>
		<input type="submit" value="Submit" class="btn btn-warning"/>
		<input type="reset" value="Clear" class="btn btn-warning"/>
	</form:form>
</body>
</html>