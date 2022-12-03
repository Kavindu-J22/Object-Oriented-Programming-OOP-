<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<jsp:useBean id="presetevents" class="event.Event" scope="request" />
<%@ page import="event.Event" %>
<%@ page import="java.math.BigDecimal" %>
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
<title>XPERT Events - Edit Pre Set Event</title>
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
              String eventid = request.getParameter("id"); 
              Event event = null;

              event = presetevents.viewEvent(Integer.parseInt(eventid));
              
              if(event == null) {
                response.sendRedirect("error.jsp");
              }
              String eventname = event.getEventName();
              String category = event.getCategory();
              String location = event.getLocation();
              int guestnum = event.getEstGuestNumber();
              BigDecimal cost = event.getEventCost();
              String desc = event.getDescription();
              
            %>
              <h2>Edit Pre Set Event</h2>

                <div id="main-content" >
                  <fieldset>
                    <form action="${pageContext.request.contextPath}/PresetController" method="post">
                      
                      <input name="eventid" type="hidden" value="<%=eventid%>">

                      <table width="200" border="0">
                        <tr>
                          <td width="32%"><label>Name*</label>&nbsp;</td>
                          <td width="68%"><input name="eventname" type="text" id="eventname" maxlength="80" required autofocus value="<%=eventname%>"></td>
                        </tr>
                        
                        <tr>
                          <td><label>Category*</label>&nbsp;</td>
                          <td>
                            <p>
                              <label><input type="radio" name="category" value="Corporate" id="category_0"> Corporate</label>
                              <label><input type="radio" name="category" value="Social" id="category_1"> Social</label>
                              <label><input type="radio" name="category" value="Private" id="category_2"> Private</label>
                            </p>
                          </td>
                        </tr>
                        
                        <tr>
                          <td><label>Location*</label></td>
                          <td><input name="location" type="text" id="location" maxlength="100" required value="<%=location%>"></td>
                        </tr>
                        
                        <tr>
                          <td><label>Estimate Number Of Guests*</label></td>
                          <td><input type="number" name="estnumguests" id="estnumguests" required min="1" value="<%=guestnum%>"></td>
                        </tr>
                            
                        <tr>
                          <td><label>Cost*</label></td>
                          <td><input type="number" name="cost" id="cost" required min="0.01" step="0.01" value="<%=cost%>"></td>
                        </tr>
                        
                        <tr>
                          <td><label>Description*</label></td>
                          <td><textarea name="description" id="description" maxlength="200" required><%=desc%></textarea></td>
                        </tr>
                        
                        <tr>
                          <td><input type="submit" style="margin-left: 2px;" class="formbutton" id="login-button" value="Edit" name="action" />&nbsp;</td>
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

<script language="javascript" type="text/javascript">
  $(function () {

        //This part checks the event category to set the correct radio button.
        var eventcategory = '<%=category%>';
        if(eventcategory == "Corporate") {
          $("#category_0").prop("checked", true);
        } else if(eventcategory == "Social") {
          $("#category_1").prop("checked", true);
        } else { //Private category
          $("#category_2").prop("checked", true);
        }
        
    });                       
</script>