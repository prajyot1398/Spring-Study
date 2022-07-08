<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
</head>
<body>
	<h1>
		This Is The First Application Of Spring-MVC.
	</h1>
	
	<form action="redirectForms" method="GET" id="myForm"> 
		
		Go To HTML Form
		<input type="radio" name="formSelect" value="HTML" id="radio_2"/>
		<br><br>
		Go To Student Form (Spring MVC Form Tag)
		<input type="radio" name="formSelect" value="SpringMVC" id="radio_1"/>
		<br><br>
		Spring MVC Form Validation(Spring MVC Form Tag Only) : 
		<input type="checkbox" name="validate" value="Validate" id="validate" onchange="isRadio_1Checked()"/>
		<br><br>
		<input type="button" value="Submit" onclick="validateAndSubmit()"/>
	</form>
	
	<script type="text/javascript">
	
	function validateAndSubmit() {
		
		var radio_1 = document.getElementById("radio_1");
		var radio_2 = document.getElementById("radio_2");
		
		if(radio_2.checked || radio_1.checked) {
			document.getElementById("myForm").submit();
		}else {
			alert("Select Atleast One Radio Button");
		}
	}
	
	function isRadio_1Checked() {
		var checkBox = document.getElementById("validate");
		var radio_1 = document.getElementById("radio_1");
		
		if(!radio_1.checked) {
			checkBox.checked = false;
		}
	}
</script>
	
</body>
</html>