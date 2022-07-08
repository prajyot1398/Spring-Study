<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<title>${student.firstName} Student Form</title>

	<style>
		.error {
			color : red;
		}
	</style>

</head>
<body>
	
	<form:form action="submitStudent" modelAttribute="student">
		First Name :  <form:input path="firstName"/>
		<c:if test="${validate}">
			*
			<form:errors path="firstName" cssClass="error"/>
			<input type="hidden" value="Validate" name="validate">
			
		</c:if>
		<br><br>
		Last Name : <form:input path="lastName"/>	
		<br><br>
		Country : <form:select path="country">
					<!-- <form:option value="India" label="India" />
					<form:option value="Brazil" label="Brazil" />
					<form:option value="USA" label="USA" />
					<form:option value="China" label="China" /> -->
					
					<!-- <form:options items="${student.availableCountries}"/> -->
					
					<form:options items="${availableCountries}"  />
						
				  </form:select>
		<br><br>		  
		Favorite Programming Language : 
		Java	<form:radiobutton path="favouritePL" value="Java"/>
		Python	<form:radiobutton path="favouritePL" value="Python"/>
		Javascript	<form:radiobutton path="favouritePL" value="Javascript"/>
		C#	<form:radiobutton path="favouritePL" value="C#"/>
		<br><br>	
		
		OS Interacted With:
		<!--  For type Checkbox we need collection data member as path, here array is taken -->
		Linux <form:checkbox path="osInteracted" value="Linux" />
		Mac OS <form:checkbox path="osInteracted" value="Mac OS" />
		MS Windows <form:checkbox path="osInteracted" value="MS Window" />
		<br><br>
		<input type="submit" value="Submit Student" />
	</form:form>
</body>
</html>