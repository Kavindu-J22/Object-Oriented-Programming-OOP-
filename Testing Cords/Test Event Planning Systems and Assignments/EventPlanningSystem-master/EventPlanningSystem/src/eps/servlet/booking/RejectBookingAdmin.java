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
 * Servlet implementation class RejectBookingAdmin
 */
@WebServlet("/RejectBookingAdmin")
public class RejectBookingAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectBookingAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");		
		if(request.getSession(false).getAttribute("AdminId") == null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");		
		if(request.getSession(false).getAttribute("AdminId") == null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request,response);
		}
		
		if(request.getParameter("rejectAction") != null) {
			int BookingID = Integer.parseInt(request.getParameter("BookingID"));
			int userID = Integer.parseInt(request.getParameter("UserID"));
			String eventDate = request.getParameter("EventDate");
			int venueID = Integer.parseInt(request.getParameter("VenueID"));
			
			IBookingService IB = new BookingServiceImpl();
			IB.approveRejectBooking(BookingID, userID,eventDate,venueID,"Reject");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listBookingsAdminController");
			dispatcher.forward(request,response);
		}
	}

}
