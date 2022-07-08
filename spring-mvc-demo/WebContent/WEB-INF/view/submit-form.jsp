<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> ${param.nameInp} </title>
</head>
<body>
	<h2> ${message} ${nameForm.name}</h2>
	<h3>${nameForm}</h3>
	<img alt="Family Photo" width="500" height="600" src="${pageContext.request.contextPath}/resources/images/IMG_20210821_220147.jpg">
	
</body>
</html>