package eps.servlet.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eps.model.booking.Users;
import eps.service.booking.BookingServiceImpl;
import eps.service.booking.IBookingService;

/**
 * Servlet implementation class loggingController
 */
@WebServlet("/loggingController")
public class loggingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loggingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Get user name and password
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Call authenticateUser method to validate user credentails
		IBookingService ib = new BookingServiceImpl();
		Users userReturned = ib.authenticateUser(email, password);
	
		
		if(userReturned == null) {
			response.sendRedirect("views/login.jsp");
		}
		
		else {
			int userId = userReturned.getUserID();
			String userName = userReturned.getUserName();
			String userRole = userReturned.getUserRole();
			
			if(userRole.equals("admin")) {
				request.getSession(false).setAttribute("AdminId", userId);
				request.getSession(false).setAttribute("AdminName", userName);
				response.sendRedirect("views/adminHome.jsp");
			}
			
			if(userRole.equals("customer")) {
				//Store UserId in session attribue of UserId
				request.getSession(false).setAttribute("UserId", userId);
				request.getSession(false).setAttribute("username", userName);
				response.sendRedirect("views/userHome.jsp");
			}
		}
	}

}
