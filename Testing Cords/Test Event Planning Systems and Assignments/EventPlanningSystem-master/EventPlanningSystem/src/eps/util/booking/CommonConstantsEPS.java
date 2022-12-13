/**
 * 
 */
package eps.util.booking;



/**
 * @author IT19240602
 *
 */
public class CommonConstantsEPS {
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";
	
	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "configEPS.properties";
	
	/** Constant for query tag in bookingQuery.xml */
	public static final String TAG_NAME = "query";
	
	/** Constant for query id in bookingQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";
	
	/**Constant for query id of create table Users**/
	public static final String QUERY_ID_Create_Table_Users = "create_table_users";
	
	/**Constant for query id of drop table Users**/
	public static final String QUERY_ID_Drop_Table_Users = "drop_table_users";
	
	/**Constant for query id of create table venue**/
	public static final String QUERY_ID_Create_Table_Venues = "create_table_venue";
	
	/**Constant for query id of drop table venue**/
	public static final String QUERY_ID_Drop_Table_Venues = "drop_table_venue";
	
	/**Constant for query id of create table venueBooking**/
	public static final String QUERY_ID_Create_Table_VenueBooking = "create_table_venueBooking";
	
	/**Constant for query id of drop table venueBooking**/
	public static final String QUERY_ID_Drop_Table_VenueBooking = "drop_table_venueBooking";
	
	/**Constant for query id of create table serviceProviders**/
	public static final String QUERY_ID_Create_Table_ServiceProviders = "create_table_serviceProvider";
	
	/**Constant for query id of drop table serviceProviders**/
	public static final String QUERY_ID_Drop_Table_ServiceProviders = "drop_table_serviceProvider";
	
	/**Constant for query id of create table Bookings**/
	public static final String QUERY_ID_Create_Table_Bookings = "create_table_Booking";
	
	/**Constant for query id of drop table Bookings**/
	public static final String QUERY_ID_Drop_Table_Bookings = "drop_table_Booking";
	
	/** Constant for query id of Check_availability in bookingQuery.xml */
	public static final String QUERY_ID_CHECK_availability = "check_availability";
	
	
	/**Constant for query id of getting service providers accoring to service*/
	public static final String QUERY_ID_Get_ServiceProviders = "get_service_provider";
	
	/**Constant for query id to get Venue Chharge*/
	public static final String QUERY_ID_Get_VenueDetails = "get_venue_details";
	
	/**Constant for query id to get service charges*/
	public static final String QUERY_ID_GET_serviceProviders = "get_service_providers";
	
	/**Constant for query id to get Details of users*/
	public static final String QUERY_ID_GET_userDetails = "get_users_details";
	
	/**Constant for query id to add a booking*/
	public static final String QUERY_ID_Add_Booking = "add_booking";
	
	/**Constant for fetch all the bookings in the system**/
	public static final String QUERY_ID_Get_All_Bookings = "get_all_bookings";
	
	/**Constant for query id to get all bookings of particular user*/
	public static final String QUERY_ID_Get_User_Bookings = "get_booking";
	
	/**Constant for query id to delete booking details*/
	public static final String QUERY_ID_Delete_User_Bookings = "delete_booking";
	
	/**Constant for query id to get specified booking details*/
	public static final String QUERY_ID_Get_Specified_Booking = "get_booking_specified";
	
	/**Constant for query id to update booked venues table */
	public static final String QUERY_ID_Update_Booked_Venues = "update_booked_venues";
	
	/**Constant for query id to update specified Booking */
	public static final String QUERY_ID_Update_Booking_Specified = "update_booking_specified";
	
	/**Constant for query id to change the booking status to Approved when admin approves Booking */
	public static final String QUERY_ID_Update_Booking_StatusToApproved = "approve_booking";
	
	/**Constant for query id to change the booking status to Rejected when admin rejects Booking */
	public static final String QUERY_ID_Update_Booking_StatusToRejected = "reject_booking";
	
	/**Constant for query id to deleted particular record from venueBooking table when 
	 * customer deleted a booking
	 */
	public static final String QUERY_ID_Delete_Venue_Booked = "delete_booked_venues";
	
}
