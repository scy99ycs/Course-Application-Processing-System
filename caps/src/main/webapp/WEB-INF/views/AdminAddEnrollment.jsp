<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h2>Add New Enrollment</h2>

<form:form method="POST" modelAttribute="enrollment"
	action="${pageContext.request.contextPath}/admin/enrollment/add.html">
	<p class ="errormessage">${message}</p>
	<table align="center" style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tbody>
		<tr><td> &nbsp; </td></tr>
			<tr>
			<td>Student Id &nbsp; &nbsp; </td>
				<td><form:select path="studentId" style="width: 100px;">
					  <form:options items="${sidList}" />	
					  </form:select></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td>Course Id &nbsp;  </td>
				<td><form:select path="courseId" style="width: 100px;">
					  <form:options items="${cidList}" />	
					  </form:select></td>
			</tr><tr><td> &nbsp; </td></tr>
			<tr>
				<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input class="btn btn-warning" type="submit" value="Add" style="width:70px"/></td>
			</tr>
		</tbody>
	</table>
</form:form>