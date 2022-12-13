package eps.service.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import eps.model.booking.Booking;
import eps.model.booking.ServiceProvider;
import eps.model.booking.Users;
import eps.model.booking.Venue;
import eps.util.booking.CommonConstantsEPS;
import eps.util.booking.DBConnectionTUtilEPS;
import eps.util.booking.QueryUtilEPS;


public class BookingServiceImpl implements IBookingService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(BookingServiceImpl.class.getName());
	

	private static Connection connection;
	
	private PreparedStatement preparedStatement;
	
	static {
		System.out.println("Static block representation");
	}
	
	/**
	 *This method will return list of available venues that user can book
	 *by checking the date of event and number of participants for the event
	 *
	 * @param capacity - No of participants of event
	 * @param date - Date of event
	 * 
	 * @return ArrayList<Venue> - List of venues Available to book
	 * 
	 */
	@Override
	public ArrayList<Venue> getAvailableVenues(String capacity, String date) {
		ArrayList<Venue> venues = new ArrayList<Venue>();
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrieve query to check available venues from bookingQuery.xml
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_CHECK_availability));
			//set capacity and date to query 
			preparedStatement.setString(1, capacity);
			preparedStatement.setString(2, date);
			ResultSet resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				Venue venue = new Venue();
				//get venue id and name of venues available
				venue.setVenueID(Integer.parseInt(resultset.getString("venueID")));
				venue.setName(resultset.getString("venueName"));
				//add venue object to venues array
				venues.add(venue);
			}
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return venues;
	}
	
	/**
	 * This method will return list of service providers 
	 * according to the input service type
	 * 
	 * @param service - service type which is provided by service Provider
	 * @return ArrayList<ServiceProvider> - Array List of service providers obtained from database 
	 */
	@Override
	public ArrayList<ServiceProvider> getServiceProviders(String service) {
		ArrayList<ServiceProvider> sp = new ArrayList<>();
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrive Query to get service providers according to the service the provide from bookingQuery.xml
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_ServiceProviders));
			//set service type
			preparedStatement.setString(1, service);
			ResultSet resultset = preparedStatement.executeQuery();
			ServiceProvider serviceprovider = null;
			while(resultset.next()) {
			    serviceprovider = new ServiceProvider();
				//retrieve service provider details and set it to service provider object
			    serviceprovider.setServiceID(resultset.getInt("serviceProviderID"));
				serviceprovider.setServiceProviderName(resultset.getString("serviceProviderName"));
				serviceprovider.setCost(resultset.getDouble("serviceCharge"));
				//add service provider object to ArrayList of Type Service Provider
				sp.add(serviceprovider);
			}
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		//return ArrayList
		return sp;
	}
	
	/**
	 * This method will calculate cost for the given booking
	 * 
	 * @param bookingObject - Booking Object which contains of user booking details
	 * @return TotalCost - Total Cost for the given Booking 
	 */
	@Override
	public double calculateTotalCost (Booking bookingObject) {
		double venueCost = 0;
		double mealCost = 0;
		double soundCost = 0;
		double decorationCost = 0;
		double TotalCost = 0;
		
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrieve query to get venue details from bookingQuery.xml 
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_VenueDetails));
			//set user selected venue ID to get cost for that venue
			preparedStatement.setLong(1, bookingObject.getVenueID());
			ResultSet venueResultset = preparedStatement.executeQuery();
			while(venueResultset.next()) {
				//Retrive cost for user selected venue
				venueCost = venueResultset.getDouble("chargeForEvent");
				TotalCost += venueCost;
			}
			
			//Check whether the user selects a meal provider before retrive meal provider details
			if(bookingObject.getMealID() != null) {
				//Retrive Query to get service provider details when service provider ID is given 
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				//set service provider ID to obtain details of service provider
				preparedStatement.setString(1, bookingObject.getMealID());
				ResultSet mealResultSet = preparedStatement.executeQuery();
				while(mealResultSet.next()) {
					//retrive service charges 
					mealCost = mealResultSet.getDouble("serviceCharge");
					TotalCost += mealCost;
				}
			}
			
			//Check whether the user selectes a Sound and Lighting Provider before retriving sound and lighting Provider deatils 
			if(bookingObject.getSoundAndLightingID() != null) {
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, bookingObject.getSoundAndLightingID());
				ResultSet soundResultSet = preparedStatement.executeQuery();
				while(soundResultSet.next()) {
					soundCost = soundResultSet.getDouble("serviceCharge");
					TotalCost += soundCost;
				}
			}
			
			if(bookingObject.getDecorationID() != null) {
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, bookingObject.getDecorationID());
				ResultSet decorationResultSet = preparedStatement.executeQuery();
				while(decorationResultSet.next()) {
					decorationCost = decorationResultSet.getDouble("serviceCharge");
					TotalCost += decorationCost;
				}
			}
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return TotalCost;
		
	}

	@Override
	public Users authenticateUser(String userEmail, String userPassword) {
		Users users = null;
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_userDetails));
			ResultSet resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
			    if((resultset.getString("userEmail").equals(userEmail)) && (resultset.getString("userPassword").equals(userPassword))) {
			    	users = new Users();
			    	users.setUserEmail(resultset.getString("userEmail"));
			    	users.setUserID(resultset.getInt("userID"));
			    	users.setUserRole(resultset.getString("userRole"));
			    	users.setUserName(resultset.getString("userName"));
			    }
			}
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return users;
	}

	@Override
	public void addBooking(Booking addBookingPart1, Booking addBookingPart2) {
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Add_Booking));
			preparedStatement.setString(1, addBookingPart1.getEventName());
			preparedStatement.setString(2, addBookingPart1.getEventType());
			preparedStatement.setString(3, addBookingPart1.getEventDate());
			preparedStatement.setString(4, addBookingPart1.getStartingTime());
			preparedStatement.setString(5, addBookingPart1.getEndingTime());
			preparedStatement.setInt(6, addBookingPart2.getVenueID());
			preparedStatement.setString(7,addBookingPart2.getMealID());
			preparedStatement.setString(8,addBookingPart2.getDecorationID());
			preparedStatement.setString(9, addBookingPart2.getSoundAndLightingID());
			preparedStatement.setDouble(10, addBookingPart2.getTotalCost());
			preparedStatement.setDouble(11, addBookingPart1.getUserID());
			preparedStatement.setDouble(12, addBookingPart1.getNoOfParticipants());
			preparedStatement.setString(13,"pending");
			preparedStatement.executeUpdate();
			
			
			
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}
	
	/**
	 * This method will arraylist which contains details of all the bookings
	 * of particular Customer
	 * 
	 * @param userId - user ID of customer
	 * @return ArrayList<Booking> - ArrayList Of type Booking which contains Booking objects
	 */
	@Override
	public ArrayList<Booking> getUserBookings(int userId) {
		ResultSet resultset = null;
		ArrayList<Booking> bookingArray = new ArrayList<Booking>();
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrieve query from bookingQuery.xml to obtain booking details when user ID is given
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_User_Bookings));
			//set user id 
			preparedStatement.setInt(1, userId);
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				Booking bk = new Booking();
				//set booking details of each booking to Booking object
				bk.setBookingID(resultset.getInt("BookingID"));
				bk.setEventName(resultset.getString("EventName"));
				bk.setEventType(resultset.getString("EventType"));
				bk.setEventDate(resultset.getString("EventDate"));
				
				String startTime = resultset.getString("StartingTime");
				String[] startTimeArr = startTime.split(":");
				String startHours = (Integer.parseInt(startTimeArr[0]) >= 10) ? startTimeArr[0] : ("0" + startTimeArr[0]);
				String startMins = (Integer.parseInt(startTimeArr[1]) >= 10) ? startTimeArr[1] : ("0" + startTimeArr[1]);
				String stratTimeEdited = startHours + ":" + startMins;
				bk.setStartingTime(stratTimeEdited); 
				
				String endTime = resultset.getString("EndingTime");
				String[] endTimeArr = endTime.split(":");
				String endHours = (Integer.parseInt(endTimeArr[0]) >= 10) ? endTimeArr[0] : ("0" + endTimeArr[0]);
				String endMins = (Integer.parseInt(endTimeArr[1]) >= 10) ? endTimeArr[1] : ("0" + endTimeArr[1]);
				String endingTimeEdited = endHours + ":" + endMins;
				bk.setEndingTime(endingTimeEdited);
				
				String venueID = resultset.getString("VenueID");
				//Retrive Query which return venue details when venue ID is given
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_VenueDetails));
				//Set venue ID
				preparedStatement.setString(1, venueID);
				ResultSet venueresultset = preparedStatement.executeQuery();
				while(venueresultset.next()) {
					//Set venue ID and Venue Name in Booking Object
					bk.setVenueName(venueresultset.getString("venueName"));
					bk.setVenueID(resultset.getInt("venueID"));
				}

				String mealID = resultset.getString("MealProviderID");
				if(mealID != null) {
					//Retrieve Query which return service Provider details when service Provider id is given
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					//set meal provider ID
					preparedStatement.setString(1, mealID);
					ResultSet mealresultset = preparedStatement.executeQuery();
					while(mealresultset.next()) {
						//Set mealProvider ID and meal provider name in Booking object
						bk.setMeals(mealresultset.getString("serviceProviderName"));
						bk.setMealID(mealresultset.getString("serviceProviderID"));
					}
				}

				String decorationID = resultset.getString("DecorationProviderID");
				if(decorationID  != null) {
					//Retrieve Query which return service Provider details when service provider id is given
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					//Set decoration provider ID to obtain decoration provider details
					preparedStatement.setString(1, decorationID );
					ResultSet decorationresultset = preparedStatement.executeQuery();
					while(decorationresultset.next()) {
						//Set details of decoration provider into Booking object
						bk.setDecoration(decorationresultset.getString("serviceProviderName"));
						bk.setDecorationID(decorationresultset.getString("serviceProviderID"));
					}
				}

				String soundAndLightingID = resultset.getString("SoundAndLightingProviderID");
				if(soundAndLightingID != null) {
					//Retrieve Query which return service Provider details when service provider id is given
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					//Set Sound and lighting provider ID to obtain Sound and lighting provider details
					preparedStatement.setString(1, soundAndLightingID);
					ResultSet soundLightresultset = preparedStatement.executeQuery();
					while(soundLightresultset.next()) {
						//Set details of sound and lighting provider into Booking object
						bk.setSoundLighting(soundLightresultset.getString("serviceProviderName"));
						bk.setSoundAndLightingID(soundLightresultset.getString("serviceProviderID"));
					}
				}

				bk.setTotalCost(resultset.getDouble("TotalCost"));
				bk.setNoOfParticipants(resultset.getInt("NoOfParticipants"));
				bk.setBookingStatus(resultset.getString("BookingStatus"));
				//Add Booking object to bookingArray
				bookingArray.add(bk);
			}
			
			
		
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return bookingArray;
		 
	}

	/**
	 * This method will delete a particular Booking of a customer
	 * @param bookingID - ID of the Booking which is need to delete
	 * @param userID - userID of customer
	 */
	@Override
	public void deleteUserBooking(int bookingID, int userID, String EventDate, int venueID) {
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrieve Query to delete specific Booking of a customer
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Delete_User_Bookings));
			//Set user ID and Booking ID
			preparedStatement.setInt(1, bookingID);
			preparedStatement.setInt(2, userID);
			preparedStatement.executeUpdate();
			
			//Delete particular row from venueBooking when customer deleted the booking 
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Delete_Venue_Booked));
			preparedStatement.setInt(1, venueID);
			preparedStatement.setString(2, EventDate);
			preparedStatement.executeUpdate();
			
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
	}
	}

	/**
	 * This method will return Booking object which contains 
	 * details of specific Booking belonged to customer
	 * 
	 * @param bookingID - Booking ID of Booking which needs to retrive details of
	 * @param userID - UserID of the customer
	 * @return Booking - Booking object which contains details of specific booking
	 * belonged to customer
	 */
	@Override
	public Booking getSpecifiedBooking(int bookingID, int userID) {
		ResultSet resultset = null;
		Booking bookingToUpdate = null;
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrieve Query which will return details of specific booking when User ID and Booking ID is given
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_Specified_Booking));
			//Set booking ID and User ID
			preparedStatement.setInt(1, bookingID);
			preparedStatement.setInt(2, userID);
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				//Set retrieved booking details to Booking Object
			    bookingToUpdate = new Booking(); 
				bookingToUpdate.setBookingID(resultset.getInt("BookingID"));
				bookingToUpdate.setEventName(resultset.getString("EventName"));
				bookingToUpdate.setEventType(resultset.getString("EventType"));
				bookingToUpdate.setEventDate(resultset.getString("EventDate"));
				
				String startTime = resultset.getString("StartingTime");
				String[] startTimeArr = startTime.split(":");
				String startHours = (Integer.parseInt(startTimeArr[0]) >= 10) ? startTimeArr[0] : ("0" + startTimeArr[0]);
				String startMins = (Integer.parseInt(startTimeArr[1]) >= 10) ? startTimeArr[1] : ("0" + startTimeArr[1]);
				bookingToUpdate.setStartingTime(startHours+":"+startMins);
				
				String endTime = resultset.getString("EndingTime");
				String[] endTimeArr = endTime.split(":");
				String endHours = (Integer.parseInt(endTimeArr[0]) >= 10) ? endTimeArr[0] : ("0" + endTimeArr[0]);
				String endMins = (Integer.parseInt(endTimeArr[1]) >= 10) ? endTimeArr[1] : ("0" + endTimeArr[1]);
				bookingToUpdate.setEndingTime(endHours+":"+endMins);
				
				String venueID = resultset.getString("VenueID");
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_VenueDetails));
				preparedStatement.setString(1, venueID);
				ResultSet venueresultset = preparedStatement.executeQuery();
				while(venueresultset.next()) {
					bookingToUpdate.setVenueName(venueresultset.getString("venueName"));
					bookingToUpdate.setVenueID(resultset.getInt("venueID"));
				}
				
				String mealID = resultset.getString("MealProviderID");
				if(mealID != null) {
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					preparedStatement.setString(1, mealID);
					ResultSet mealresultset = preparedStatement.executeQuery();
					while(mealresultset.next()) {
						bookingToUpdate.setMeals(mealresultset.getString("serviceProviderName"));
						bookingToUpdate.setMealID(mealresultset.getString("serviceProviderID"));
					}
				}
				
				String decorationID = resultset.getString("DecorationProviderID");
				if(decorationID  != null) {
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					preparedStatement.setString(1, decorationID );
					ResultSet decorationresultset = preparedStatement.executeQuery();
					while(decorationresultset.next()) {
						bookingToUpdate.setDecoration(decorationresultset.getString("serviceProviderName"));
						bookingToUpdate.setDecorationID(decorationresultset.getString("serviceProviderID"));
					}
				}
				
				String soundAndLightingID = resultset.getString("SoundAndLightingProviderID");
				if(soundAndLightingID != null) {
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					preparedStatement.setString(1, soundAndLightingID);
					ResultSet soundLightresultset = preparedStatement.executeQuery();
					while(soundLightresultset.next()) {
						bookingToUpdate.setSoundLighting(soundLightresultset.getString("serviceProviderName"));
						bookingToUpdate.setSoundAndLightingID(soundLightresultset.getString("serviceProviderID"));
					}
				}
				
				bookingToUpdate.setTotalCost(resultset.getDouble("TotalCost"));
				bookingToUpdate.setNoOfParticipants(resultset.getInt("NoOfParticipants"));
			}
			
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return bookingToUpdate;
	}
	
	/**
	 * This method will calculate Total cost for the Booking When after 
	 * Customer Edit/update Booking
	 * @param bookingAfterUpdate - Booking object which contains Updated Booking details
	 * @param bookingbeforeUpdate - Booking object which contains details of Booking before Update 
	 * @return totalCostAfterUpdate - Total cost calculated for updated Booking
	 */
	@Override
	public double calculateTotalCostUpdate(Booking bookingAfterUpdate, Booking beforeUpdate ) {
		//Initialized variables to store charges before updating the Booking
		double venueCostBeforeUpdate = 0;
		double mealCostBeforeUpdate = 0;
		double soundCostBeforeUpdate = 0;
		double decorationCostBeforeUpdate = 0;
		
		//Initialized variables to store charges after updating the Booking
		double venueCostAfterUpdate = 0;
		double mealCostAfterUpdate = 0;
		double soundCostAfterUpdate = 0;
		double decorationCostAfterUpdate = 0;
		double totalCostBeforeUpdate = beforeUpdate.getTotalCost();
		double totalCostAfterUpdate = 0;
		
		ResultSet resultSet = null;
		
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//TotalCost will be changed only when customer make changes
			//Checking whether the customer selected a different venue than previous
			if(bookingAfterUpdate.getVenueID() != 0) {
				//Obtain cost for previously selected Venue
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_VenueDetails));
				preparedStatement.setInt(1, beforeUpdate.getVenueID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					venueCostBeforeUpdate = resultSet.getDouble("chargeForEvent");
				}
				
				//Obtain cost for newly selected Venue
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_VenueDetails));
				preparedStatement.setInt(1, bookingAfterUpdate.getVenueID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					venueCostAfterUpdate = resultSet.getDouble("chargeForEvent");
				}
			}
			
			//Checking whether the customer selected a different meal provider than previous
			if(bookingAfterUpdate.getMealID() != null) {
				//Obtain charges for previously selected meal provider
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, beforeUpdate.getMealID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					mealCostBeforeUpdate = resultSet.getDouble("serviceCharge");
				}
				
				//Obtain charges for newly selected meal provider
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, bookingAfterUpdate.getMealID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					mealCostAfterUpdate = resultSet.getDouble("serviceCharge");
				}
			}
			
			//Checking whether the customer selected a different sound and lighting provider
			if(bookingAfterUpdate.getSoundAndLightingID() !=  null) {
				//Obtain charges for previously selected sound and lighting provider 
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, beforeUpdate.getSoundAndLightingID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					soundCostBeforeUpdate = resultSet.getDouble("serviceCharge");
				}
				
				//Obtain charges for newly selected sound and lighting provider
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, bookingAfterUpdate.getSoundAndLightingID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					soundCostAfterUpdate = resultSet.getDouble("serviceCharge");
				}
			}
			
			//Checking whether the user has selected a new Decoration provider
			if(bookingAfterUpdate.getDecorationID() != null) {
				//retrieve charges for previously selected decoration provider
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, beforeUpdate.getDecorationID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					decorationCostBeforeUpdate = resultSet.getDouble("serviceCharge");
				}
				
				//retrieve charges for newly selected decoration provider
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
				preparedStatement.setString(1, bookingAfterUpdate.getDecorationID());
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					decorationCostAfterUpdate = resultSet.getDouble("serviceCharge");
				}
			}
			
			//add total service charges of previously selected options
			double serviceChargesBeforeUpdate = venueCostBeforeUpdate + mealCostBeforeUpdate + soundCostBeforeUpdate + decorationCostBeforeUpdate;
			//add total service charges of newly selected options
			double serviceChargesAfterUpdate = venueCostAfterUpdate + mealCostAfterUpdate + soundCostAfterUpdate + decorationCostAfterUpdate; 
			
			System.out.println("Service charges before update -" + serviceChargesBeforeUpdate);
			System.out.println("Service charges after update -" + serviceChargesAfterUpdate);
			
			/**
			 * Deduct service charges of previous selected options from Total cost
			 * of current Booking and add total service charges of newly selected
			 * options. 
			 */
		
			totalCostAfterUpdate  = totalCostBeforeUpdate - serviceChargesBeforeUpdate;
			totalCostAfterUpdate += serviceChargesAfterUpdate;
			
			
		}catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return totalCostAfterUpdate;
		
	}

	/**
	 * This method will update the specific booking of customer with
	 * updated booking details in database
	 * 
	 * @param bk1 - Boooking object which contains part of updated Booking details(first part)
	 * @param bk2 - Booking object which contains other part of updated Booking details (second part)
	 */
	@Override
	public void updateSpecifiedBooking(Booking bk1, Booking bk2) {
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrieve Query to update specific Booking of a particular customer
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Update_Booking_Specified));
			//Set updated booking details
			preparedStatement.setString(1, bk1.getEventName());
			preparedStatement.setString(2, bk1.getEventType());
			preparedStatement.setString(3, bk1.getEventDate());
			preparedStatement.setString(4, bk1.getStartingTime());
			preparedStatement.setString(5, bk1.getEndingTime());
			preparedStatement.setInt(6, bk2.getVenueID());
			preparedStatement.setString(7, bk2.getMealID());
			preparedStatement.setString(8, bk2.getDecorationID());
			preparedStatement.setString(9, bk2.getSoundAndLightingID());
			preparedStatement.setDouble(10, bk2.getTotalCost());
			preparedStatement.setInt(11,bk1.getNoOfParticipants());
			preparedStatement.setInt(12, bk1.getBookingID());
			preparedStatement.setInt(13,bk2.getUserID());
			preparedStatement.setString(14,"pending");
			
		    preparedStatement.executeUpdate();
		 
		}catch(SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}

	/**
	 * This method will return arrayList which contains all the bookings in the system
	 */
	@Override
	public ArrayList<Booking> getAllBookings() {
		ResultSet resultset = null;
		ArrayList<Booking> bookingArray = new ArrayList<Booking>();
		try {
			connection = DBConnectionTUtilEPS.getDBConnection();
			//Retrieve query from bookingQuery.xml to obtain all the bookings in the system 
			preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_All_Bookings));
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				Booking bk = new Booking();
				//set booking details of each booking to Booking object
				bk.setBookingID(resultset.getInt("BookingID"));
				bk.setUserID(resultset.getInt("userID"));
				bk.setEventName(resultset.getString("EventName"));
				bk.setEventType(resultset.getString("EventType"));
				bk.setEventDate(resultset.getString("EventDate"));
				
				String startTime = resultset.getString("StartingTime");
				String[] startTimeArr = startTime.split(":");
				String startHours = (Integer.parseInt(startTimeArr[0]) >= 10) ? startTimeArr[0] : ("0" + startTimeArr[0]);
				String startMins = (Integer.parseInt(startTimeArr[1]) >= 10) ? startTimeArr[1] : ("0" + startTimeArr[1]);
				String stratTimeEdited = startHours + ":" + startMins;
				bk.setStartingTime(stratTimeEdited); 
				
				String endTime = resultset.getString("EndingTime");
				String[] endTimeArr = endTime.split(":");
				String endHours = (Integer.parseInt(endTimeArr[0]) >= 10) ? endTimeArr[0] : ("0" + endTimeArr[0]);
				String endMins = (Integer.parseInt(endTimeArr[1]) >= 10) ? endTimeArr[1] : ("0" + endTimeArr[1]);
				String endingTimeEdited = endHours + ":" + endMins;
				bk.setEndingTime(endingTimeEdited);
				
				String venueID = resultset.getString("VenueID");
				//Retrive Query which return venue details when venue ID is given
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Get_VenueDetails));
				//Set venue ID
				preparedStatement.setString(1, venueID);
				ResultSet venueresultset = preparedStatement.executeQuery();
				while(venueresultset.next()) {
					//Set venue ID and Venue Name in Booking Object
					bk.setVenueName(venueresultset.getString("venueName"));
					bk.setVenueID(resultset.getInt("venueID"));
				}

				String mealID = resultset.getString("MealProviderID");
				if(mealID != null) {
					//Retrieve Query which return service Provider details when service Provider id is given
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					//set meal provider ID
					preparedStatement.setString(1, mealID);
					ResultSet mealresultset = preparedStatement.executeQuery();
					while(mealresultset.next()) {
						//Set mealProvider ID and meal provider name in Booking object
						bk.setMeals(mealresultset.getString("serviceProviderName"));
						bk.setMealID(mealresultset.getString("serviceProviderID"));
					}
				}

				String decorationID = resultset.getString("DecorationProviderID");
				if(decorationID  != null) {
					//Retrieve Query which return service Provider details when service provider id is given
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					//Set decoration provider ID to obtain decoration provider details
					preparedStatement.setString(1, decorationID );
					ResultSet decorationresultset = preparedStatement.executeQuery();
					while(decorationresultset.next()) {
						//Set details of decoration provider into Booking object
						bk.setDecoration(decorationresultset.getString("serviceProviderName"));
						bk.setDecorationID(decorationresultset.getString("serviceProviderID"));
					}
				}

				String soundAndLightingID = resultset.getString("SoundAndLightingProviderID");
				if(soundAndLightingID != null) {
					//Retrieve Query which return service Provider details when service provider id is given
					preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_GET_serviceProviders));
					//Set Sound and lighting provider ID to obtain Sound and lighting provider details
					preparedStatement.setString(1, soundAndLightingID);
					ResultSet soundLightresultset = preparedStatement.executeQuery();
					while(soundLightresultset.next()) {
						//Set details of sound and lighting provider into Booking object
						bk.setSoundLighting(soundLightresultset.getString("serviceProviderName"));
						bk.setSoundAndLightingID(soundLightresultset.getString("serviceProviderID"));
					}
				}

				bk.setTotalCost(resultset.getDouble("TotalCost"));
				bk.setNoOfParticipants(resultset.getInt("NoOfParticipants"));
				bk.setBookingStatus(resultset.getString("BookingStatus"));
				bookingArray.add(bk);
			}
		}catch(SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return bookingArray;
		
	}
	
	/**
	 * This method will update the status of the Booking when admin approved or reject the booking
	 */
	@Override
	public void approveRejectBooking(int bookingID, int userID,String eventDate, int venueID,String action) {
		if (action.equals("Approve")) {
			try {
				connection = DBConnectionTUtilEPS.getDBConnection();
				//Retrieve query from bookingQuery.xml which update the Booking Status to Approved
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Update_Booking_StatusToApproved));
				//Set Booking ID and User ID of the booking which needs to update the Booking Status
				preparedStatement.setInt(1, bookingID);
				preparedStatement.setInt(2, userID);
				preparedStatement.executeUpdate();
				
				/**
				 * Retrieve query from bookingQuery.xml which add record to venueBooking
				 * 
				 */
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Update_Booked_Venues));
				preparedStatement.setInt(1,venueID);
				preparedStatement.setString(2,eventDate);
				preparedStatement.executeUpdate();
				
			}catch(SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		if (action.equals("Reject")) {
			try {
				connection = DBConnectionTUtilEPS.getDBConnection();
				//Retrieve query from bookingQuery.xml which update the Booking Status to rejected
				preparedStatement = connection.prepareStatement(QueryUtilEPS.queryByID(CommonConstantsEPS.QUERY_ID_Update_Booking_StatusToRejected ));
				
				//Set Booking ID and User ID of the booking which needs to update the Booking Status
				preparedStatement.setInt(1, bookingID);
				preparedStatement.setInt(2, userID);
				preparedStatement.executeUpdate();
				
			}catch(SQLException | IOException | ParserConfigurationException | ClassNotFoundException | SAXException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	
}
