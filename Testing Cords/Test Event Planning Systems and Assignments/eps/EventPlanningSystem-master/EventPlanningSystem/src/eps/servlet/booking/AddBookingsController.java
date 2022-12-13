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
import eps.model.booking.ServiceProvider;
import eps.model.booking.Venue;
import eps.service.booking.BookingServiceImpl;
import eps.service.booking.IBookingService;

/**
 * This Servlet Will handle request and
 * responses untill user successfully add a booking
 */
@WebServlet("/AddBookingsController")
public class AddBookingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBookingService ib = new BookingServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookingsController() {
        super();
    }

	protected void checkAvailableVenues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//retrieve user inputs
		String eventName = request.getParameter("EventName");
		String eventType = request.getParameter("EventType");
		String eventDate = request.getParameter("EventDate");
		String startTime = request.getParameter("StartsAt");
		String endTime = request.getParameter("EndsAt");
		String participantCount = request.getParameter("NoOfParticipants");
		
		//Obtain venues available for user specified date
		ArrayList<Venue> venuesreturned = ib.getAvailableVenues(participantCount, eventDate);
		
		//Get Service Providers to display for user
		String foodsandbeverages = "FoodAndBeverages";
		String soundsandlighting = "SoundsAndLighting";
		String decorations = "Decorations";
		ArrayList<ServiceProvider> spFoods = ib.getServiceProviders(foodsandbeverages);
		ArrayList<ServiceProvider> spSounds = ib.getServiceProviders(soundsandlighting);
		ArrayList<ServiceProvider> spDecorations = ib.getServiceProviders(decorations);

		request.setAttribute("venueAvailable",venuesreturned);
		request.setAttribute("FoodSuppliers",spFoods);
		request.setAttribute("SoundSuppliers", spSounds);
		request.setAttribute("DecorationSupply", spDecorations);
		
		//Store user inputs in Booking object
		Booking bk1 = new Booking();
		bk1.setEventName(eventName);
		bk1.setEventType(eventType);
		bk1.setEventDate(eventDate);
		bk1.setStartingTime(startTime);
		bk1.setEndingTime(endTime);
		bk1.setNoOfParticipants(Integer.parseInt(participantCount));
		
		request.getSession().setAttribute("addBookingPart1",bk1);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/addBookingpart2.jsp");
		dispatcher.forward(request,response);
	}
	
	
	protected void calculateCostAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Booking bookingUpdated = new Booking();
		
		//Obtain User selections and store in Booking Object
		bookingUpdated.setVenueID(Integer.parseInt(request.getParameter("venueSelection")));
		bookingUpdated.setMealID(request.getParameter("MealSelection"));
		bookingUpdated.setSoundAndLightingID(request.getParameter("Sound&LightningSelection"));
		bookingUpdated.setDecorationID(request.getParameter("Decorations"));
		
		//Calculate Total Cost for the Booking
		double TotalCost = ib.calculateTotalCost(bookingUpdated);
		
		
		bookingUpdated.setTotalCost(TotalCost);
		request.setAttribute("TotalCost", TotalCost);
		
		//Store above Booking details in a session attribute
		request.getSession(false).setAttribute("addBookingPart2",bookingUpdated);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/addBookingpart3.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void addBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int userId = (int) request.getSession(false).getAttribute("UserId");
		Booking bookingUpdated1 = (Booking) request.getSession(false).getAttribute("addBookingPart1");
		Booking bookingUpdated2 = (Booking) request.getSession(false).getAttribute("addBookingPart2");
		bookingUpdated1.setUserID(userId);
		
		ib.addBooking(bookingUpdated1,bookingUpdated2);
		
		//Remove Session attributes after a booking is made
		request.getSession(false).removeAttribute("addBookingPart1");
		request.getSession(false).removeAttribute("addBookingPart2");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listBookingsController");
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
		
		//Obtain value of hidden input parameter to invoke method checkAvailableVenues 
		if(request.getParameter("checkActionVenue") != null) {
			checkAvailableVenues(request,response);
		}
		
		//Obtain value of hidden input parameter to invoke calculateCostAction method
		if(request.getParameter("CostCalculationAction") != null) {
			calculateCostAction(request,response);
		}
		
		//retrieve button value to invoke addBooking method
		if(request.getParameter("WantToConfirm") != null) {
			addBooking(request, response);
		}
		
		//retrieve button value to redirect to home page if user selected cancel
		if(request.getParameter("WantToCancel") != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/userHome.jsp");
			dispatcher.forward(request,response);
		}
	}

}
