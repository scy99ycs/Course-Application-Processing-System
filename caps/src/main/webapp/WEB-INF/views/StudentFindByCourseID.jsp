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
<title>Insert title here</title>
</head>


<body>

	
<h3>Course List Page</h3> 

	
<c:if test="${fn:length(courseList) gt 0}">

<form:form method="POST" modelAttribute="Course"
	action="${pageContext.request.contextPath}/student/searchbyid">
	

<table style="cellspacing: 2; cellpadding: 2; border: 1;">

	<tbody>
			<tr>
				<td><spring:message code="SearchBar" /></td>
				<td><form:input path="courseId"/></td>
				<td><form:errors path="courseId" cssStyle="color: red;" /></td>
			</tr>

<tr class="listHeading">
		<th><spring:message code="CourseId" /></th>
		<th><spring:message code="CourseName" /></th>
		<th><spring:message code="Credit" /></th>
		<th><spring:message code="Capacity" /></th>
		<th><spring:message code="Duration" /></th>
		<th><spring:message code="StartDate" /></th>
		<th><spring:message code="StaffID" /></th>
		<th><spring:message code="View" /></th>	
	</tr>

		<tr class="ListRecord">
			<td align="left">${course.courseId}</td>
			<td align="left">${course.courseName}</td>
			<td align="left">${course.credit}</td>
			<td align="left">${course.capacity}</td>
			<td align="left">${course.duration}</td>
			<td align="left">${course.startDate}</td>
			<td align="left">${course.staffId}</td>
			
			<td align="center"><a 
			href="${pageContext.request.contextPath}/student/create/${course.courseId}"><spring:message
						code="view" /></a></td>
		</tr>
	</tbody>
</table>

</form:form>

</c:if>

</body>
</html>