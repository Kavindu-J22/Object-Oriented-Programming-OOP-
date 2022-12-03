package eps.util.booking;

import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import eps.service.booking.IBookingService;



public class CommonUtilEPS {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IBookingService.class.getName());
	
	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtilEPS.class.getResourceAsStream(CommonConstantsEPS.PROPERTY_FILE));
			
		} catch (java.io.IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
}
