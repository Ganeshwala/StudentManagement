<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h3>Add New Stundet</h3>
</div>
	<div align="center">
		<form:form modelAttribute="student" action="saveStudent">
				<form:hidden path="studentId"/>
				<label>Name:</label>
				<form:input path="studentName"/>
				</br>
				<label>Modile:</label>
				<form:input path="studentNumber"/></br>
				<label>Country:</label>
				<form:input path="country"/></br>
				</br>
				<input type="submit" value="Add Student">
			</form:form>
	</div>
</body>
</html>