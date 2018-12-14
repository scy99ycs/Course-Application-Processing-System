<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h2>Edit Course Details</h2>
<form:form method="POST" modelAttribute="course"
	action="${pageContext.request.contextPath}/admin/course/edit/${course.courseId}.html">
	<p class ="errormessage">${message}</p>
	<table align="center" style="cellspacing: 2; cellpadding: 2; border: 1;">		
	<tbody>
	<tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Course Id" /></td>
				<td><form:input path="courseId" readonly="true" /></td>
				<td><form:errors path="courseId" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Course Name" /></td>
				<td><form:input path="courseName"/></td>
				<td><form:errors path="courseName" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Capacity" /></td>
				<td><form:input path="capacity"/></td>
				<td><form:errors path="capacity" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Credit" /></td>
				<td><form:input path="credit"/></td>
				<td><form:errors path="credit" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Duration" /></td>
				<td><form:input path="duration"/></td>
				<td><form:errors path="duration" cssStyle="color: red;" /></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>	
			<td>Staff Id &nbsp; &nbsp; </td>
				<td><form:select path="staffId" style="width: 100px;">
					  <form:options items="${sidList}" />	
					  </form:select></td>
		</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td><spring:message code="Start Date"/></td>
				<td><form:input path="startDate" type="date" format="yyyy-MM-dd"/></td>	
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td></td>
				<td><input class="btn btn-warning" type="submit" value="Update" style="float:right"/></td>
			</tr>
		</tbody>
	</table>
</form:form>