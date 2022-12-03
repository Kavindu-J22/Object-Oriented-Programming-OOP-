package eps.servlet.booking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eps.model.booking.Booking;
import eps.service.booking.BookingServiceImpl;
import eps.service.booking.IBookingService;

/**
 * Servlet implementation class listBookingsController
 */
@WebServlet("/listBookingsController")
public class listBookingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listBookingsController() {
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
		
		IBookingService Ib = new BookingServiceImpl();
		
		//fetch userID from the session attribute 
		int userID = (int) request.getSession(false).getAttribute("UserId");
		ArrayList<Booking> bookings = Ib.getUserBookings(userID);
		
		/**
		 * Store ArrayList of type Booking which contains all the bookings of particular customer
		 * in session attribute UserBookings
		 */
		request.getSession(false).setAttribute("UserBookings",bookings);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/listBookings.jsp");
		dispatcher.forward(request,response);
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
		
		doGet(request, response);
	}

}
