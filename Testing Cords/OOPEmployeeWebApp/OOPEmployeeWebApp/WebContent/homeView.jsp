<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />

<meta charset="UTF-8">
<title>SLIIT OOP Employee Management</title>
</head>
<body class="body">

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Add Employee Page</h2>

	   SLIIT Employee Management App for Object Orineted Progrmming
	<br>
	<br>

	<form method="POST" action="AddEmployeeServlet">
		<table>

			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="employeeName" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Employee Designation</td>
				<td><input type="text" name="designation" /></td>
			</tr>
			<tr>
				<td>Faculty</td>
				<td><input type="text" name="faculty" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><input type="text" name="department" /></td>
			</tr>
			<tr>
				<td>Qualifications</td>
				<td><input type="text" name="qualification" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked" tabindex="1" /> Male</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="gender" value="female"
					tabindex="2" /> Female</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Employee" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="ListEmployeeServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Employees" class="list-button" />
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>