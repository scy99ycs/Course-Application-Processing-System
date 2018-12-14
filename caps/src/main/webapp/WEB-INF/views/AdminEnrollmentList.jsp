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
<title>Insert title here</title>
</head>
<body>
	<p class="errormessage">${message}</p>
	<br/>
<p align="left">
<a href="${pageContext.request.contextPath}/admin/enrollment/add.html"><input class="table table-hover" type="submit" value="Add New Enrollment" style="height:30px; width:180px"/></a>
</p><br/>
	
	<form:form>
		<c:if test="${fn:length(enrollmentList) gt 0}">
			<table align="center" class = "table table-hover" style="cellspacing: 2; cellpadding: 2; border: 1;">
				<tr>
					<th><spring:message code="Enrollment Id" /></th>
					<th><spring:message code="Course Id" /></th>
					<th><spring:message code="Student Id" /></th>
					<th><spring:message code="Score" /></th>
					<th><spring:message code="Edit" /></th>
					<th><spring:message code="Delete" /></th>
				</tr>

				<c:forEach var="enrollment" items="${enrollmentList}">
					<tr>
						<td>${enrollment.enrollmentId}</td>
						<td>${enrollment.courseId}</td>
						<td>${enrollment.studentId}</td>
						<td>${enrollment.score}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/admin/enrollment/edit/${enrollment.enrollmentId}.html"><spring:message
									code="Edit" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/enrollment/delete/${enrollment.enrollmentId}.html"><spring:message
									code="Delete" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>