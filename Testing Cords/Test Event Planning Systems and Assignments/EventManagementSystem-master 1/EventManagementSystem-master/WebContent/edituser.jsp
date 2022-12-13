<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<jsp:useBean id="allusers" class="user.StaffUser" scope="request" />
<%@ page import="user.StaffUser" %>
<%
  String pagesessionrole = "";
  if(session.getAttribute("session_isloggedin") != null) {
    pagesessionrole = (String)session.getAttribute("session_userrole");  
                  
  } else {
    response.sendRedirect("presetevents.jsp");
  }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XPERT Events - Edit User</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
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
          String firstname = user.getFirstName();
          String lastname = user.getLastName();
          String role = user.getUserRole();
          String contactnum = "";

          if(role.equalsIgnoreCase("client")) {
            contactnum = user.getContactNum();
          }
              
        %>
        <h2>Edit User</h2>

        <div id="main-content" >
          <fieldset>
            <form action="${pageContext.request.contextPath}/UserController" method="post">
              
              <input name="userid" type="hidden" value="<%=userid%>">

              <table width="200" border="0">
                <tr>
                  <td width="32%"><label>Username*</label>&nbsp;</td>
                  <td width="68%"><input name="username" type="text" id="username" maxlength="20" required autofocus value="<%=username%>"></td>
                </tr>
          
                <tr>
                  <td width="32%"><label>Email Address*</label>&nbsp;</td>
                  <td width="68%"><input name="emailaddress" type="email" id="emailaddress" maxlength="50" required value="<%=email%>"></td>
                </tr>
          
                <tr>
                  <td width="32%"><label>First Name*</label>&nbsp;</td>
                  <td width="68%"><input name="firstname" type="text" id="firstname" maxlength="30" required value="<%=firstname%>"></td>
                </tr>
                
                <tr>
                  <td width="32%"><label>Last Name*</label>&nbsp;</td>
                  <td width="68%"><input name="lastname" type="text" id="lastname" maxlength="30" required value="<%=lastname%>"></td>
                </tr>
          
                <tr>
                  <td><label>User Role*</label>&nbsp;</td>
                  <td>
                    <p>
                      <label><input type="radio" name="userrole" value="Employee" id="category_0"> Employee</label>
                      <label><input type="radio" name="userrole" value="Manager" id="category_1"> Manager</label>
                      <label><input type="radio" name="userrole" value="Admin" id="category_2"> Admin</label>
                      <label><input type="radio" name="userrole" value="Client" id="category_3"> Client</label>
                    </p>
                  </td>
                </tr>

                <tbody class="newclient">
                  <tr>
                    <td><label>Contact Number*</label></td>
                    <td><input type="text" name="contactnumber" id="contactnumber" pattern="^\s*\(?(020[7,8]{1}\)?[ ]?[1-9]{1}[0-9{2}[ ]?[0-9]{4})|(0[1-8]{1}[0-9]{3}\)?[ ]?[1-9]{1}[0-9]{2}[ ]?[0-9]{3})\s*$" value="<%=contactnum%>"></td>
                  </tr>
                </tbody>
          
                <tr>
                  <td><input type="submit" style="margin-left: 2px;" class="formbutton" id="login-button" value="Edit" name="action"/>&nbsp;</td>
                </tr>
              </table>
              <p>&nbsp;</p>
            </form>
          </fieldset>          
        </div>
            
        </article>
      </section>
        
    <div class="clear"></div>
  </div> <!-- end of body-->
  
  <jsp:directive.include file="include/footer.html" />
</div>
</body>
</html>
<script language="javascript" type="text/javascript">
  $(function () {

    //This part checks the user role to set the correct radio button.
    var userrole = '<%=role%>';
    if(userrole == "Employee") {
      $("#category_0").prop("checked", true);
    } else if(userrole == "Manager") {
      $("#category_1").prop("checked", true);
    } else if(userrole == "Admin") {
      $("#category_2").prop("checked", true);
    } else { //Client role
      $("#category_3").prop("checked", true);
      $(".newclient").show();
      $("#contactnumber").prop("required", true);
    }

    //Show contact number form if role is client.
    $("input[name='userrole']").click(function () {
      if ($("#category_3").is(":checked")) {  
        $(".newclient").show();
        $("#contactnumber").prop("required", true);
        $("#contactnumber").val('<%=contactnum%>');
      } else {
        $(".newclient").hide();
        $("#contactnumber").prop("required", false);
        $("#contactnumber").val("");
      }
    });

  
  });                       
</script>