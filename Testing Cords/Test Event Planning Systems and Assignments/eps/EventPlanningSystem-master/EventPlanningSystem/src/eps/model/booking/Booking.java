/**
 * 
 */
package eps.model.booking;

/**
 * @author Asiyaa
 *
 */
public class Booking {
	private String eventName;
	private String eventType;
	private String eventDate;
	private String StartingTime;
	private String EndingTime;
	private int NoOfParticipants;
	private String venueName;
	private String meals;
	private String decoration;
	private String soundLighting;
	private double totalCost;
	private int userID;
	private int bookingID;
	
	private int venueID;
	private String mealID;
	private String decorationID;
	private String soundAndLightingID;
	private String bookingStatus;
	
	/**
	 * @return the bookingStatus
	 */
	public String getBookingStatus() {
		return bookingStatus;
	}
	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	/**
	 * @return the mealID
	 */
	public String getMealID() {
		return mealID;
	}
	/**
	 * @param mealID the mealID to set
	 */
	public void setMealID(String mealID) {
		this.mealID = mealID;
	}
	/**
	 * @return the decorationID
	 */
	public String getDecorationID() {
		return decorationID;
	}
	/**
	 * @param decorationID the decorationID to set
	 */
	public void setDecorationID(String decorationID) {
		this.decorationID = decorationID;
	}
	/**
	 * @return the soundAndLightingID
	 */
	public String getSoundAndLightingID() {
		return soundAndLightingID;
	}
	/**
	 * @param soundAndLightingID the soundAndLightingID to set
	 */
	public void setSoundAndLightingID(String soundAndLightingID) {
		this.soundAndLightingID = soundAndLightingID;
	}
	
	/**
	 * @return the bookingID
	 */
	public int getBookingID() {
		return bookingID;
	}
	/**
	 * @param bookingID the bookingID to set
	 */
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the venueID
	 */
	public int getVenueID() {
		return venueID;
	}
	/**
	 * @param venueID the venueID to set
	 */
	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}
	
	
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the startingTime
	 */
	public String getStartingTime() {
		return StartingTime;
	}
	/**
	 * @param startingTime the startingTime to set
	 */
	public void setStartingTime(String startingTime) {
		StartingTime = startingTime;
	}
	/**
	 * @return the endingTime
	 */
	public String getEndingTime() {
		return EndingTime;
	}
	/**
	 * @param endingTime the endingTime to set
	 */
	public void setEndingTime(String endingTime) {
		EndingTime = endingTime;
	}
	/**
	 * @return the noOfParticipants
	 */
	public int getNoOfParticipants() {
		return NoOfParticipants;
	}
	/**
	 * @param noOfParticipants the noOfParticipants to set
	 */
	public void setNoOfParticipants(int noOfParticipants) {
		NoOfParticipants = noOfParticipants;
	}
	/**
	 * @return the venueName
	 */
	public String getVenueName() {
		return venueName;
	}
	/**
	 * @param venueName the venueName to set
	 */
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	/**
	 * @return the meals
	 */
	public String getMeals() {
		return meals;
	}
	/**
	 * @param meals the meals to set
	 */
	public void setMeals(String meals) {
		this.meals = meals;
	}
	/**
	 * @return the decoration
	 */
	public String getDecoration() {
		return decoration;
	}
	/**
	 * @param decoration the decoration to set
	 */
	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}
	/**
	 * @return the soundLighting
	 */
	public String getSoundLighting() {
		return soundLighting;
	}
	/**
	 * @param soundLighting the soundLighting to set
	 */
	public void setSoundLighting(String soundLighting) {
		this.soundLighting = soundLighting;
	}
	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}
	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Booking [eventName=" + eventName + ", eventType=" + eventType + ", eventDate=" + eventDate
				+ ", StartingTime=" + StartingTime + ", EndingTime=" + EndingTime + ", NoOfParticipants="
				+ NoOfParticipants + ", venueName=" + venueName + ", meals=" + meals + ", decoration=" + decoration
				+ ", soundLighting=" + soundLighting + ", totalCost=" + totalCost + ", userID=" + userID
				+ ", bookingID=" + bookingID + ", venueID=" + venueID + ", mealID=" + mealID + ", decorationID="
				+ decorationID + ", soundAndLightingID=" + soundAndLightingID + ", bookingStatus=" + bookingStatus
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
