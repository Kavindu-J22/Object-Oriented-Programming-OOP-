<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<jsp:useBean id="allclients" class="user.ClientUser" scope="request" />
<%@ page import="user.StaffUser" %>
<%
  String pagesessionrole = "";
  if(session.getAttribute("session_isloggedin") != null) {
    pagesessionrole = (String)session.getAttribute("session_userrole");  

    if(pagesessionrole.equalsIgnoreCase("client")) {
      response.sendRedirect("presetevents.jsp");
    } 
                  
  } else {
    response.sendRedirect("presetevents.jsp");
  }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XPERT Events - Add Customised Event</title>
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
        <h2>Add Customised Event</h2>

        <div id="main-content" >
          <fieldset>
            <form action="${pageContext.request.contextPath}/CustomController" method="post" id="addcustomisedevent">
              <table width="200" border="0">
                <tr>
                  <td width="32%"><label>Name*</label>&nbsp;</td>
                  <td width="68%"><input name="eventname" type="text" id="eventname" maxlength="80" required autofocus></td>
                </tr>
                
                <tr>
                  <td><label>Category*</label>&nbsp;</td>
                  <td>
                    <p>
                      <label><input type="radio" name="category" value="Corporate" id="category_0" checked = "checked"> Corporate</label>
                      <label><input type="radio" name="category" value="Social" id="category_1"> Social</label>
                      <label><input type="radio" name="category" value="Private" id="category_2"> Private</label>
                    </p>
                  </td>
                </tr>
                
                <tr>
                  <td><label>Start Date and Time*</label></td>
                  <td>
                    <input type="datetime-local" id="startdatetime" name="startdatetime" class="date" step="1" required/>
                    <span id="validationrules" class="startdateiscurrent" style="display:none">Event date cannot be current date.</span>
                  </td>
                </tr>
                
                <tr>
                  <td><label>End Date and Time*</label></td>
                  <td><input type="datetime-local" id="enddatetime" name="enddatetime" class="date" step="1" required /></td>
                </tr>
                
                <tr>
                  <td><label>Location*</label></td>
                  <td><input name="location" type="text" id="location" maxlength="100" required></td>
                </tr>
                
                <tr>
                  <td><label>Estimate Number Of Guests*</label></td>
                  <td><input type="number" name="estnumguests" id="estnumguests" required min="1"></td>
                </tr>
                    
                <tr>
                  <td><label>Cost*</label></td>
                  <td><input type="number" name="cost" id="cost" required min="0.01" step="0.01"></td>
                </tr>
                
                <tr>
                  <td><label>Description*</label></td>
                  <td><textarea name="description" id="description" maxlength="200" required ></textarea></td>
                </tr>

                <tr>
                  <td><label>Client Name</label>&nbsp;</td>
                  <td>
                    <select id="clientlist" name="clientid">
                      <option value="0" >---Select an option---</option>
                      <% 
                        ArrayList<StaffUser> clients = allclients.viewUsers();
                        if(!clients.isEmpty()) {
                          for (StaffUser client : clients) {
                            int userid = client.getUserid();
                            String completename = client.getFirstName() + " " + client.getLastName();
                      %>
                            <option value="<%=userid%>"> <%=completename%> </option>  
                      <% 
                          }
                        }
                      %>
                    </select> <a id="addnewclient">New?</a>
                  </td>
                </tr>
                
                <tbody class="newclient">
                  <tr>
                    <td><label>New Client Name </label>&nbsp;</td>
                    <td><input name="clientname" type="text" id="clientname" maxlength="80"></td>
                  </tr>

                  <tr>
                    <td><label>Contact Number</label></td>
                    <td><input type="text" name="contactnumber" id="contactnumber" pattern="^\s*\(?(020[7,8]{1}\)?[ ]?[1-9]{1}[0-9{2}[ ]?[0-9]{4})|(0[1-8]{1}[0-9]{3}\)?[ ]?[1-9]{1}[0-9]{2}[ ]?[0-9]{3})\s*$"></td>
                  </tr>

                  <tr>
                    <td><label>Email Address</label>&nbsp;</td>
                    <td><input name="emailaddress" type="email" id="emailaddress" maxlength="50"></td>
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
    </section> <!-- end of section -->
        
    	<div class="clear"></div>
    </div> <!-- end of body -->

   <jsp:directive.include file="include/footer.html" />
</div>
</body>
</html>

<script language="javascript" type="text/javascript">
  $(function () {    
        $("#addnewclient").click(function () {
            $(".newclient").slideToggle("fast");
        }); 

        $("#startdatetime").on("blur", function () {
          var startdate = new Date($("#startdatetime").val());

          if(startdate <= new Date()) {
            $(".startdateiscurrent").show();
            $(".formbutton").prop("disabled", true);
        
          } else {
            $(".startdateiscurrent").hide();
            $(".formbutton").prop("disabled", false);
          }
        });

        //Validate client data before submitting form
        $("input[type='submit']").click(function () {
          if ($("select[name='clientid']").val() == "") {
            $("#clientname").prop("required", true);
            $("#contactnumber").prop("required", true);
            $("#emailaddress").prop("required", true);
          } else {
            $("#addcustomisedevent").submit();
          }
        });
  
  });                       
</script>