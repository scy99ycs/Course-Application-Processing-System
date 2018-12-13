<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h3>Add New Enrollment</h3>

<form:form method="POST" modelAttribute="enrollment"
	action="${pageContext.request.contextPath}/admin/enrollment/add.html">
	<p class ="errormessage">${message}</p>
	<table align="center">
		<tbody>
			
			<tr>
				<td><spring:message code="Student Id" /></td>
				<td><form:input path="studentId"/></td>
				<td><form:errors path="studentId" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="Course Id" /></td>
				<td><form:input path="courseId"/></td>
				<td><form:errors path="courseId" cssStyle="color: red;" /></td>
			</tr>
						
			<tr>
				<td><input type="submit" value="Add"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>