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
<title>Add New Course </title>
</head>
<body>
<p class ="errormessage">${message}</p>
<form:form method="POST" modelAttribute="course" action="${pageContext.request.contextPath}/admin/course/add.html">

	<h2>Add New Course</h2>
	<p>&nbsp; </p>
	<table align="center" style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tr>		
			<td><spring:message code="Course Name"/></td>
			<td><form:input path="courseName"/></td>
			<td><form:errors path="courseName" cssStyle="color: red;" /></td>
		</tr>
		<tr><td> &nbsp; </td></tr>
		<tr>	
			<td><spring:message code="Credit"/></td>
			<td><form:input path="credit"/></td>
			<td><form:errors path="credit" cssStyle="color: red;" /></td>
		</tr><tr><td> &nbsp; </td></tr>
		<tr>
			<td><spring:message code="Start Date"/></td>
			<td><form:input path="startDate" type="date" format="yyyy-MM-dd"/></td>	
		</tr><tr><td> &nbsp; </td></tr>
		<tr>	
			<td><spring:message code="Duration"/></td>
			<td><form:input path="Duration"/></td>
			<td><form:errors path="Duration" cssStyle="color: red;" /></td>
		</tr><tr><td> &nbsp; </td></tr>
		<tr>	
			<td><spring:message code="Capacity"/></td>
			<td><form:input path="capacity"/></td>
			<td><form:errors path="capacity" cssStyle="color: red;" /></td>
		</tr><tr><td> &nbsp; </td></tr>
		<tr>	
			<td>Staff Id &nbsp; &nbsp; </td>
				<td><form:select path="staffId" style="width: 100px;">
					  <form:options items="${sidList}" />	
					  </form:select></td>
		</tr><tr><td> &nbsp; </td></tr>
		<tr>
			<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; <input class="btn btn-warning" type="submit" value="Add" style=" width:70px"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>