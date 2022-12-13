<%@page import="com.oop.model.Employee"%>
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
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Get Employee Page</h2>

	SLIIT Employee Management App for OOP jsp servlet.
	<br>
	<br>
	<%
		Employee employee = (Employee) request.getAttribute("employee");
	%>

	<form method="POST" action="UpdateEmployeeServlet">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="employeeID" disabled="disabled"
					value="<%=employee.getEmployeeID()%>" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="employeeName"
					value="<%=employee.getName()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=employee.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Employee Designation</td>
				<td><input type="text" name="designation"
					value="<%=employee.getDesignation()%>" /></td>
			</tr>
			<tr>
				<td>Faculty</td>
				<td><input type="text" name="faculty"
					value="<%=employee.getFacultyName()%>" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><input type="text" name="department"
					value="<%=employee.getDepartment()%>" /></td>
			</tr>
			<tr>
				<td>Qualifications</td>
				<td><input type="text" name="qualification"
					value="<%=employee.getQualifications()%>" /></td>
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
				<td colspan="2"><input type="hidden" name="employeeID"
					value="<%=employee.getEmployeeID()%>" /> <input type="submit"
					value="Update Employee" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteEmployeeServlet">
					<input type="hidden" name="employeeID"
						value="<%=employee.getEmployeeID()%>" /> <input type="submit"
						value="Delete Employee" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>