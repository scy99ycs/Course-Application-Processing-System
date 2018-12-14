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
	<br />

	<!-- Search bar -->
	<form:form
		action="${pageContext.request.contextPath}/lecturer/performance"
		method="POST">
		<div class="row col-md-5 col-centered">
			<div>
				<input type="text" name="sname" placeholder="Type Student's Name"
					class="form-control" style="width: 500px" />
			</div>
			<div>
				<input type="submit" name="search" value="Search"
					class="btn btn-warning " />
			</div>
		</div>
	</form:form>
	<br />

	<!-- Message display -->
	<c:if test="${not empty message}">
		<p class="alert alert-warning" style="color: orange">${message}</p>
	</c:if>
	<br />

	<!-- Results -->
	<table class="table table-hover">
		<!-- Table - Header -->
		<thead>
			<tr>
				<td>Student ID</td>
				<td>First and Middle Name</td>
				<td>Last Name</td>
				<td>Enrollment Date</td>
				<td>View Performance</td>
			</tr>
		</thead>
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