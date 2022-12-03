package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DBConnect;

/**
 * This class refers to methods and data relating to the Client.
 * @author blazing squad
 */
public class ClientUser extends StaffUser {
	private int accountAge; //accountAge refers to how long a client has been with the company or website

	private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pstatement = null;
    private ResultSet rs = null;
    private String query = "";
    
	/**
	 * @return the accountAge
	 */
	public int getAccountAge() {
		return accountAge;
	}

	/**
	 * @param accountAge the accountAge to set
	 */
	public void setAccountAge(int accountAge) {
		this.accountAge = accountAge;
	}

	/**
	 * @return ArrayList of users to view all client users
	 */
	@Override
	public ArrayList<StaffUser> viewUsers() throws SQLException {
		ArrayList<StaffUser> users = new ArrayList<StaffUser>();
		StaffUser user;
		
		query = "SELECT userid, firstname, lastname FROM user WHERE userrole='Client'";
    	
    	try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	user = new StaffUser();
            	user.setUserid(rs.getInt("userid"));
            	user.setFirstName(rs.getString("firstname"));
            	user.setLastName(rs.getString("lastname"));
 
            	users.add(user);	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
    	
		return users;
	}
	/**
	 * @param userid to select client data in database
	 * @return clientuser bean
	 */
	public ClientUser getCustomEventClientData(int userid) throws SQLException {
		ClientUser client = null;
		
		query = "SELECT firstname, lastname, emailaddress, contactnum FROM user where userid="+userid;
    	
    	try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	client = new ClientUser();
            	client.setFirstName(rs.getString("firstname"));
            	client.setLastName(rs.getString("lastname"));
            	client.setEmailAddress(rs.getString("emailaddress"));
            	client.setContactNum(rs.getString("contactnum"));
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
    	
		return client;
	}
	
}
