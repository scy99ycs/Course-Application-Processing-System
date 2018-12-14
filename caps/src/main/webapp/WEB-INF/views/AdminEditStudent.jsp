<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Student Page</h3>
<form:form method="POST" modelAttribute="student"
	action="${pageContext.request.contextPath}/admin/student/edit/${student.studentId}.html">
	<p class ="errormessage">${message}</p>
	<table>
		<tbody>
			<tr>
				<td><spring:message code="Student Id" /></td>
				<td><form:input path="studentId" readonly="true" /></td>
				<td><form:errors path="studentId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="First Middle Name" /></td>
				<td><form:input path="firstMidName"/></td>
				<td><form:errors path="firstMidName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="Last Name" /></td>
				<td><form:input path="lastName"/></td>
				<td><form:errors path="lastName" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="Enrollment Date"/></td>
				<td><form:input path="enrollmentDate" type="date" format="yyyy-MM-dd"/></td>		
				<td><form:errors path="enrollmentDate" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Update"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>