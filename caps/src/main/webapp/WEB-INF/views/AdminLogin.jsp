<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<s:url value="/css/style2.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />

<h2 style="padding-top: 120px;">Administrator Login</h2>

<div>
	<form:form modelAttribute="admin" method="POST"
		action="${pageContext.request.contextPath}/adminlogin">
		<table class="table table-borderless" style="width: 250px">
			<tr>
				<td colspan="3"><form:input path="username" size="40" class="form-control" placeholder="Input Username"
					style="width: 534px" /></td>
			</tr>
			<tr>
				
				<td colspan="3"><form:password path="password" size="40" class="form-control" placeholder="Input Password"
					style="width: 534px" /></td>
			</tr>
			<tr>
				<td colspan="3"><c:if test="${not empty message}">
						<div class="alert alert-warning" style="width: 100%;">
							${message}</div>
					</c:if></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Submit"
					class="btn btn-warning" style="width: 75px" /><input type="reset" value="Clear"
					class="btn btn-warning" style=" width: 75px; margin-left: 10px;" /></td>
			</tr>
		</table>
	</form:form>
</div>
</html>