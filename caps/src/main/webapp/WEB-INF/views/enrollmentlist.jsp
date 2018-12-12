<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enrollment List</title>
</head>
<body>

<h3>Course List Page</h3>

	
<c:if test="${fn:length(GradeList) gt 0}">

<table style="cellspacing: 2; cellpadding: 2; border: 1;">



<tr class="listHeading">
		<th><spring:message code="CourseId" /></th>
		<th><spring:message code="Score" /></th>		
	</tr>

	<c:forEach var= "enrollment" items="${GradeList}">
	
		<tr class="ListRecord">
			<td align="left">${enrollment.courseId}</td>
			<td align="left">${enrollment.score}</td>		
		</tr>
	</c:forEach>

</table>

</c:if>

</body>
</html>