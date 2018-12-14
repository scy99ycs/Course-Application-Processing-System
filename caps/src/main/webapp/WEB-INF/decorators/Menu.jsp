<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<body>
	<c:choose>
		<c:when test="${sessionScope.USERSESSION.admin != null}">
			<li><a
				href="${pageContext.request.contextPath}/admin/student/list"><spring:message
						code="Manage Students" /> </a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/lecturer/list"> <spring:message
						code="Manage Lecturers" />
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/course/list"> <spring:message
						code="Manage Courses" />
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/enrollment/list">
					<spring:message code="Manage Enrollment" />
			</a></li>
		</c:when>

		<c:when test="${sessionScope.USERSESSION.lecturer != null}">
			<li><a
				href="${pageContext.request.contextPath}/lecturer/courselist"><spring:message
						code="My Courses" /> </a></li>
			<li><a
				href="${pageContext.request.contextPath}/lecturer/performance">
					<spring:message code="View a Student's Performance" />
			</a></li>
		</c:when>

		<c:when test="${sessionScope.USERSESSION.student != null}">
			<li><a href="${pageContext.request.contextPath}/student/landing"><spring:message
						code="Student Information" /> </a></li>
			<li><a href="${pageContext.request.contextPath}/student/search">
					<spring:message code="View Course List" />
			</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/home"><spring:message
						code="Home" /> </a></li>
			<li><a href="${pageContext.request.contextPath}/adminlogin"><spring:message
						code="Login as Administrator" /> </a></li>
			<li><a href="${pageContext.request.contextPath}/lecturerlogin"><spring:message
						code="Login as Lecturer" /> </a></li>
			<li><a href="${pageContext.request.contextPath}/studentlogin"><spring:message
						code="Login as Student" /> </a></li>
		</c:otherwise>
	</c:choose>

</body>

