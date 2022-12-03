package event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DBConnect;

/**
 * This class refers to methods and data relating to Event Details.
 * @author blazing squad
 */
public class EventDetails {
	private int itemid;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private int staffAssigned;
	private int eventid;
	private int ispreset;
	
	private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pstatement = null;
    private ResultSet rs = null;
    private String query = "";
    
	/**
	 * @return the itemid
	 */
	public int getItemid() {
		return itemid;
	}
	/**
	 * @param itemid the itemid to set
	 */
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	/**
	 * @return the staffAssigned
	 */
	public int getStaffAssigned() {
		return staffAssigned;
	}
	/**
	 * @param staffAssigned the staffAssigned to set
	 */
	public void setStaffAssigned(int staffAssigned) {
		this.staffAssigned = staffAssigned;
	}
	/**
	 * @return the eventid
	 */
	public int getEventid() {
		return eventid;
	}
	/**
	 * @param eventid the eventid to set
	 */
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	/**
	 * @return the ispreset
	 */
	public int getIspreset() {
		return ispreset;
	}
	/**
	 * @param ispreset the ispreset to set
	 */
	public void setIspreset(int ispreset) {
		this.ispreset = ispreset;
	}
	/**
	 * @param event details bean to add event details data to database
	 */
	public void addEventDetails(EventDetails eventDetails) throws SQLException {
		
		query = "INSERT INTO eventdetail (itemname, itemtype, itemdescription, staffassigned, "
				+ "eventid, ispreset) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
    		connection = DBConnect.getConnection();
    		pstatement = connection.prepareStatement(query);
    		pstatement.setString(1 , eventDetails.getItemName());
    		pstatement.setString(2 , eventDetails.getItemType());
    		pstatement.setString(3 , eventDetails.getItemDescription());
    		pstatement.setInt(4 , eventDetails.getStaffAssigned());
    		pstatement.setInt(5 , eventDetails.getEventid());
    		pstatement.setInt(6 , eventDetails.getIspreset());
    		pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
        	pstatement.close();
            connection.close();
        }
	}
	/**
	 * @param event details bean to update event details data in database
	 */
	public void editEventDetails(EventDetails eventDetails) throws SQLException {
		
		query = "UPDATE eventdetail SET itemname=?, itemtype=?, itemdescription=?,"
				+ "staffassigned=? WHERE itemid=? ";
		
		try {
    		connection = DBConnect.getConnection();
    		pstatement = connection.prepareStatement(query);
    		pstatement.setString(1 , eventDetails.getItemName());
    		pstatement.setString(2 , eventDetails.getItemType());
    		pstatement.setString(3 , eventDetails.getItemDescription());
    		pstatement.setInt(4 , eventDetails.getStaffAssigned());
    		pstatement.setInt(5 , eventDetails.getItemid());
    		pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
        	pstatement.close();
            connection.close();
        }
	}
	/**
	 * @param event details id to delete or remove in database
	 */
	public void deleteEventDetails(int itemid) throws SQLException {
		
		query = "DELETE FROM eventdetail where itemid="+itemid;
		
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
	/**
	 * @param event details bean to view current event details
	 */
	public EventDetails viewEventDetail(int itemid) throws SQLException {
		EventDetails item = null;
		
		query = "SELECT itemname, itemtype, itemdescription, staffassigned FROM eventdetail "
				+ "WHERE itemid=" + itemid;
		
		try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	item = new EventDetails();
            	item.setItemName(rs.getString("itemname"));
            	item.setItemType(rs.getString("itemtype"));
            	item.setItemDescription(rs.getString("itemdescription"));
            	item.setStaffAssigned(rs.getInt("staffassigned"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
		
		return item;
	}
	/**
	 * @param event details bean to view current event details
	 */
	public ArrayList<EventDetails> viewEventDetails(int eventid, int ispreset) throws SQLException {
		ArrayList<EventDetails> items = new ArrayList<EventDetails>();
		EventDetails item;
		
		query = "SELECT itemid, itemname, itemtype, itemdescription, staffassigned FROM eventdetail "
				+ "WHERE eventid=" + eventid + " AND ispreset=" + ispreset;
		
		try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	item = new EventDetails();
            	item.setItemid(rs.getInt("itemid"));
            	item.setItemName(rs.getString("itemname"));
            	item.setItemType(rs.getString("itemtype"));
            	item.setItemDescription(rs.getString("itemdescription"));
            	item.setStaffAssigned(rs.getInt("staffassigned"));
 
            	items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
		
		return items;
	}
}
