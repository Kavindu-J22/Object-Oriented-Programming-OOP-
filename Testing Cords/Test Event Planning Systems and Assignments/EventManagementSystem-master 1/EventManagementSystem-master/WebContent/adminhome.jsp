<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<jsp:useBean id="allusers" class="user.StaffUser" scope="request" />
<%@ page import="user.StaffUser" %>
<%
  String pagesessionrole = "";
  if(session.getAttribute("session_isloggedin") != null) {
    pagesessionrole = (String)session.getAttribute("session_userrole");  

    if(!pagesessionrole.equalsIgnoreCase("admin")) {
      response.sendRedirect("index.jsp");
    } 
                  
  } else {
    response.sendRedirect("presetevents.jsp");
  }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XPERT Events - Admin</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">

  <jsp:directive.include file="include/header.jsp" />

  <div id="body" class="width">

    <section id="content" class="two-column">
  	    
      <article>	
        <h2>Welcome</h2>

        <div id="main-content" >
          <div id="refinesearch">
            <button type="button" style="margin-left: 2px;" class="formbutton" id="adduser"
                  onclick="document.location.href='adduser.jsp';">Add New User</button>
          </div>

          <fieldset>
            <legend>All Users</legend>
          </fieldset>
          <table id = "tablecontainer">
            <thead>
              <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Role</th>
              </tr> 
            </thead>

            <tbody>
              <% 
                ArrayList<StaffUser> users = allusers.viewUsers();
                if(!users.isEmpty()) {
                  for (StaffUser user : users) {
                    int userid = user.getUserid();
                    String username = user.getUserName();
                    String completename = user.getFirstName() + " " + user.getLastName();
                    String role = user.getUserRole();
                    String url = "user.jsp?id=" + userid;
              %>
                    <tr>
                      <td width="30%"><a href=<%=url%>> <%=username%> </a></td>
                      <td width="50%"><%=completename%></td>
                      <td width="20%"><%=role%></td>
                    </tr>
              <%
                  } 
                } else {
              %>
                    <tr> 
                      <td colspan="3">No Users to Display</td>
                    </tr>
              <%
                  }
              %>
            </tbody>    
          </table> <!--end of table-->
        </div>

      </article>
    </section>
            
    <div class="clear"></div>
  </div> <!--end of body-->

  <jsp:directive.include file="include/footer.html" />
</div>
</body>
</html>