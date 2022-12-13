<!doctype html>
<html>
<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<jsp:useBean id="presetevents" class="event.Event" scope="request" />
<%@ page import="event.Event" %>
<%
  String pagesessionrole = "";
  if(session.getAttribute("session_isloggedin") != null) {
    pagesessionrole = (String)session.getAttribute("session_userrole");  

    if(!pagesessionrole.equalsIgnoreCase("client")) {
      response.sendRedirect("index.jsp");
    } 
                  
  } else {
    response.sendRedirect("presetevents.jsp");
  }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XPERT Events</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">

    <jsp:directive.include file="/include/header.jsp" />

    <div id="body" class="width">
	
       <jsp:directive.include file="/include/sidemenu.jsp" />

	   <section id="content" class="two-column">

    	   <article>
    				
                <h2>Welcome</h2>
                
                <div id="main-content" >

                    <fieldset>
                        <legend>MY EVENTS</legend>
                    </fieldset>

                    <table id = "tablecontainer">
                        <thead>
                          <tr>
                            <th>Event Name</th>
                            <th>Date</th>
                            <th></th>
                          </tr> 
                        </thead>

                        <tbody>
                            <% 
                                ArrayList<Event> events = presetevents.viewAllEvents();
                                if(!events.isEmpty()) {
                                    for (Event event : events) {
                                        int eventid = event.getEventid();
                                        String eventname = event.getEventName();
                                        String eventdate = event.getEventName();
                                        String url = "event.jsp?id=" + eventid + "&type=preset";
                            %>
                                    <tr> 
                                        <td width="50%"><a href=<%=url%>> <%=eventname%> </a></td>
                                        <td width="30%"><%=eventdate%></td>
                                        <td width="20%">
                                            <button type="button" style="margin-left: 2px;" class="formbutton" id="sendinvitation">Send Guest Invitations</button>
                                        </td>
                                    </tr>
                            <%
                                    } 
                                } else {
                            %>
                                    <tr> 
                                      <td colspan="3">No Events to Display</td>
                                    </tr>
                            <%
                                }
                            %>
                        </tbody>    
                    </table> <!--end of table-->
                </div> <!--end of main-content-->
                
        	</article>
        </section>
        
    	<div class="clear"></div>
    </div> <!--end of body -->
    
    <jsp:directive.include file="/include/footer.html" />
</div>
</body>
</html>