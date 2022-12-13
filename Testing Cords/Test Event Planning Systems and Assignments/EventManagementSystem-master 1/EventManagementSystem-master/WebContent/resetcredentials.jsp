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
<title>XPERT Events - Reset Credentials</title>
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
              
        %> 
        <h2>Reset User Credentials</h2>

        <div id="main-content" >
          <fieldset>
            <form action="${pageContext.request.contextPath}/UserController" method="post">
              
              <input name="userid" type="hidden" value="<%=userid%>">
              
              <table width="200" border="0">
                <tr>
                  <td width="32%"><label>Username</label>&nbsp;</td>
                  <td width="68%"><input name="username" type="text" id="username" maxlength="20" required autofocus value="<%=username%>"></td>
                </tr>
                
                <tr>
                  <td><label>Password*</label>&nbsp;</td>
                  <td>
                    <input name="password" type="password" id="password" maxlength="20" required pattern="(?=^.{8,20}$)^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$">
                    <span id="validationrules">
                      <p id="pvalidationrule">Uppercase and lowercase alphanumeric characters. 8-20 characters.</p>
                    </span>
                  </td>
                </tr>
          
                <tr>
                  <td><label>Confirm Password*</label>&nbsp;</td>
                  <td>
                    <input name="confpassword" type="password" id="confpassword" maxlength="20" required>
                    <span id="validationrules" class="confirmpassvalidate" style="display:none">Passwords don't match.</span>
                  </td>
                </tr>
                
                <tr>
                  <td><input type="submit" style="margin-left: 2px;" class="formbutton" id="login-button" value="Reset" name="action"/>&nbsp;</td>
                </tr>
          
              </table>
              <p>&nbsp;</p>
            </form>
          </fieldset>
        </div>
            
      </article>
    </section> <!-- end of section -->
        
    	<div class="clear"></div>
    </div> <!-- end of body -->

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