package eps.model.booking;

public class Venue {
	private int venueID;
	private double cost;
	private String name;
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
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Venue [venueID=" + venueID + ", cost=" + cost + ", name=" + name + "]";
	}
	
	
	
}
