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
<p class ="errormessage">${message}</p>
<form:form>
<c:if test="${fn:length(studentList) gt 0}">
<table>
	<tr>
		<th><spring:message code="Student Id"/></th>
		<th><spring:message code="First & Middle Name"/></th>
		<th><spring:message code="Last Name"/></th>
		<th><spring:message code="User Name"/></th>
		<th><spring:message code="Edit"/></th>
		<th><spring:message code="Delete"/></th>
	</tr>
	
	<c:forEach var="student" items="${studentList}">
	<tr>
		<td>${student.studentId}</td>
		<td>${student.firstMidName}</td>
		<td>${student.lastName}</td>
		<td>${student.username}</td>
		<td align="center"><a
				href="${pageContext.request.contextPath}/admin/student/edit/${student.studentId}.html"><spring:message
						code="Edit" /></a></td>
		<td><a
				href="${pageContext.request.contextPath}/admin/student/delete/${student.studentId}.html"><spring:message
						code="Delete" /></a></td>
	</tr>
	</c:forEach>
</table>
</c:if>	
</form:form>
</body>
</html>