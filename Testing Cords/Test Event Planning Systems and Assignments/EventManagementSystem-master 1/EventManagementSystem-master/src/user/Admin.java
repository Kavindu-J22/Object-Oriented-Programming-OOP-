package user;

/**
 * This class refers to methods and data relating to the Admin.
 * @author blazing squad
 */
public class Admin extends StaffUser {
	private boolean isAdmin;
	
	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @param userid and user role to update role
	 */
	public void changeRole(int userid, int role) {
		
	}
}
