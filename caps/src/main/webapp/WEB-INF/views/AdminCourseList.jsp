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
<form:form>
<c:if test="${fn:length(courseList) gt 0}">
<table>
	<tr>
		<th><spring:message code="Course Id"/></th>
		<th><spring:message code="Course Name"/></th>
		<th><spring:message code="Credit"/></th>
		<th><spring:message code="Capacity"/></th>
		<th><spring:message code="Staff Id"/></th>
		<th><spring:message code="Edit"/></th>
		<th><spring:message code="Delete"/></th>
	</tr>
	
	<c:forEach var="course" items="${courseList}">
	<tr>
		<td>${course.courseId}</td>
		<td>${course.courseName}</td>
		<td>${course.credit}</td>
		<td>${course.capacity}</td>
		<td>${course.staffId}</td>
		<td align="center"><a
				href="${pageContext.request.contextPath}/admin/course/edit/${course.courseId}.html"><spring:message
						code="Edit" /></a></td>
		<td><a
				href="${pageContext.request.contextPath}/admin/course/delete/${course.courseId}.html"><spring:message
						code="Delete" /></a></td>
	</tr>
	</c:forEach>
</table>
</c:if>	
</form:form>
</body>
</html>