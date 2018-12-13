<%@page import="antlr.NameSpace"%>
<%@page import="sg.iss.team10.caps.util.*"%>
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
<title>Enrollment List</title>
</head>
<body>
	<p class="errormessage">${message}</p>
	<h2>Enrollment</h2>

	<h3>Course: ${course.courseName}</h3>
	<table class="table table-hover">
		<tr>
			<td>Course ID</td>
			<td>${course.courseId}</td>
		</tr>
		<tr>
			<td>Credit</td>
			<td>${course.credit} credits</td>
		</tr>
		<tr>
			<td>Duration</td>
			<td>${course.duration} days</td>
		</tr>
		<tr>
			<td>Start Date</td>
			<td><fmt:formatDate value="${course.startDate}"
					pattern="EEEE, d MMMM yyyy" /></td>
		</tr>
		<tr>
			<td>Capacity</td>
			<td>${course.capacity} student(s)</td>
		</tr>
		<tr>
			<td>Current Enrollment</td>
			<td>${fn:length(enrollmentList)} student(s)</td>
		</tr>
	</table>

	<h3>Enrolled Students</h3>
	<table class="table table-hover">
		<!-- Table - Header -->
		<tr>
			<td>#</td>
			<td>Student ID</td>
			<td>First and Middle Name</td>
			<td>Last Name</td>
			<td>Score</td>
			<td>Grade</td>
		</tr>
		<!-- Table - Records -->
		<c:forEach items="${enrollmentList}" var="enrollment"
			varStatus="index">
			<tr>
				<td>${index.index+1}</td>
				<td>${enrollment.studentId}</td>
				<td>${firstNames.get(index.index)}</td>
				<td>${lastNames.get(index.index)}</td>
				<c:choose>
						<c:when test="${empty enrollment.score}">
							<td>To be scored</td>
							<td>-</td>
						</c:when>
						<c:otherwise>
							<td>${enrollment.score}</td>
							<td>${grades.get(index.index)}</td>
						</c:otherwise>
					</c:choose>
					
					<td><a href="${pageContext.request.contextPath}/lecturer/grade/${enrollment.enrollmentId}">Edit
						Score</a></td>
					<td><a href="${pageContext.request.contextPath}/lecturer/performance/${enrollment.studentId}">View
						Performance</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>