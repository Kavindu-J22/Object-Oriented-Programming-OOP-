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
 * Servlet implementation class listBookingsAdminController
 */
@WebServlet("/listBookingsAdminController")
public class listBookingsAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listBookingsAdminController() {
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
		
		//Call method which return Arraylist Which contains All the bookings in the system
		IBookingService ib = new BookingServiceImpl();
		ArrayList<Booking> allBookings = ib.getAllBookings();
		
		request.setAttribute("allBookingsForAdmin", allBookings);
		
		request.getSession(false).setAttribute("AllBookingsArray",allBookings);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/allBookingsForAdmin.jsp");
		dispatcher.forward(request,response);
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
		
		doGet(request, response);
	}

}
