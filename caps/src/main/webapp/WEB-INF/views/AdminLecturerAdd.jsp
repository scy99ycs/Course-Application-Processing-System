<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Lecturer</title>

</head>
<body>
<h2>Add Lecturer</h2>
<form:form  action="${pageContext.request.contextPath}/admin/lecturer/new.html" method="POST" modelAttribute="lecturer">
<%-- Staff ID : <form:input  path="staffId"  size="10" /> <br/> --%>
Staff Name : <form:input  path="staffName" size ="100" /><form:errors path="staffName" cssStyle="color:white;" /> <br/>
Designation : <form:input path="designation" size="50" /><form:errors path="designation" cssStyle="color:white;" /> <br/>
<%-- User Name :  <form:input path="username" size="50" /><form:errors path="username" cssStyle="color:white;" /> <br/> --%>
<%-- Password :  <form:input path="password" size="50" /><form:errors path="password" cssStyle="color:white;" /> <br/> --%>
<input type="submit" value="Submit" /> <br/>
<input type="reset" value="Reset" /> <br/>
</form:form>
</body>
</html>
	
	
