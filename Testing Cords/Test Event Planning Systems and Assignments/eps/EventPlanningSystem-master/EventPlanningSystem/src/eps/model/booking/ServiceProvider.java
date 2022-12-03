package eps.model.booking;

public class ServiceProvider {
	private int serviceID;
	private String ServiceType;
	private String ServiceProviderName;
	private double cost;
	/**
	 * @return the serviceProviderName
	 */
	public String getServiceProviderName() {
		return ServiceProviderName;
	}
	/**
	 * @param serviceProviderName the serviceProviderName to set
	 */
	public void setServiceProviderName(String serviceProviderName) {
		ServiceProviderName = serviceProviderName;
	}
	
	/**
	 * @return the serviceID
	 */
	public int getServiceID() {
		return serviceID;
	}
	/**
	 * @param serviceID the serviceID to set
	 */
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return ServiceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
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
	@Override
	public String toString() {
		return "ServiceProvider [serviceID=" + serviceID + ", ServiceType=" + ServiceType + ", ServiceProviderName="
				+ ServiceProviderName + ", cost=" + cost + "]";
	}
	
	
	
	
}
