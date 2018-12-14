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

<h2 class= "container" style = "padding-top: 151px;">Course List Page</h2> 

	<h3 style="color:#000">${message}</h3>
	<c:remove var = "message" scope = "session"/>
	<br/>
		<h3 style="color:#000">${errormessage}</h3>
	<c:remove var = "errormessage" scope = "session"/>
	
	
	




	<!-- Search bar -->
	<form:form action="${pageContext.request.contextPath}/student/search" method="POST">
			<div class="row col-md-5 col-centered">
				<div>
					<input name="Name" placeholder="Input Course Name" type="text" 
						class="form-control" style="width: 500px" />
				</div>
				<div>
					<input class="btn btn-warning" type="submit" value="Search"/>
				</div>
			</div>
		</form:form>
		<br />




<c:if test="${fn:length(courseList) gt 0}">

<table class = "table table-hover" style="cellspacing: 2; cellpadding: 2; border: 1;">
<thead>
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
</thead>
	<c:forEach var= "course" items="${courseList}">
	
		<tr class="ListRecord">
			<td align="left">${course.courseId}</td>
			<td align="left">${course.courseName}</td>
			<td align="left">${course.credit}</td>
			<td align="left">${course.capacity}</td>
			<td align="left">${course.duration}</td>
			<td align="left">${course.startDate}</td>
			<td align="left">${course.staffId}</td>
			<td align="left"><a 
			href="${pageContext.request.contextPath}/student/create/${course.courseId}"><spring:message
						code="View" /></a></td>	
		</tr>
	</c:forEach>

</table>

</c:if>

</body>
</html>