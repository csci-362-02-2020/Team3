package testCaseExecutables;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Utility classes that provide date-related methods
 * @since 2.0
 */
public class DateUtil {
	
	public DateUtil() {
	}
	
	/**
	 * @param date
	 * @return date truncated to second precision (e.g. with milliseconds dropped)
	 */
	public static Date truncateToSeconds(Date date) {
		Instant instant = date.toInstant().truncatedTo(ChronoUnit.SECONDS);
		//Instant instant = date.toInstant().truncatedTo(ChronoUnit.HOURS); //This is an error
		return Date.from(instant);
	}
}
	
