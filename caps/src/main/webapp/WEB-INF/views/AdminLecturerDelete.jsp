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
<title>Delete Lecturer</title>
</head>
<body>
<h2>Delete Lecturer</h2>
<form:errors path="courseName" cssStyle="color:red;" />
<a href="${pageContext.request.contextPath}/admin/lecturer/delete/${lecturer.staffId}.html"></a>
</body>
</html>