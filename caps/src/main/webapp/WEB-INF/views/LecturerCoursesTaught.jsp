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
<title>My Courses</title>
</head>
<body>
	<h2>My Courses</h2>
	<table class="table table-hover">
		<!-- Table - Header -->
		<thead>
		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Start Date</th>
			<th>Duration (days)</th>
			<th>Credits</th>
			<th>Capacity</th>
			<th>Enrolled</th>
			<th>View Students</th>
		</tr>
		</thead>
		<!-- Table - Records -->
		<c:forEach items="${CourseList}" var="course" varStatus="index">
			<tr>
				<td>${course.courseId}</td>
				<td>${course.courseName}</td>
				<td><fmt:formatDate value="${course.startDate}"
						pattern="EEEE, d MMMM yyyy" /></td>
				<td>${course.duration}</td>
				<td>${course.credit}</td>
				<td>${course.capacity}</td>
				<td><c:out value="${numEnrolled.get(index.index)}" /></td>
				<td><a
					href="${pageContext.request.contextPath}/lecturer/studentlist/${course.courseId}">View
						Students</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>