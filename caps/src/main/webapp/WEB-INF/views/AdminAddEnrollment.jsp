<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" modelAttribute="enrollment" action="${pageContext.request.contextPath}/admin/enrollment/add.html">

	Add New Enrollment
	<table align="center">
		<tr>
			<td><spring:message	code="Enrollment Id"/></td>
			<td><form:input path="enrollmentId" value="${eid}" readonly="true"/></td>
		</tr>
		<tr>		
			<td><spring:message code="Course Id"/></td>
			<td><form:input path="courseId"/></td>
		</tr>
		<tr>	
			<td><spring:message code="Student Id"/></td>
			<td><form:input path="studentId"/></td>
		</tr>
		<tr>	
			<td><spring:message code="Score"/></td>
			<td><form:input path="score"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add"/></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</form:form>
</body>
</html>