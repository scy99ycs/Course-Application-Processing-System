<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
</head>
<body>
	<h2>All Students</h2>
	<table class="table table-hover">
		<!-- Table - Header -->
		<tr>
			<td>Student ID</td>
			<td>First and Middle Name</td>
			<td>Last Name</td>
			<td>Enrollment Date</td>
		</tr>
		<!-- Table - Records -->
		<c:forEach items="${StudentList}" var="Student">
			<tr>
				<td>${Student.studentId}</td>
				<td>${Student.firstMidName}</td>
				<td>${Student.lastName}</td>
				<td><fmt:formatDate value="${Student.enrollmentDate}"
						pattern="EEEE, d MMMM yyyy" /></td>
				<td><a
					href="${pageContext.request.contextPath}/lecturer/performance/${Student.studentId}">View
						performance</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>