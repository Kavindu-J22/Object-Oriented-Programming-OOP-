package event;

import java.io.Serializable;

/**
 * This class refers to the java bean for Guest.
 * @author blazing squad
 */
@SuppressWarnings("serial")
public class Guest implements Serializable {
	private String emailAddress;
	private int extras;
	private String guestName;
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
	 * @return the extras
	 */
	public int getExtras() {
		return extras;
	}
	/**
	 * @param extras the extras to set
	 */
	public void setExtras(int extras) {
		this.extras = extras;
	}
	/**
	 * @return the guestName
	 */
	public String getGuestName() {
		return guestName;
	}
	/**
	 * @param guestName the guestName to set
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
}
