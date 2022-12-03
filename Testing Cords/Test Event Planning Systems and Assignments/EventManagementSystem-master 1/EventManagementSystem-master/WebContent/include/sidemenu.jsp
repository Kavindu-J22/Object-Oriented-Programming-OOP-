<%@ page language="java" contentType="text/html" import="java.util.*" errorPage="error.jsp" %>
<aside class="sidebar big-sidebar left-sidebar">
    <ul>	
        <li>
            <h4>Menu</h4>
            <ul>
                
				<%
					if(session.getAttribute("session_userrole") != null) {
						String sessionrole = (String)session.getAttribute("session_userrole"); 
						if(!sessionrole.equalsIgnoreCase("client")) {
				
					
				%>
							<li><a href="addcustomisedevent.jsp">Add Customised Event</a></li>
							<li><a href="addpresetevent.jsp">Add Preset Event</a></li>
							<li><a href="index.jsp">View All Events</a></li>
				<%
						}
				%>
							<li><a href="presetevents.jsp">View Preset Events</a></li>
				<%
					} else {
				%>
						<li><a href="presetevents.jsp">View Preset Events</a></li>
				<%
					}
				%>
                
                
            </ul>
        </li>
                
        <li class="bg">
            <h4>About us</h4>
            <ul>
                <li class="text">
                   	<p style="margin: 0;">XPERT Events is a leading events management company. <a href="aboutus.jsp" class="readmore">Read More &raquo;</a></p>
                </li>
            </ul>
        </li>               
    </ul>
</aside>