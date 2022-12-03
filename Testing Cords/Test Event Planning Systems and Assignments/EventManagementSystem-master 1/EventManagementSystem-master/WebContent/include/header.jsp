<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<header>
	<div class="width">
   		<h1><a href="index.jsp">XPERT EVENTS</a></h1>
   	</div>
</header>

<nav>
	<div class="width">
  		<ul>
       		<%
				String homeurl = "";
       			int sessionuserid = 0;
       			if(session.getAttribute("session_isloggedin") != null) {
       				String sessionrole = (String)session.getAttribute("session_userrole"); 
       				sessionuserid = (Integer)session.getAttribute("session_userid");
       				if(sessionrole.equalsIgnoreCase("client")) {
       					homeurl = "presetevents.jsp";
       				} else if(sessionrole.equalsIgnoreCase("admin")){
       					homeurl = "adminhome.jsp";
       				} else {
						homeurl = "index.jsp";
					}
					
				} else {
					homeurl = "presetevents.jsp";
				}
			%>
       		
       		<li class="start selected"><a href="<%=homeurl%>">Home</a></li>
       	    <li class=""><a href="contactus.jsp">Contact</a></li>
			<%
				if(session.getAttribute("session_isloggedin") != null) {
			%>
					<li class=""><a href="user.jsp?id=<%=sessionuserid%>">Account</a></li>
					<li class=""><a href="${pageContext.request.contextPath}/LoginController?logout=1">Logout</a></li>
			<%
				} else {
			%>
					<li class=""><a href="login.jsp">Log In</a></li>
			<%
				}
			%>
                     
      	</ul>
	</div>
</nav>