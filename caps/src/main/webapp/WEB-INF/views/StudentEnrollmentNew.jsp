<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enrollment</title>
</head>
<body>

	<h2 class="container" style="padding-top: 151px;">Course Detail</h2>
	<div align="left">
		<input type="reset" value="Back" onclick="history.go(-1)"
			class="btn btn-danger" style="align: left" />
	</div>
	<br/>
	<form:form method="POST" modelAttribute="Enrollment"
		action="${pageContext.request.contextPath}/student/create/${course.courseId}">

		<table class="table table-hover"
			style="cellspacing: 2; cellpadding: 2; border: 1;">

			<thead>
				<tr class="listHeading">
					<th><spring:message code="CourseId" /></th>
					<th><spring:message code="CourseName" /></th>
					<th><spring:message code="Credit" /></th>
					<th><spring:message code="Capacity" /></th>
					<th><spring:message code="Duration" /></th>
					<th><spring:message code="StartDate" /></th>
					<th><spring:message code="StaffID" /></th>
					<th>Enroll</th>
				</tr>
			</thead>

			<tr class="ListRecord">
				<td align="left">${course.courseId}</td>
				<td align="left">${course.courseName}</td>
				<td align="left">${course.credit}</td>
				<td align="left">${course.capacity}</td>
				<td align="left">${course.duration}</td>
				
				<td><fmt:formatDate value="${course.startDate}"
					pattern="EEEE, d MMMM yyyy" /></td>
					
				<td align="left">${course.staffId}</td>
				<td align="left"><input class="btn btn-warning" type="submit"
					value="Confirm"></td>
			</tr>

		</table>

	</form:form>

</body>
</html>