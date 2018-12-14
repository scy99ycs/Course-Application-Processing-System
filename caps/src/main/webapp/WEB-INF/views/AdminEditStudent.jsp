<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>Edit Student Details</h2>
<form:form method="POST" modelAttribute="student"
	action="${pageContext.request.contextPath}/admin/student/edit/${student.studentId}.html">
	<p class ="errormessage">${message}</p>
	<table align="center" style="cellspacing: 2; cellpadding: 2; border: 1;">
	<tbody>
		<tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Student Id" /></td>
				<td><form:input path="studentId" readonly="true" /></td>
				<td><form:errors path="studentId" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="First Middle Name" /></td>
				<td><form:input path="firstMidName"/></td>
				<td><form:errors path="firstMidName" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Last Name" /></td>
				<td><form:input path="lastName"/></td>
				<td><form:errors path="lastName" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Enrollment Date"/></td>
				<td><form:input path="enrollmentDate" type="date" format="yyyy-MM-dd"/></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td></td>
				<td><input class="btn btn-warning" type="submit" value="Update" style="float:right"/></td>
			</tr>
		</tbody>
	</table>
</form:form>