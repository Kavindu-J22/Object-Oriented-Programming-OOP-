package eps.service.booking;

import java.util.ArrayList;
import java.util.logging.Logger;
import eps.model.booking.Booking;
import eps.model.booking.ServiceProvider;
import eps.model.booking.Users;
import eps.model.booking.Venue;


public interface IBookingService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IBookingService.class.getName());
	
	public ArrayList<Venue> getAvailableVenues(String capacity, String date);
	
	public ArrayList<ServiceProvider> getServiceProviders(String service);
	
	public double calculateTotalCost(Booking bookingObject);
	
	public double calculateTotalCostUpdate(Booking booking, Booking beforeUpdate);
	
	public Users authenticateUser(String userEmail, String userPassword);
	
	public void addBooking (Booking addBookingPart1, Booking addBookingPart2);
	
	public ArrayList<Booking> getUserBookings (int userId);
	
	public void deleteUserBooking (int bookingID, int userID, String EventDate, int venueID);
	
	public Booking getSpecifiedBooking (int bookingID, int userID);
	
	public void updateSpecifiedBooking (Booking bk1,Booking bk2);
	
	public ArrayList<Booking> getAllBookings();
	
	public void approveRejectBooking(int bookingID, int userID,String eventDate,int veneuID,String action);
	
}
