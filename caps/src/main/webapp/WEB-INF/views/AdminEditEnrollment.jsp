<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h2>Edit Student Page</h2>
<form:form method="POST" modelAttribute="enrollment"
	action="${pageContext.request.contextPath}/admin/enrollment/edit/${enrollment.enrollmentId}.html">
	<p class ="errormessage">${message}</p>
	<table align="center" class = "table table-hover" style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tbody>
			<tr><td> &nbsp; <td></tr>
			<tr>
				<td><spring:message code="Enrollment Id" /></td>
				<td><form:input path="enrollmentId" value="${enrollment.enrollmentId}" readonly="true" /></td>
				<td><form:errors path="enrollmentId" cssStyle="color: red;" /></td>
			</tr>
			<tr><td> &nbsp; <td></tr>
			<tr>
				<td>Student Id &nbsp; &nbsp; </td>
				<td><form:select path="studentId" style="width: 100px;">
					  <form:options items="${sidList}" />	
					  </form:select></td>
			</tr>
			<tr><td> &nbsp; <td></tr>
			<tr>
				<td>Course Id &nbsp;  </td>
				<td><form:select path="courseId" style="width: 100px;">
					  <form:options items="${cidList}" />	
					  </form:select></td>
			</tr>
			<tr><td> &nbsp; <td></tr>
			<tr>
				<td><spring:message code="Score"/></td>
				<td><form:input path="score" readonly="true"/></td>		
				<td><form:errors path="score" cssStyle="color: red;" /></td>
			</tr>
			<tr><td> &nbsp; <td></tr>
			<tr>
				<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="submit" class="table table-hover" value="Update" style="height:30px; width:70px"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>