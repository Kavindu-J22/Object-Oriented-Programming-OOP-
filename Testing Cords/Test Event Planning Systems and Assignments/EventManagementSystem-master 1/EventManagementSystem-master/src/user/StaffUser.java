package user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import database.DBConnect;
import util.BCrypt;

/**
 * This class refers to methods and data relating to the User.
 * @author blazing squad
 */
public class StaffUser {
	private int userid;
	private String userName;
	private String password;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String userRole;
	private Date dateAdded;
	private String contactNum;
	
	private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pstatement = null;
    private ResultSet rs = null;
    private String query = "";
	
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 * @return the dateAdded
	 */
	public Date getDateAdded() {
		return dateAdded;
	}
	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	/**
	 * @return the contactNum
	 */
	public String getContactNum() {
		return contactNum;
	}
	/**
	 * @param contactNum the contactNum to set
	 */
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	/**
	 * @param userName and password to validate user login
	 * @return userid for successful login and 0 for unsuccessful
	 */
	public int login(String userName, String password) throws SQLException {
		int success = 0;
		StaffUser user = null;
		
		query = "SELECT * FROM user where username='"+userName+"'";
		
		try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	user = new StaffUser();
            	user.setUserid(rs.getInt("userid"));
            	user.setUserName(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setUserRole(rs.getString("userrole"));
            	
            	success = user.getUserid();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
		
		boolean validpassword = false;
		if(success != 0) {
			//Check if password matches
			validpassword = BCrypt.checkpw(password, user.getPassword());
			if(!validpassword) {
				success = 0;
			}
		}
		
		return success;
	}
	/**
	 * @param user bean to add user data to database
	 */
	public void addUser(StaffUser user) throws SQLException {
		
		query = "INSERT INTO user (username, password, emailaddress, firstname, lastname, "
				+ "userrole, contactnum) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
    		connection = DBConnect.getConnection();
    		pstatement = connection.prepareStatement(query);
    		pstatement.setString(1 , user.getUserName());
    		pstatement.setString(2 , user.getPassword());
    		pstatement.setString(3 , user.getEmailAddress());
    		pstatement.setString(4 , user.getFirstName());
    		pstatement.setString(5 , user.getLastName());
    		pstatement.setString(6 , user.getUserRole());
    		pstatement.setString(7 , user.getContactNum());
    		pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
        	pstatement.close();
            connection.close();
        }
	}
	/**
	 * @param user bean to update user data in database
	 */
	public void resetUserCredentials(StaffUser user) throws SQLException {
		
		query = "UPDATE user SET username=?, password=? WHERE userid=? ";
		
		try {
    		connection = DBConnect.getConnection();
    		pstatement = connection.prepareStatement(query);
    		pstatement.setString(1 , user.getUserName());
    		pstatement.setString(2 , user.getPassword());
    		pstatement.setInt(3 , user.getUserid());
    		pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
        	pstatement.close();
            connection.close();
        }
	}
	/**
	 * @param userid to select user in database
	 * @return user bean to view current user
	 */
	public StaffUser viewUser(int userid) throws SQLException {
		StaffUser user = null;
		
		query = "SELECT * FROM user where userid="+userid;
    	
    	try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	user = new StaffUser();
            	user.setUserid(rs.getInt("userid"));
            	user.setUserName(rs.getString("username"));
            	user.setEmailAddress(rs.getString("emailaddress"));
            	user.setFirstName(rs.getString("firstname"));
            	user.setLastName(rs.getString("lastname"));
            	user.setUserRole(rs.getString("userrole"));
            	user.setDateAdded(rs.getDate("dateadded"));
            	user.setContactNum(rs.getString("contactnum"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
    	
		return user;
	}
	/**
	 * @return ArrayList of users to view all current users
	 */
	public ArrayList<StaffUser> viewUsers() throws SQLException {
		ArrayList<StaffUser> users = new ArrayList<StaffUser>();
		StaffUser user;
		
		query = "SELECT userid, username, firstname, lastname, userrole FROM user";
    	
    	try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	user = new StaffUser();
            	user.setUserid(rs.getInt("userid"));
            	user.setUserName(rs.getString("username"));
            	user.setFirstName(rs.getString("firstname"));
            	user.setLastName(rs.getString("lastname"));
            	user.setUserRole(rs.getString("userrole"));
 
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
	 * @param user bean to update user data in database
	 */
	public void editUserDetails(StaffUser user) throws SQLException {
		
		query = "UPDATE user SET username=?, emailaddress=?, firstname=?,"
				+ "lastname=?, userrole=?, contactnum=? WHERE userid=? ";
		
		try {
    		connection = DBConnect.getConnection();
    		pstatement = connection.prepareStatement(query);
    		pstatement.setString(1 , user.getUserName());
    		pstatement.setString(2 , user.getEmailAddress());
    		pstatement.setString(3 , user.getFirstName());
    		pstatement.setString(4 , user.getLastName());
    		pstatement.setString(5 , user.getUserRole());
    		pstatement.setString(6 , user.getContactNum());
    		pstatement.setInt(7 , user.getUserid());
    		pstatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
        	pstatement.close();
            connection.close();
        }
	}
	/**
	 * @param userid to delete or remove in database
	 */
	public void deleteUser(int userid) throws SQLException {
		
		query = "DELETE FROM user where userid="+userid;
		
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
	 * @param userid to select username in database
	 * @return user full name
	 */
	public String getUsernameById(int userid) throws SQLException {
		String fullname = "";
		
		query = "SELECT firstname, lastname FROM user where userid="+userid;
    	
    	try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	String firstname = rs.getString("firstname");
            	String lastname = rs.getString("lastname");
            	
            	fullname = firstname + " " + lastname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
    	
		return fullname;
	}
	/**
	 * @return ArrayList of users to view all staff users
	 */
	public ArrayList<StaffUser> viewAllStaff() throws SQLException {
		ArrayList<StaffUser> staff = new ArrayList<StaffUser>();
		StaffUser user;
		
		query = "SELECT userid, firstname, lastname FROM user WHERE userrole='Employee'";
    	
    	try {
    		connection = DBConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
            	user = new StaffUser();
            	user.setUserid(rs.getInt("userid"));
            	user.setFirstName(rs.getString("firstname"));
            	user.setLastName(rs.getString("lastname"));
 
            	staff.add(user);	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally  {
            statement.close();
            connection.close();
        }
    	
		return staff;
	}
}
