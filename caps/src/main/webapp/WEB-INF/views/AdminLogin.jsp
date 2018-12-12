<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<s:url value="/css/style2.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />

<form:form modelAttribute="admin" method="POST"
	action="${pageContext.request.contextPath}/adminlogin">
	<table class="framed">
		<tr>
			<td><s:message code="fieldLabel.username" /></td>
			<td colspan="3"><form:input path="username" size="40" /></td>
		</tr>
		<tr>
			<td><s:message code="fieldLabel.password" /></td>
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