<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<style>
hr.style13 {
	height: 10px;
	border: 0;
	box-shadow: 0 10px 10px -10px #8c8b8b inset;
}

hr.style14 {
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
	background-image: -moz-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
	background-image: -ms-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
	background-image: -o-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
}

a {
	font-size: 1em;
}

.list-group-item-action {
	text-align: center;
	font-weight: bold;
	font-size: 1.25em;
}
</style>

</head>
<body>
	<div class="list-group">

		<c:choose>
			<c:when test="${sessionScope.USERSESSION.admin != null}">
				<a href="${pageContext.request.contextPath}/admin/student/list"
					class="list-group-item list-group-item-action"><spring:message
						code="Manage Students" /> </a>
				<br />
				<a href="${pageContext.request.contextPath}/admin/lecturer/list"
					class="list-group-item list-group-item-action"> <spring:message
						code="Manage Lecturers" />
				</a>
				<br />
				<a href="${pageContext.request.contextPath}/admin/course/list"
					class="list-group-item list-group-item-action"> <spring:message
						code="Manage Courses" />
				</a>
				<br />
				<a href="${pageContext.request.contextPath}/admin/enrollment/list"
					class="list-group-item list-group-item-action"> <spring:message
						code="Manage Enrollment" />
				</a>
				<br />
				<a href="${pageContext.request.contextPath}/logout"
					class="list-group-item list-group-item-action"> <spring:message
						code="Logout" />
				</a>
				<br />
			</c:when>
			<c:when test="${sessionScope.USERSESSION.lecturer != null}">
				<a href="${pageContext.request.contextPath}/lecturer/courselist"
					class="list-group-item list-group-item-action"><spring:message
						code="My Courses" /> </a>
				<br />
				<a href="${pageContext.request.contextPath}/lecturer/performance"
					class="list-group-item list-group-item-action"> <spring:message
						code="View a Student's Performance" />
				</a>
				<br />
				<a href="${pageContext.request.contextPath}/logout"
					class="list-group-item list-group-item-action"> <spring:message
						code="Logout" />
				</a>

			</c:when>
			<c:when test="${sessionScope.USERSESSION.student != null}">
				<a href="${pageContext.request.contextPath}/student/landing"
					class="list-group-item list-group-item-action"><spring:message
						code="Student Information" /> </a>
				<br />
				<a href="${pageContext.request.contextPath}/student/search"
					class="list-group-item list-group-item-action"> <spring:message
						code="View Course List" />
				</a>
				<br />
				<a href="${pageContext.request.contextPath}/logout"
					class="list-group-item list-group-item-action"> <spring:message
						code="Logout" />
				</a>

			</c:when>
		</c:choose>

	</div>
</body>

