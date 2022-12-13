<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.getSession(false).removeAttribute("UserId");
		request.getSession(false).invalidate();
		response.sendRedirect("../index.jsp");
		
	%>

</body>
</html>