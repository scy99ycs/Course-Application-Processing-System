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
<title>Enrollment List</title>
</head>

<body>

	<h2 class="container" style="padding-top: 151px;">Course List Page</h2>

	<c:if test="${fn:length(GradeList) gt 0}">

		<table class="table table-hover"
			style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th><spring:message code="CourseId" /></th>
					<th><spring:message code="CourseName" /></th>
					<th><spring:message code="Score" /></th>
					<th><spring:message code="Grade" /></th>
				</tr>
			</thead>
			<c:forEach var="enrollment" items="${GradeList}" varStatus="index">
				<tr class="ListRecord">
					<td align="left">${enrollment.courseId}</td>
					<td align="left">${courseName.get(index.index).courseName}</td>
					<td align="left"><c:choose>
							<c:when test="${empty enrollment.score}">No score yet</c:when>
							<c:otherwise>${enrollment.score}</c:otherwise>
						</c:choose></td>
					<td align="left">${grades.get(index.index)}</td>
				</tr>
			</c:forEach>
			<tr style="font-weight: bold;">
				<td>GPA (0 to 4)</td>
				<td></td>
				<c:choose>
					<c:when test="${empty GPA}">
						<td>To be graded</td>
					</c:when>
					<c:otherwise>
						<td>${GPA}</td>
					</c:otherwise>
				</c:choose>
				<td></td>
			</tr>

		</table>

	</c:if>

</body>
</html>