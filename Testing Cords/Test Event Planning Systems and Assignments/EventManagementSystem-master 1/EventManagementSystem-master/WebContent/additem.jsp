<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<jsp:useBean id="allstaff" class="user.StaffUser" scope="request" />
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
<title>XPERT Events - Add Item</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
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
              String eventid = request.getParameter("event"); 
              String type = request.getParameter("type"); 
              
              if(eventid == "") {
                response.sendRedirect("error.jsp");
              }

              int ispreset = 0;
              if(type.equalsIgnoreCase("preset")) {
                ispreset = 1;
              } else if(type.equalsIgnoreCase("custom")) {
                ispreset = 0;
              } else {
                response.sendRedirect("error.jsp");
              }
              
            %>
        	    <h2>Add Item</h2>

                <div id="main-content" >
                  <fieldset>
                    <form action="${pageContext.request.contextPath}/ItemController" method="post">
                      
                      <input name="eventid" type="hidden" value="<%=eventid%>">
                      <input name="preset" type="hidden" value="<%=ispreset%>">

                      <table width="200" border="0">
                        <tr>
                          <td width="32%"><label>Item Name*</label>&nbsp;</td>
                          <td width="68%"><input name="itemname" type="text" id="itemname" maxlength="80" required autofocus></td>
                        </tr>
                        
                        <tr>
                          <td><label>Item Type*</label>&nbsp;</td>
                          <td><input name="itemtype" type="text" id="itemtype" maxlength="50" required></td>
                        </tr>
                        
                        <tr>
                          <td><label>Item Description*</label></td>
                          <td><textarea name="description" id="description" maxlength="200" required ></textarea></td>
                        </tr>
                        
                        <tr>
                          <td><label>Staff to Assign</label>&nbsp;</td>
                          <td>
                            <select id="stafflist" name="staffid">
                              <% 
                              	ArrayList<StaffUser> staff = allstaff.viewAllStaff();
                                if(!staff.isEmpty()) {
                                  for (StaffUser person : staff) {
                                    int userid = person.getUserid();
                                    String completename = person.getFirstName() + " " + person.getLastName();
                              %>
                                    <option value="<%=userid%>"> <%=completename%> </option>  
                              <% 
                                  }
                                }
                              %>
                            </select>
                          </td>
                        </tr>
                        
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
    </div> <!-- end of body -->

    <jsp:directive.include file="include/footer.html" />
</div>
</body>
</html>