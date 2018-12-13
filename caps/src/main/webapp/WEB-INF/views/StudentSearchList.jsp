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


	<h2 style="color:#000">${message}</h2>
	<c:remove var = "message" scope = "session"/>
	<br></br>
		<h2 style="color:#000">${errormessage}</h2>
	<c:remove var = "errormessage" scope = "session"/>
	
	
<form:form action="${pageContext.request.contextPath}/student/search" method="post">
    <input name="Name" type="text"/>
    <input type="submit" value="Submit">
</form:form>

<c:if test="${fn:length(courseList) gt 0}">

<table style="cellspacing: 2; cellpadding: 2; border: 1;">



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

	<c:forEach var= "course" items="${courseList}">
	
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
	</c:forEach>

</table>



</c:if>




</body>
</html>