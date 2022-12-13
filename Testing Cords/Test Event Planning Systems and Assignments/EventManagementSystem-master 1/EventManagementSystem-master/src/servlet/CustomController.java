package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.CustomisedEvent;
import event.Event;
import user.ClientUser;
import util.UtilDateParser;

/**
 * Servlet implementation class CustomController
 * This servlet is utilised for updating data (add, edit, delete)in custom event
 * @author blazing squad
 */
public class CustomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This function is utilised for the delete event function.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomisedEvent event = new CustomisedEvent();
		event.setEventid(Integer.parseInt(request.getParameter("id")));		
		try {
			event.deleteEvent(event.getEventid());
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action"); //To identify which actions to implement.
		
		CustomisedEvent event = new CustomisedEvent();
		event.setEventName(request.getParameter("eventname")); 
		event.setEventType("custom");
		event.setCategory(request.getParameter("category"));
		
		Date startdate = UtilDateParser.parseDateFromForm(request.getParameter("startdatetime"));
		Date enddate = UtilDateParser.parseDateFromForm(request.getParameter("enddatetime"));
		event.setStartDatetime(startdate);
		event.setEndDatetime(enddate);
		
		event.setLocation(request.getParameter("location"));
		event.setEstGuestNumber(Integer.parseInt(request.getParameter("estnumguests")));
		event.setDescription(request.getParameter("description"));
		
		BigDecimal cost = new BigDecimal(request.getParameter("cost"));
		event.setEventCost(cost);
		
		ClientUser client = new ClientUser();
		String clientid = request.getParameter("clientid");
		if(clientid.equalsIgnoreCase("0")) {
			String[] clientname = (request.getParameter("clientname")).split(" ");
        	client.setFirstName(clientname[0]);
        	client.setLastName(clientname[1]);
        	client.setEmailAddress(request.getParameter("emailaddress"));
        	client.setContactNum(request.getParameter("contactnumber"));
		} else {
        	try {
				client = client.getCustomEventClientData(Integer.parseInt(request.getParameter("clientid")));
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		}
		event.setClientSigned(client);
		
		try {
			if(action.equalsIgnoreCase("edit")) { //Call method to edit custom event.
				event.setEventid(Integer.parseInt(request.getParameter("eventid")));
				event.editEvent(event);
				response.sendRedirect("event.jsp?id=" + event.getEventid() + "&type=custom");
			} else if(action.equalsIgnoreCase("add")) { //Call method to add custom event.
				event.addEvent(event);
				response.sendRedirect("index.jsp");
			} else { //Redirect if parameter is neither edit nor add.
				response.sendRedirect("error.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
