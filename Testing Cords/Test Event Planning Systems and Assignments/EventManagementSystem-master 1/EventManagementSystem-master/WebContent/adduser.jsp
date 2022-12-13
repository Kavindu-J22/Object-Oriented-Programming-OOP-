<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
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
<title>XPERT Events - Add User</title>
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
        <h2>Add User</h2>

        <div id="main-content" >
          <fieldset>
            <form action="${pageContext.request.contextPath}/UserController" method="post">
              <table width="200" border="0">
                <tr>
                  <td width="32%"><label>Username*</label>&nbsp;</td>
                  <td width="68%"><input name="username" type="text" id="username" maxlength="20" required autofocus pattern="^([a-zA-Z0-9_ ]){8,20}*$"></td>
                </tr>
          
                <tr>
                  <td width="32%"><label>Password*</label>&nbsp;</td>
                  <td width="68%">
                    <input name="password" type="password" id="password" maxlength="20" required pattern="(?=^.{8,20}$)^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$">
                    <span id="validationrules">
                      <p id="pvalidationrule">Uppercase and lowercase alphanumeric characters. 8-20 characters.</p>
                    </span>
                  </td>
                </tr>
          
                <tr>
                  <td width="32%"><label>Confirm Password*</label>&nbsp;</td>
                  <td width="68%">
                    <input name="confpassword" type="password" id="confpassword" maxlength="20" required>
                    <span id="validationrules" class="confirmpassvalidate" style="display:none">Passwords don't match.</span>
                  </td>
                </tr>
          
                <tr>
                  <td width="32%"><label>Email Address*</label>&nbsp;</td>
                  <td width="68%"><input name="emailaddress" type="email" id="emailaddress" maxlength="50" required></td>
                </tr>
          
                <tr>
                  <td width="32%"><label>First Name*</label>&nbsp;</td>
                  <td width="68%"><input name="firstname" type="text" id="firstname" maxlength="30" required pattern="^[a-zA-Z ]*$"></td>
                </tr>
                
                <tr>
                  <td width="32%"><label>Last Name*</label>&nbsp;</td>
                  <td width="68%"><input name="lastname" type="text" id="lastname" maxlength="30" required pattern="^[a-zA-Z ]*$"></td>
                </tr>
          
                <tr>
                  <td><label>User Role*</label>&nbsp;</td>
                  <td>
                    <p>
                      <label><input type="radio" name="userrole" value="Employee" id="category_0" checked = "checked"> Employee</label>
                      <label><input type="radio" name="userrole" value="Manager" id="category_1"> Manager</label>
                      <label><input type="radio" name="userrole" value="Admin" id="category_2"> Admin</label>
                      <label><input type="radio" name="userrole" value="Client" id="category_3"> Client</label>
                    </p>
                  </td>
                </tr>

                <tbody class="newclient">
                  <tr>
                    <td><label>Contact Number*</label></td>
                    <td><input type="text" name="contactnumber" id="contactnumber" pattern="^\s*\(?(020[7,8]{1}\)?[ ]?[1-9]{1}[0-9{2}[ ]?[0-9]{4})|(0[1-8]{1}[0-9]{3}\)?[ ]?[1-9]{1}[0-9]{2}[ ]?[0-9]{3})\s*$"></td>
                  </tr>
                </tbody>
          
                <tr>
                  <td><input type="submit" style="margin-left: 2px;" class="formbutton" id="login-button" value="Add" name="action"/>&nbsp;</td>
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

    //Add dynamic check of both passwords in case password is changed twice.
    $("#password").on("blur", function () {
      if($("#confpassword").val().length != 0) {
        checkPassword();
      } 
    });

    $("#confpassword").on("blur", function () {
        checkPassword();
    });

    //Show contact number form if role is client.
    $("input[name='userrole']").click(function () {
      if ($("#category_3").is(":checked")) {  
        $(".newclient").show();
        $("#contactnumber").prop("required", true);
      } else {
        $(".newclient").hide();
        $("#contactnumber").prop("required", false);
      }
    });

    function checkPassword() {
      var checkpass = $("#password").val();

      if($("#confpassword").val() != checkpass) {
        $(".confirmpassvalidate").show();
        $(".formbutton").prop("disabled", true);
        
      } else {
        $(".confirmpassvalidate").hide();
        $(".formbutton").prop("disabled", false);
      }
    }
  
  });                       
</script>