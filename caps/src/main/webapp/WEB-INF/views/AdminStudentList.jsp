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
<title>Manage Students</title>
</head>
<body>

	<h2>Manage Students</h2>
	<br />

	<p align="left">
		<a href="${pageContext.request.contextPath}/admin/student/add.html"><input
			class="btn btn-warning" type="submit" value="Add New Student"
			style="width: 150px" /></a>
	</p>
	
	<form:form
		action="${pageContext.request.contextPath}/admin/student/list"
		method="post">

		<!-- Search bar -->
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
		<br />

		<!-- Message display -->
		<c:if test="${not empty message}">
			<div class="alert alert-warning" style="width: 100%;">${message}</div>
		</c:if>
		<br />

		<c:if test="${fn:length(studentList) gt 0}">
			<table align="center" class="table table-hover"
				style="cellspacing: 2; cellpadding: 2; border: 1;">
				<thead>
					<tr>
						<th><spring:message code="Student Id" /></th>
						<th><spring:message code="First & Middle Name" /></th>
						<th><spring:message code="Last Name" /></th>
						<th><spring:message code="User Name" /></th>
						<th><spring:message code="Edit" /></th>
						<th><spring:message code="Delete" /></th>
					</tr>
				</thead>
				<c:forEach var="student" items="${studentList}">
					<tr>
						<td>${student.studentId}</td>
						<td>${student.firstMidName}</td>
						<td>${student.lastName}</td>
						<td>${student.username}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/student/edit/${student.studentId}.html"><spring:message
									code="Edit" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/student/delete/${student.studentId}.html"><spring:message
									code="Delete" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>