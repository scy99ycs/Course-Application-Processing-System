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
<form:errors path="courseName" cssStyle="color:red;" />
<form:form  action="${pageContext.request.contextPath}/admin/lecturer/new.html" method="POST" modelAttribute="Lecturer">
<%-- Staff ID : <form:input  path="staffId"  size="10" /> <br/> --%>
Staff Name : <form:input  path="staffName" size ="100" /> <br/>
Designation : <form:input path="designation" size="50" /> <br/>
User Name :  <form:input path="username" size="50" /> <br/>
Password :  <form:input path="password" size="50" /> <br/>
<input type="submit" value="Submit" /> <br/>
<input type="reset" value="Cancel" /> <br/>
</form:form>
</body>
</html>
	
	
