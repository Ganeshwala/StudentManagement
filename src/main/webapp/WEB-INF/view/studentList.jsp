<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/StudentManagement/URLToReach/CSS/myStyleSheet.css">
</head>
<body>
	<div>
		<form action="addStudent">
			<input type="submit" value="New Student">
		</form>
	</div>
	<div align="center">
		<h1>Student Coming soon</h1>
		<table>
			<thead>
				<th>Id</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Country</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach var="std" items="${studentList}">
					<tr>
						<td>${std.studentId}</td>
						<td>${std.studentName }</td>
						<td>${std.studentNumber }</td>
						<td>${std.country }</td>
						<td>
							<form action="updateStudent" method="post">
								<input type="hidden" name="studentId" value="${std.studentId }">
								<input type="submit" value="Update">
							</form>
						</td>
						<td>
							<form action="deleteStudent" method="post">
								<input type="hidden" name="studentId" value="${std.studentId }">
								<input type="submit" value="delete" onclick="if(!(confirm('Are you sure want to delete !'))) return false">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<img alt="Time Pass" src="/StudentManagement/URLToReach/Images/studentIMG.jpg">
	</div>
</body>
</html>