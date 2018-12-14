<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Lecturer</title>
</head>
<body>
	<h2>Add Lecturer</h2>
	<form:form
		action="${pageContext.request.contextPath}/admin/lecturer/new.html"
		method="POST" modelAttribute="lecturer">
		<table align="center"
			style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tbody>
				<tr>
					<td>Staff Name :</td>
					<td><form:input path="staffName" size="50" />
						<form:errors path="staffName" cssStyle="color:white;" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><form:input path="designation" size="50" />
						<form:errors path="designation" cssStyle="color:white;" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><form:input path="designation" size="50" />
						<form:errors path="designation" cssStyle="color:white;" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input class="btn btn-warning" type="submit"
						value="Submit" /> <input class="btn btn-warning" type="reset"
						value="Reset" style="margin-left: 10px;" /></td>
				</tr>
				<%-- User Name :  <form:input path="username" size="50" /><form:errors path="username" cssStyle="color:white;" /> <br/> --%>
				<%-- Password :  <form:input path="password" size="50" /><form:errors path="password" cssStyle="color:white;" /> <br/> --%>
			</tbody>
		</table>
	</form:form>
</body>
</html>


