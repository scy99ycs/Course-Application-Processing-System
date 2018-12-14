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
	<br />
	<div align="left">
		<input type="reset" value="Back" onclick="history.go(-1)"
			class="btn btn-danger" style="align: left" />
	</div>
	<h3>Student Details</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>First Name</td>
				<td>${student.firstMidName}</td>
			</tr>
		</thead>
		<tr>
			<td>Last Name</td>
			<td>${student.lastName}</td>
		</tr>
		<tr>
			<td>Student ID</td>
			<td>${student.studentId}</td>
		</tr>
		<tr>
			<td>Enrollment Date</td>
			<td><fmt:formatDate value="${student.enrollmentDate}"
					pattern="EEEE, d MMMM yyyy" /></td>
		</tr>
		<tr>
			<td>GPA (0 to 4)</td>
			<c:choose>
				<c:when test="${empty GPA}">
					<td>To be graded</td>
				</c:when>
				<c:otherwise>
					<td>${GPA}</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
	<br />

	<h3>Courses Attending</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Credits</th>
				<th>Score</th>
				<th>Grade</th>
			</tr>
		</thead>

		<c:forEach items="${performanceList}" var="performance"
			varStatus="index">
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