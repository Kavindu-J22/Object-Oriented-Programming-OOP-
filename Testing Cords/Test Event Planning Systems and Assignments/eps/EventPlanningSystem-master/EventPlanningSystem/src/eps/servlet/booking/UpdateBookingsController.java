package eps.servlet.booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

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
 * Servlet implementation class UpdateBookingsController
 */
@WebServlet("/UpdateBookingsController")
public class UpdateBookingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBookingService ib = new BookingServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookingsController() {
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
	 * This method will send specified booking details fetched from database to the
	 * updateBooking1.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void redirectToupdateBooking1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int userID = (int) request.getSession(false).getAttribute("UserId");
		
		//Get booking ID of specific Booking which need to update
		int bookingID =Integer.parseInt(request.getParameter("BookingID"));
		
		//Store fetched booking details in Booking object
		Booking toUpdate = ib.getSpecifiedBooking(bookingID, userID);
		
	
		request.setAttribute("showBookingToUpdate",toUpdate);
		
		//This session attributes contains all the details of specified booking of a user
		request.getSession(false).setAttribute("BookingToUpdate", toUpdate);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/updateBooking1.jsp");
		dispatcher.forward(request,response);
	}
	
	/**
	 * This method will get updated booking details from updateBooking1.jsp page and
	 * get available venues for updated booking details and display avaialble venues and service 
	 * providers for customer to complete rest of the update booking function 
	 */
	public void redirectToCheckAvailableVenues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Get updated booking details
		String eventName = request.getParameter("EventName");
		String eventType = request.getParameter("EventType");
		String eventDate = request.getParameter("EventDate");
		String startTime = request.getParameter("StartsAt");
		String endTime = request.getParameter("EndsAt");
		String participantCount = request.getParameter("NoOfParticipants");
		int BookingID = Integer.parseInt(request.getParameter("BookingID")); 
		
		//Store updated booking details in a Booking object 
		Booking bookingToUpdate = new Booking();
		bookingToUpdate.setEventName(eventName);
		bookingToUpdate.setEventType(eventType);
		bookingToUpdate.setEventDate(eventDate);
		bookingToUpdate.setStartingTime(startTime);
		bookingToUpdate.setEndingTime(endTime);
		bookingToUpdate.setNoOfParticipants(Integer.parseInt(participantCount));
		bookingToUpdate.setBookingID(BookingID);
		
		/**
		 * Store above Booking object in session attribute of bookingToUpdateS1
		 * 
		 * bookingToUpdateS1 session attribute contains all the details of first part
		 * of specific updated booking which require to update the database
		 */
		
		request.getSession(false).setAttribute("bookingToUpdateS1", bookingToUpdate);
		
		//Fetch available veneus for updated booking details
		ArrayList<Venue> availableVenues = ib.getAvailableVenues(participantCount, eventDate);
		
		request.setAttribute("availableVenuesToDisplay", availableVenues );
		
		//Fetch service provider details to display
		String foodsandbeverages = "FoodAndBeverages";
		String soundsandlighting = "SoundsAndLighting";
		String decorations = "Decorations";
		ArrayList<ServiceProvider> spFoods = ib.getServiceProviders(foodsandbeverages);
		ArrayList<ServiceProvider> spSounds = ib.getServiceProviders(soundsandlighting);
		ArrayList<ServiceProvider> spDecorations = ib.getServiceProviders(decorations);
		
		request.setAttribute("FoodSuppliers",spFoods);
		request.setAttribute("SoundSuppliers", spSounds);
		request.setAttribute("DecorationSupply", spDecorations);
		
		//Direct customer to second step of update booking process
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/updateBooking2.jsp");
		dispatcher.forward(request,response);
		
		Booking bokingToTest = (Booking)request.getSession(false).getAttribute("bookingToUpdateS1");
		System.out.println("Booking id test " + bokingToTest.getBookingID());
		
	}
	
	/**
	 * This method will obtain user updated booking details such as selected venue,selected service
	 * providers for calculation of cost for Updated Booking. Then updated cost will be displayed
	 * to the customer for confirmation to further proceed the Update process
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void redirectToCalculateCost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//get updated selections
		String venueSelection = request.getParameter("venueSelection");
		String mealSelection = request.getParameter("MealSelection");
		String soundSelection = request.getParameter("Sound&LightningSelection");
		String decorations = request.getParameter("Decorations");
		
		Booking bookingToUpdate = new Booking();
		
		/**
		 * New selections will be stored in bookingToUpdate reference only if customer
		 * had chosen new selections
		 */
		if(Integer.parseInt(request.getParameter("venueSelection")) !=  0) {
			bookingToUpdate.setVenueID(Integer.parseInt(request.getParameter("venueSelection")));
		}
		
		if(Integer.parseInt(request.getParameter("MealSelection")) !=  0) {
			bookingToUpdate.setMealID(request.getParameter("MealSelection"));
		}
		
		if(Integer.parseInt(request.getParameter("Sound&LightningSelection")) !=  0) {
			bookingToUpdate.setSoundAndLightingID((request.getParameter("Sound&LightningSelection")));
		}
		
		if(Integer.parseInt(request.getParameter("Decorations")) !=  0) {
			bookingToUpdate.setDecorationID(request.getParameter("Decorations"));
		}
		
		//Obtain Total cost for updated booking
		double totalCostAfterUpdate = ib.calculateTotalCostUpdate(bookingToUpdate, (Booking)request.getSession(false).getAttribute("BookingToUpdate"));
		bookingToUpdate.setTotalCost(totalCostAfterUpdate);
		
		int UserID = (int) request.getSession(false).getAttribute("UserId");
		
		bookingToUpdate.setUserID(UserID);
		request.setAttribute("Totalcost", totalCostAfterUpdate);
		
		/**
		 * bookingToUpdateS2 session attribute contains all the details of second part
		 * of specific updated booking which requires to update the database
		 */
		request.getSession(false).setAttribute("bookingToUpdateS2",bookingToUpdate);
		
		/**
		 * direct customer to updateBooking3.jsp page which will display the updated total cost 
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/updateBooking3.jsp");
		dispatcher.forward(request,response);
		
	}
	
	/**
	 * This method will update the database when after customer confirmed the Total cost for the updated Booking
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateFinalUpdatedBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Booking bookingToBeUpdated1 = (Booking)request.getSession(false).getAttribute("bookingToUpdateS1");
		Booking bookingToBeUpdated2 = (Booking)request.getSession(false).getAttribute("bookingToUpdateS2");
		
		//Invoke updateSpecifiedBooking which will update the database with final updated booking details
		ib.updateSpecifiedBooking(bookingToBeUpdated1, bookingToBeUpdated2);
		
		//direct customer to booking list
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
		
		//Obtain value of hidden input parameter to invoke method redirectToupdateBooking1
		if(request.getParameter("redirectAction") != null) {
			redirectToupdateBooking1(request,response);
		}
		
		//Obtain value of hidden input parameter to invoke method redirectToCheckAvailableVenues
		if(request.getParameter("checkVenueAction") != null) {
			redirectToCheckAvailableVenues(request,response);
		}
		
		//Obtain value of hidden input parameter to incoke method redirectToCalculateCost
		if(request.getParameter("CalculateCost") != null) {
			redirectToCalculateCost(request,response);
		}
		
		//Obtain value of hidden input parameter to incoke method updateFinalUpdatedBooking
		if(request.getParameter("WantToConfirm") != null) {
			updateFinalUpdatedBooking(request,response);
		}
		
		//If user cancel redirect to booking list
		if(request.getParameter("WantToCancel") != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listBookingsController");
			dispatcher.forward(request,response);
		}
	}

}
