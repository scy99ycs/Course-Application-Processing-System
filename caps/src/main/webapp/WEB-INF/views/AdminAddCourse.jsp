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
<form:form method="POST" modelAttribute="course" action="${pageContext.request.contextPath}/admin/course/add.html">

	Add New Course
	<table align="center">
		
		<tr>		
			<td><spring:message code="Course Name"/></td>
			<td><form:input path="courseName"/></td>
		</tr>
		<tr>	
			<td><spring:message code="Capacity"/></td>
			<td><form:input path="capacity"/></td>
		</tr>
		<tr>	
			<td><spring:message code="Credit"/></td>
			<td><form:input path="credit"/></td>
		</tr>
		<tr>
			<td><spring:message code="Start Date"/></td>
			<td><form:input path="startDate" type="date" format="yyyy-MM-dd"/></td>			
			
		</tr>
		<tr>	
			<td><spring:message code="Duration"/></td>
			<td><form:input path="Duration"/></td>
		</tr>
		<tr>	
			<td><spring:message code="Capacity"/></td>
			<td><form:input path="capacity"/></td>
		</tr>
		<tr>	
			<td><spring:message code="Staff Id"/></td>
			<td><form:input path="staffId"/></td>
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