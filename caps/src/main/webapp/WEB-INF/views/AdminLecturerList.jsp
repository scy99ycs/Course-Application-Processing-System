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
<title>List of Lecturers</title>
</head>
<body>
	<h2>Manage Lecturers</h2>
	<p align="left">
		<a href="${pageContext.request.contextPath}/admin/lecturer/new.html"><input
			class="btn btn-warning" type="submit" value="Add New Lecturer"/></a>
	</p>
	<br />


	<form:errors path="courseName" cssStyle="color:red;" />
	<c:if test="${not empty message}">

		<div class="alert alert-warning" style="width: 100%;">${message}
		</div>

	</c:if>
	<form:form>
		<c:if test="${fn:length(lecturerList) gt 0}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><spring:message code="Staff Id" /></th>
						<th><spring:message code="Staff Name" /></th>
						<th><spring:message code="Designation" /></th>
						<th><spring:message code="Edit" /></th>
						<th><spring:message code="Delete" /></th>
					</tr>
				</thead>
				<c:forEach var="lecturer" items="${lecturerList}">
					<tr>
						<td>${lecturer.staffId}</td>
						<td>${lecturer.staffName}</td>
						<td>${lecturer.designation}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/lecturer/edit/${lecturer.staffId}.html"><spring:message
									code="Edit" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/lecturer/delete/${lecturer.staffId}.html"><spring:message
									code="Delete" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>




















