<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Courses</title>
</head>
<body>

	<h2>Manage Courses</h2>
	<br />

	<p align="left">
		<a href="${pageContext.request.contextPath}/admin/course/add.html"><input
			class="btn btn-warning" type="submit" value="Add New Course" /></a>
	</p>

	<form:form method="POST" modelAttribute="course"
		action="${pageContext.request.contextPath}/admin/course/list.html">


		<!-- Search bar -->
		<div class="row col-md-5 col-centered">
			<div>
				<input type="text" name="sname" placeholder="Type Course Name"
					class="form-control" style="width: 500px" />
			</div>
			<div>
				<input type="submit" name="search" value="Search"
					class="btn btn-warning " />
			</div>
		</div>
		<br />

		<!-- Message display -->
		<c:if test="${not empty message}">
			<div class="alert alert-warning" style="width: 100%;">${message}</div>
		</c:if>
		<br />

		<c:if test="${fn:length(courseList) gt 0}">
			<table align="center" class="table table-hover"
				style="cellspacing: 2; cellpadding: 2; border: 1;">
				<thead>
					<tr>
						<th><spring:message code="Course Id" /></th>
						<th><spring:message code="Course Name" /></th>
						<th><spring:message code="Credit" /></th>
						<th><spring:message code="Capacity" /></th>
						<th><spring:message code="Staff Id" /></th>
						<th><spring:message code="Edit" /></th>
						<th><spring:message code="Delete" /></th>
					</tr>
				</thead>

				<c:forEach var="course" items="${courseList}">
					<tr>
						<td>${course.courseId}</td>
						<td>${course.courseName}</td>
						<td>${course.credit}</td>
						<td>${course.capacity}</td>
						<td>${course.staffId}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/course/edit/${course.courseId}.html"><spring:message
									code="Edit" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/course/delete/${course.courseId}.html"><spring:message
									code="Delete" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>