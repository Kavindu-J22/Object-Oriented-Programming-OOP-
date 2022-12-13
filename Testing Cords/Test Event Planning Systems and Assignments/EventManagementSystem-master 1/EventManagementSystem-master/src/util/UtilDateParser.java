package util;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


/**
 * This class refers to methods handling data.
 * @author blazing squad
 */
public class UtilDateParser {
	
	public static Date parseDateFromForm(String tempdate) {
		
		if (StringUtils.countMatches(tempdate, ":") == 1) {
			tempdate += ":00";
		}
		
		Timestamp timestamp = Timestamp.valueOf(tempdate.replace("T"," "));
		Date finaldate = Date.from(timestamp.toInstant());
		
		return finaldate;
	}
}
