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
<p class ="errormessage">${message}</p>
<form:form method="POST" modelAttribute="student" action="${pageContext.request.contextPath}/admin/student/add.html">

	<h2>Add New Student</h2>
	<table align="center">
		<tr><td> &nbsp; <td></tr>
		<tr>		
			<td><spring:message code="Student Name"/></td>
			<td><form:input path="firstMidName"/></td>
			<td><form:errors path="firstMidName" cssStyle="color: red;" /></td>
		</tr>
		<tr><td> &nbsp; <td></tr>
		<tr>	
			<td><spring:message code="Last Name"/></td>
			<td><form:input path="lastName"/></td>
			<td><form:errors path="lastName" cssStyle="color: red;" /></td>
		</tr>
		<tr><td> &nbsp; <td></tr>
		<tr>
			<td><spring:message code="Enrollment Date"/></td>
			<td><form:input path="enrollmentDate" type="date" format="yyyy-MM-dd"/></td>			
			<td><form:errors path="enrollmentDate" cssStyle="color: red;" /></td>
		</tr>
		<tr><td> &nbsp; <td></tr>
		<tr>
			<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="Add" style="height:30px; width:70px"/></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</form:form>
</body>
</html>