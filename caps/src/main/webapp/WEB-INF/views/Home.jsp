<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div>
		<img src="${pageContext.request.contextPath}/image/welcomebanner.jpg"
			alt="" align="middle">
	</div>
	<br />
	<div style="width: 1000px" align="justify">
		<h2 style="padding-top: 20px;">Welcome to Bond University</h2>
		<br/>
		<p>Bond University, an institution increasingly recognized as one
			of the world's finest research-intensive universities.</p>
		<p>The UVic community is deeply committed to contributing to a
			better future for people, places and the planet. Our success can be
			contributed to many factors: our talented and dedicated faculty; the
			energy, enthusiasm and inventiveness of graduate and undergraduate
			students; the dedication and support of excellent staff; the passion
			of our alumni to make a difference in their communities; and the
			support and active engagement of our many donors, partners and
			supporters.</p>
		<p>UVic is a research-intensive and student-centred university,
			with a diverse and welcoming west coast campus which fosters an
			institution-wide commitment to creating a strong, healthy future for
			our students and for our local and global communities. It is big
			enough to have an international presence and impact, yet small enough
			that students are able to develop a strong sense of community and
			lifelong connections with friends and mentors.</p>
		<p>Our university is a national and international leader in many
			areas of critical research and creative endeavour, and our faculty
			are committed and inspiring teachers. We offer our students a
			research-enriched education that is complemented by applied, clinical
			and work-integrated learning opportunities, making it among the best
			in the world.</p>
	</div>
	<div>
		<br />
		<hr />
		<h2 style="padding-top: 20px;">Courses offered by University</h2>
		<br />

		<!-- Search Bar -->
		<form:form action="${pageContext.request.contextPath}/home"
			method="POST" modelAttribute="course">
			<div class="row col-md-5 col-centered">
				<div>
					<input type="text" name="cName" placeholder="Type Course Name"
						class="form-control" style="width: 400px" />
				</div>
				<div>
					<input type="submit" name="search" value="Search"
						class="btn btn-warning " />
				</div>
				<div>
					<input type="submit" name="clear" value="Clear"
						class="btn btn-warning" />
				</div>
			</div>
		</form:form>
		<br />

		<!-- Message display -->
		<p style="font-size: 20px;">${message}</p>

		<!-- Search Results -->
		<table class="table table-hover" style="width: 1000px">
			<thead>
				<tr>
					<th>No</th>
					<th>Course Name</th>
					<th>Course Start Date</th>
					<th>Duration (days)</th>
					<th>Class Capacity</th>
					<th>Instructor</th>
				</tr>
			</thead>

			<c:forEach items="${courseList}" var="course" varStatus="index">
				<tr>
					<td>${index.index+1}</td>
					<td>${course.courseName}</td>
					<td><fmt:formatDate value="${course.startDate}"
							pattern="EEEE, d MMMM yyyy" /></td>
					<td>${course.duration}</td>
					<td>${course.capacity}</td>
					<td><c:out value="${lecList.get(index.index).staffName}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>