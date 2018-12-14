<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Lecturer Details</title>
</head>
<body>
	<h2>Edit Lecturer Details</h2>
	<form:errors path="courseName" cssStyle="color:red;" />
	<form:form
		action="${pageContext.request.contextPath}/admin/lecturer/edit.html"
		method="POST" modelAttribute="lecturer">
		<table align="center" style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tbody>
				<tr>
					<td>Staff ID :</td>
					<td><form:input path="staffId" size="50" readonly="true" /></td>
				</tr>
				<tr><td>&nbsp; </td></tr>
				<tr>
					<td>Staff Name :</td>
					<td><form:input path="staffName" size="50" /></td>
				</tr>
				<tr><td>&nbsp; </td></tr>
				<tr>
					<td>Designation :</td>
					<td><form:input path="designation" size="50" /></td>
				</tr>
				<tr><td>&nbsp; </td></tr>
				<tr>
					<td>User Name :</td>
					<td><form:input path="username" size="50" /></td>
				</tr>
				<tr><td>&nbsp; </td></tr>
				<tr>
					<td>Password :</td>
					<td><form:input path="password" size="50" /></td>
				</tr>
				<tr><td>&nbsp; </td></tr>
				<tr>
					<td></td>
					<td align="right"><input class="btn btn-warning" type="submit"
						value="Submit" /> <input class="btn btn-warning" type="reset"
						value="Reset" style="margin-left: 10px;" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>