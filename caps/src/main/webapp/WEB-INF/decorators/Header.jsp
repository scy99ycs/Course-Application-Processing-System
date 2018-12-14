<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-md  fixed-top bg-dark"
	style="background-color: #383838;box-shadow: 0px 1px 10px #000;">
	<div class="header" style="width: 1500px">
		<div class="row">
			<div style="float: left; margin-left: 70px">
				<!-- style="display: flex; justify-content: flex-end" -->
				<img src="${pageContext.request.contextPath}/image/owl2.png" alt="CAPS" height="30" width="30"> <a
					class="navbar-brand mb-0 h1 text-light font-weight-bold"
					style="margin-left: 15px">Team 10 CAPS</a>
			</div>
			<%-- 			<c:if test=" ${not empty sessionScope.USERNAME}"> --%>
			<c:choose>
				<c:when test="${empty sessionScope.USERNAME }">
				</c:when>
				<c:otherwise>
					<div style="margin-left: 900px">
						<a class="navbar-brand mb-0 h1 text-light"
							style="padding-left: 70px"> Hello, <c:out
								value="${sessionScope.USERNAME}" /> !
						</a>

					</div>
					<div>
						<a href="${pageContext.request.contextPath}/logout">
							<button type="button" class="btn btn-outline-warning">
								Logout</button>
						</a>
					</div>
				</c:otherwise>
			</c:choose>
			<%-- 			<c:if test="false"> --%>

			<%-- 			</c:if> --%>

		</div>
	</div>
	<div class="hamb">
		<a href="#"><i class="fa fa-bars"></i></a>
	</div>
	<div role='navigation' id="mainnav" style="margin-top: 400px">
		<ul>

			<%@include file="Menu.jsp"%>
			<!-- 			<li><a href="#?">About Us</a></li> -->
		</ul>
	</div>
</nav>
