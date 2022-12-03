package event;

import java.util.ArrayList;

/**
 * This class refers to methods and data relating to the Guest Invitation.
 * @author blazing squad
 */
public class GuestInvitation {
	private ArrayList<Guest> guests;
	private int confirmedGuestNumbers;
	/**
	 * @return the guests
	 */
	public ArrayList<Guest> getGuests() {
		return guests;
	}
	/**
	 * @param guests the guests to set
	 */
	public void setGuests(ArrayList<Guest> guests) {
		this.guests = guests;
	}
	/**
	 * @return the confirmedGuestNumbers
	 */
	public int getConfirmedGuestNumbers() {
		return confirmedGuestNumbers;
	}
	/**
	 * @param confirmedGuestNumbers the confirmedGuestNumbers to set
	 */
	public void setConfirmedGuestNumbers(int confirmedGuestNumbers) {
		this.confirmedGuestNumbers = confirmedGuestNumbers;
	}
	/**
	 * @param count, senderName and eventid to construct event guest invitation
	 */
	public void sendGuestInvitation(int count, String senderName, int eventid) {
		
	}
	/**
	 * @param eventid to count guests for specific event
	 * @return confirmed responses
	 */
	public int countResponses(int eventid) {
		int responses=0;
		return responses;
	}
	/**
	 * @param guestName and number per guestName to check attendance
	 */
	public void confirmAttendance(String guestName, int number) {
		
	}
	/**
	 * @param guest bean to add to the guest invitation list
	 * @return boolean to check if add is successful
	 */
	public boolean addGuest(Guest guest) {
		return true;
	}
	/**
	 * @param guest bean to delete from the guest invitation list
	 */
	public void deleteGuest(Guest guest) {
		
	}
}
