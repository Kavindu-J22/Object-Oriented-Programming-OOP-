package event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import database.DBConnect;
import user.ClientUser;

/**
 * This class refers to methods and data relating to Customised Events.
 * @author blazing squad
 */
public class CustomisedEvent extends Event {
	private static final long serialVersionUID = 1L;
	private boolean isCustomised;
	
	private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pstatement = null;
    private ResultSet rs = null;
    private String query = "";

	/**
	 * @return the isCustomised
	 */
	public boolean isCustomised() {
		return isCustomised;
	}

	/**
	 * @param isCustomised the isCustomised to set
	 */
	public void setCustomised(boolean isCustomised) {
		this.isCustomised = isCustomised;
	}
	
	/**
	 * @param name, message and contact to be sent as inquiry message
	 */
	public void inquireAboutEvent(String name, String message, String contact) {

	}

	/**
	 * @param event bean to add customised event data to database
	 */
	@Override
	public void addEvent(Event event) throws SQLException {
		
		query = "INSERT INTO event (eventname, eventtype, category, startdatetime, enddatetime, "
				+ "location, estimateguests, cost, description, clientname, "
				+ "clientcontactnum, clientemail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
    		connection = DBConnect.getConnection();
    		pstatement = connection.prepareStatement(query);
    		pstatement.setString(1 , event.getEventName());
    		pstatement.setString(2 , event.getEventType());
    		pstatement.setString(3 , event.getCategory());
    		pstatement.setDate(4, new java.sql.Date(event.getStartDatetime().getTime()));
    		pstatement.setDate(5, new java.sql.Date(event.getEndDatetime().getTime()));
    		pstatement.setString(6 , event.getLocation());
    		pstatement.setInt(7 , event.getEstGuestNumber());
    		pstatement.setBigDecimal(8 , event.getEventCost());
    		pstatement.setString(9 , event.getDescription());
    		String clientname = event.getClientSigned().getFirstName() + " " + event.getClientSigned().getLastName();
    		pstatement.setString(10 , clientname);
    		pstatement.setString(11 , event.getClientSigned().getContactNum());
    		pstatement.setString(12 , event.getClientSigned().getEmailAddress());
    		pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
        	pstatement.close();
            connection.close();
        }
		
	}

	/**
	 * @param eventid to select event in database
	 * @return event bean to view current pre-set event
	 */
	@Override
	public Event viewEvent(int eventid) throws SQLException {
		Event event = null;
		ClientUser clientSigned = null;
		
		query = "SELECT * FROM event where eventid="+eventid;
		
		try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
                event = new Event();
            	event.setEventName(rs.getString("eventname")); 
            	event.setCategory(rs.getString("category"));
            	event.setLocation(rs.getString("location"));
            	event.setEstGuestNumber(rs.getInt("estimateguests"));
            	event.setEventCost(rs.getBigDecimal("cost"));
            	event.setDescription(rs.getString("description"));
            	
            	event.setStartDatetime(rs.getDate("startdatetime"));
            	event.setEndDatetime(rs.getDate("enddatetime"));
            	event.setConfGuestNumber(rs.getInt("confirmedguests"));
            	
            	clientSigned = new ClientUser();
            	if(rs.getInt("clientid") != 0) {
            		clientSigned.setUserid(rs.getInt("clientid"));
            	}
            	String[] clientname = (rs.getString("clientname")).split(" ");
            	clientSigned.setFirstName(clientname[0]);
            	clientSigned.setLastName(clientname[1]);
            	clientSigned.setEmailAddress(rs.getString("clientemail"));
            	clientSigned.setContactNum(rs.getString("clientcontactnum"));
            	event.setClientSigned(clientSigned);
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
		
		return event;
	}

	/**
	 * @return ArrayList of events to view all pre-set events
	 */
	@Override
	public ArrayList<Event> viewAllEvents() throws SQLException {
		ArrayList<Event> events = new ArrayList<Event>();
		Event event;
		
		query = "SELECT eventid, eventname, category, bookingdate, startdatetime FROM event";
    	
    	try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
                event = new Event();
                event.setEventid(rs.getInt("eventid"));
            	event.setEventName(rs.getString("eventname")); 
            	event.setCategory(rs.getString("category"));
            	event.setBookingdate(rs.getDate("bookingdate"));
            	event.setStartDatetime(rs.getDate("startdatetime"));
 
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
        
		return events;
	}

	/**
	 * @param event bean to edit event data to database
	 */
	@Override
	public void editEvent(Event event) throws SQLException {
		
		query = "UPDATE event SET eventname=?, eventtype=?, category=?, startdatetime=?, enddatetime=?, "
				+ "location=?, estimateguests=?, cost=?, description=?, clientname=?, "
				+ "clientcontactnum=?, clientemail=? WHERE eventid=?";
		
		try {
    		connection = DBConnect.getConnection();
    		pstatement = connection.prepareStatement(query);
    		pstatement.setString(1 , event.getEventName());
    		pstatement.setString(2 , event.getEventType());
    		pstatement.setString(3 , event.getCategory());
    		pstatement.setDate(4, new java.sql.Date(event.getStartDatetime().getTime()));
    		pstatement.setDate(5, new java.sql.Date(event.getEndDatetime().getTime()));
    		pstatement.setString(6 , event.getLocation());
    		pstatement.setInt(7 , event.getEstGuestNumber());
    		pstatement.setBigDecimal(8 , event.getEventCost());
    		pstatement.setString(9 , event.getDescription());
    		String clientname = event.getClientSigned().getFirstName() + " " + event.getClientSigned().getLastName();
    		pstatement.setString(10 , clientname);
    		pstatement.setString(11 , event.getClientSigned().getContactNum());
    		pstatement.setString(12 , event.getClientSigned().getEmailAddress());
    		pstatement.setInt(13 , event.getEventid());
    		pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
        	pstatement.close();
            connection.close();
        }
	}

	/**
	 * @param eventid to delete or remove in database
	 */
	@Override
	public void deleteEvent(int eventid) throws SQLException {
		
		query = "DELETE FROM event where eventid="+eventid;
		
		try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
	}
}
