<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<spring:url value="/css/simple.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />
<form:form modelAttribute="lecturer" method="POST"
	action="${pageContext.request.contextPath}/lecturerlogin">
	<table class="framed">
		<tr>
			<td><spring:message code="fieldLabel.username" /></td>
			<td colspan="3"><form:input path="username" size="40" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.password" /></td>
			<td colspan="3"><form:password path="password" size="40" /></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><form:button name="submit" type="submit" value="s">
					<img
						src="${pageContext.request.contextPath}/image/button_login.gif"
						alt="" align="middle">
				</form:button></td>
			<td><form:button name="clear" type="reset" value="r">
					<img
						src="${pageContext.request.contextPath}/image/button_clear.gif"
						alt="" align="middle">
				</form:button></td>
		</tr>
	</table>
</form:form>
</html>