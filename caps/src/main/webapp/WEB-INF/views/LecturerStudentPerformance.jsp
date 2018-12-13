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
<title>My Courses</title>
</head>
<body>
	<h2>Student Performance</h2>

	<table>
		<tr>
			<td>Student Name</td>
			<td>${student.firstMidName}${student.lastName}</td>
		</tr>
		<tr>
			<td>Student ID</td>
			<td>${student.studentId}</td>
		</tr>
	</table>

	<h3>Courses Attending</h3>
	<table>
		<tr>
			<th>#</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Credits</th>
			<th>Score</th>
			<th>Grade</th>
		</tr>

		<c:forEach items="${performanceList}" var="performance" varStatus="index">
			<tr>
				<td>${index.index+1}</td>
				<td>${performance.courseId}</td>
				<td>${course.get(index.index).courseName}</td>
				<td>${course.get(index.index).credit}</td>
				<td><c:choose>
						<c:when test="${empty performance.score}">No score yet</c:when>
						<c:otherwise>${performance.score}</c:otherwise>
					</c:choose></td>
				<td>${grade.get(index.index)}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>