<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<body>
		<c:choose>
			<c:when test="${sessionScope.USERSESSION.admin != null}">
				<li><a href="${pageContext.request.contextPath}/admin/student/list"
					class="list-group-item list-group-item-action"><spring:message
						code="Manage Students" /> 
				</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/lecturer/list"
					class="list-group-item list-group-item-action"> <spring:message
						code="Manage Lecturers" />
				</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/course/list"
					class="list-group-item list-group-item-action"> <spring:message
						code="Manage Courses" />
				</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/enrollment/list"
					class="list-group-item list-group-item-action"> <spring:message
						code="Manage Enrollment" />
				</a></li>
				<li><a href="${pageContext.request.contextPath}/logout"
					class="list-group-item list-group-item-action"> <spring:message
						code="Logout" />
				</a></li>
			</c:when>
			
			<c:when test="${sessionScope.USERSESSION.lecturer != null}">
				<li><a href="${pageContext.request.contextPath}/lecturer/courselist"
					class="list-group-item list-group-item-action"><spring:message
						code="My Courses" /> 
				</a></li>
				<li><a href="${pageContext.request.contextPath}/lecturer/performance"
					class="list-group-item list-group-item-action"> <spring:message
						code="View a Student's Performance" />
				</a></li>
				<li><a href="${pageContext.request.contextPath}/logout"
					class="list-group-item list-group-item-action"> <spring:message
						code="Logout" />
				</a></li>
			</c:when>
			
			<c:when test="${sessionScope.USERSESSION.student != null}">
				<li><a href="${pageContext.request.contextPath}/student/landing"
					class="list-group-item list-group-item-action"><spring:message
						code="Student Information" /> 
				</a></li>
				<li><a href="${pageContext.request.contextPath}/student/search"
					class="list-group-item list-group-item-action"> <spring:message
						code="View Course List" />
				</a></li>
				<li><a href="${pageContext.request.contextPath}/logout"
					class="list-group-item list-group-item-action"> <spring:message
						code="Logout" />
				</a></li>
			</c:when>
			
		</c:choose>

</body>

