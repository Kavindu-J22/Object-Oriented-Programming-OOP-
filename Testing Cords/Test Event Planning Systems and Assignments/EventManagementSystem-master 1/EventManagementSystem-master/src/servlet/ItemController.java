package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.EventDetails;

/**
 * Servlet implementation class ItemController
 * This servlet is utilised for updating data (add, edit, delete) in eventdetail or item
 * @author blazing squad
 */
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This function is utilised for the delete event function.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EventDetails item = new EventDetails();
		item.setItemid(Integer.parseInt(request.getParameter("id")));
		
		item.setEventid(Integer.parseInt(request.getParameter("eventid")));
		item.setIspreset(Integer.parseInt(request.getParameter("preset")));
		
		String type;
		if(item.getIspreset() == 0) {
			type="custom";
		} else {
			type="preset";
		}
		
		try {
			item.deleteEventDetails(item.getItemid());
			response.sendRedirect("event.jsp?id=" + item.getEventid() + "&type=" +type);
			
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
		
		EventDetails item = new EventDetails();
		item.setItemName(request.getParameter("itemname")); 
		item.setItemType(request.getParameter("itemtype"));
		item.setItemDescription(request.getParameter("description"));
		item.setStaffAssigned(Integer.parseInt(request.getParameter("staffid")));
		item.setEventid(Integer.parseInt(request.getParameter("eventid")));
		item.setIspreset(Integer.parseInt(request.getParameter("preset")));
		
		String type;
		if(item.getIspreset() == 0) {
			type="custom";
		} else {
			type="preset";
		}
		
		try {
			if(action.equalsIgnoreCase("edit")) { //Call method to edit preset event.
				item.setItemid(Integer.parseInt(request.getParameter("itemid")));
				item.editEventDetails(item);
				response.sendRedirect("event.jsp?id=" + item.getEventid() + "&type=" +type);
			} else if(action.equalsIgnoreCase("add")) { //Call method to add preset event.
				item.addEventDetails(item);
				response.sendRedirect("event.jsp?id=" + item.getEventid() + "&type=" +type);
			} else { //Redirect if parameter is neither edit nor add.
				response.sendRedirect("error.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
	}

}
