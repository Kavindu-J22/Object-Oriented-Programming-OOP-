package eps.servlet.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eps.service.booking.BookingServiceImpl;
import eps.service.booking.IBookingService;

/**
 * Servlet implementation class DeleteBookingsController
 */
@WebServlet("/DeleteBookingsController")
public class DeleteBookingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookingsController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");		
		if(request.getSession(false).getAttribute("UserId") == null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");		
		if(request.getSession(false).getAttribute("UserId") == null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request,response);
		}
		
		//get userId from session attribute
		int userID = (int) request.getSession(false).getAttribute("UserId");
		//get booking id of the booking which need to delete
		int bookingID = Integer.parseInt(request.getParameter("BookingID"));
		
		String eventDate = request.getParameter("EventDate");
		int venueID = Integer.parseInt(request.getParameter("VenueID"));
		
		//invoke delete method
		IBookingService ib = new BookingServiceImpl();
		ib.deleteUserBooking(bookingID, userID,eventDate,venueID);
		
		//Redirect to list bookings
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listBookingsController");
		dispatcher.forward(request,response);
		
	}

}
