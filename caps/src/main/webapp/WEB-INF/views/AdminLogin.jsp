<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<s:url value="/css/style2.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />

<form:form modelAttribute="admin" method="POST"
	action="${pageContext.request.contextPath}/adminlogin">
	<table class="framed">
		<tr>
			<td><s:message code="USERNAME" /></td>
			<td colspan="3"><form:input path="username" size="40" /></td>
		</tr>
		<tr>
			<td><s:message code="PASSWORD" /></td>
			<td colspan="3"><form:password path="password" size="40" /></td>

		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Submit"/></td>
			<td><input type="reset" value="Clear"/></td>
		</tr>
	</table>
</form:form>
</html>