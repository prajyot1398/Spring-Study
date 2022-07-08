<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Confirmation : ${student.firstName}</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	
	<h1>The Student ${student.firstName} ${student.lastName} Is Confirmed! </h1>
	
	<!-- <h2>${student.firstName} Is From ${student.country}.</h2> -->
	<!-- <h2>${student.firstName} Is From ${student.availableCountries[student.country]}.</h2> -->
	<h2>${student.firstName} Is From ${availableCountries[student.country]}.</h2> <!-- Fetched from countries.properties -->
	
	<h2>Favorite Programming Language : ${student.favouritePL}</h2>
	<br>
	OS Interacted With : 
	<ul>
	<c:forEach var="temp" items="${student.osInteracted}">
		<li> ${temp} </li>	
	</c:forEach>
	</ul>
	<a href="${pageContext.request.contextPath}"> Go To Main Menu</a>
</body>
</html>