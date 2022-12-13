<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate Numbers</title>
</head>
<body>

	<form method="POST" action="CalculateServlet">

		No1 : <input type="text" name="no1" /><br /><br /> 
		No2 : <input type="text" name="no2" /><br /><br /> 
		
		<input type="submit" name="button" value="+" />
		<input type="submit" name="button" value="-" />
		<input type="submit" name="button" value="*" />
		<input type="submit" name="button" value="/" /><br /><br />
	
	</form>
</body>
</html>