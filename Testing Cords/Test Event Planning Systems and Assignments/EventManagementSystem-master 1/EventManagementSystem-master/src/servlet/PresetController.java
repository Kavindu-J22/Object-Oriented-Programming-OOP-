package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.Event;

/**
 * Servlet implementation class PresetController
 * This servlet is utilised for updating data (add, edit, delete)in preset event
 * @author blazing squad
 */
public class PresetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This function is utilised for the delete event function.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Event event = new Event();
		event.setEventid(Integer.parseInt(request.getParameter("id")));		
		try {
			event.deleteEvent(event.getEventid());
			response.sendRedirect("presetevents.jsp");
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
		
		Event event = new Event();
		event.setEventName(request.getParameter("eventname")); 
		event.setCategory(request.getParameter("category"));
		event.setLocation(request.getParameter("location"));
		event.setEstGuestNumber(Integer.parseInt(request.getParameter("estnumguests")));
		event.setDescription(request.getParameter("description"));
		
		BigDecimal cost = new BigDecimal(request.getParameter("cost"));
		event.setEventCost(cost);
		
		try {
			if(action.equalsIgnoreCase("edit")) { //Call method to edit preset event.
				event.setEventid(Integer.parseInt(request.getParameter("eventid")));
				event.editEvent(event);
				response.sendRedirect("event.jsp?id=" + event.getEventid() + "&type=preset");
			} else if(action.equalsIgnoreCase("add")) { //Call method to add preset event.
				event.addEvent(event);
				response.sendRedirect("presetevents.jsp");
			} else { //Redirect if parameter is neither edit nor add.
				response.sendRedirect("error.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
	}

}
