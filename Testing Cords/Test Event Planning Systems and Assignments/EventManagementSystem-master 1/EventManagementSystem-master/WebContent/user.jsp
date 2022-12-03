<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<jsp:useBean id="allusers" class="user.StaffUser" scope="request" />
<%@ page import="user.StaffUser" %>
<%
  String pagesessionrole = "";
  int admin = 0;
  if(session.getAttribute("session_isloggedin") != null) {
    pagesessionrole = (String)session.getAttribute("session_userrole");  

    if(pagesessionrole.equalsIgnoreCase("admin")) {
      admin = 1;
    } 
                  
  } else {
    response.sendRedirect("presetevents.jsp");
  }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XPERT Events - User</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">

    <jsp:directive.include file="include/header.jsp" />

    <div id="body" class="width">

        <jsp:directive.include file="include/sidemenu.jsp" />

		    <section id="content" class="two-column">

    	    <article>
            <% 
              String userid = request.getParameter("id");
              StaffUser user = null;

              user = allusers.viewUser(Integer.parseInt(userid));
              
              if(user == null) {
                response.sendRedirect("error.jsp");
              }
              String username = user.getUserName();
              String email = user.getEmailAddress();
              String completename = user.getFirstName() + " " + user.getLastName();
              String role = user.getUserRole();
              
            %> 
        	    <h3><%=username%></h3>

              <div id="refinesearch">
                <%
                  if(admin == 1) {
                %>
                    <button type="button" style="margin-left: 2px;" class="formbutton" id="resetcredentials" 
                      onclick="document.location.href='resetcredentials.jsp?id=<%=userid%>';">Reset Credentials</button>
                    <button type="button" style="margin-left: 2px;" class="formbutton" id="deleteuser">Delete User</button>
                <%                
                  } else {
                %>
                    <button type="button" style="margin-left: 2px;" class="formbutton" id="editdetails" 
                      onclick="document.location.href='edituser.jsp?id=<%=userid%>';">Edit Details</button>
                <%
                  }
                %>
              </div>

              <div id="main-content" >
                <fieldset>
                  <table width="200" border="0">
                    <tr>
                      <td width="32%"><label>Username</label>&nbsp;</td>
                      <td width="68%"><%=username%></td>
                    </tr>
                        
                    <tr>
                      <td><label>Email Address</label></td>
                      <td><%=email%></td>
                    </tr>
                        
                    <tr>
                      <td><label>Name</label></td>
                      <td><%=completename%></td>
                    </tr>
                           
                    <tr>
                      <td><label>Role</label></td>
                      <td><%=role%></td>
                    </tr>

                    <% 
                      if(role.equalsIgnoreCase("client")) {
                    	  String contactnum = user.getContactNum();
                   	%>
                      	<tr>
                          <td><label>Contact Number</label></td>
                          <td><%=contactnum%></td>
                        </tr>
                    <%
                      }
                    %> 
                  
                  </table>
                </fieldset>
              </div>
                
            </article>
        </section>
        
    	<div class="clear"></div>
    </div> <!-- end of body -->

    <jsp:directive.include file="include/footer.html" />
</div>
<div id="deletedialog" style="display: none">
  <p>Are you sure you want to delete this user?</p>
  <form style="display: hidden" action="${pageContext.request.contextPath}/UserController" method="get" id="hiddendeleteform">
    <input name="id" type="hidden" value="<%=userid%>">
  </form>
</div>
</body>
</html>

<script language="javascript" type="text/javascript">
  $(function () {

        $("#deletedialog").dialog({
          modal: true,
          autoOpen: false,
          width: 300,
          resizable:false,
          title:'Delete',
          buttons: {
            "Delete": function() {
              $(this).dialog("close");
              $("#hiddendeleteform").submit();
            },
            "Cancel": function() {
              $(this).dialog("close");
            }
          } //End of button
        });

        $("#deleteuser").click(function () {
          $("#deletedialog").dialog("open");
        });
  });                       
</script>