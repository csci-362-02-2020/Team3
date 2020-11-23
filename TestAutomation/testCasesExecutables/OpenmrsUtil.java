package testCaseExecutables;
import java.util.Date;
import java.time.Instant;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.Collection;
import java.sql.Timestamp;
import java.util.Arrays;
//import org.apache.commons.lang3.StringUtils;

public class OpenmrsUtil{

	/**
	 * Gets the date having the last millisecond of a given day. Meaning that the hours, seconds,
	 * and milliseconds are the latest possible for that day.
	 * 
	 * @param day the day.
	 * @return the date with the last millisecond of the day.
	 */
	public static Date getLastMomentOfDay(Date day) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(day);
		calender.set(Calendar.HOUR_OF_DAY, 23);
		calender.set(Calendar.MINUTE, 59);
		calender.set(Calendar.SECOND, 59);
		//calender.set(Calendar.SECOND, 58); //This is an error
		calender.set(Calendar.MILLISECOND, 999);
		
		return calender.getTime();
	}


	
		/**
	 * @param test the string to test
	 * @return true if the passed string contains both upper and lower case characters
	 * <strong>Should</strong> return true if string contains upper and lower case
	 * <strong>Should</strong> return false if string does not contain lower case characters
	 * <strong>Should</strong> return false if string does not contain upper case characters
	 */
	public static boolean containsUpperAndLowerCase(String test) {
		if (test != null) {

			Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])[\\w|\\W]*$");
			//Pattern pattern = Pattern.compile("(?=.*?[a-z])[\\w|\\W]*$"); //This is our Error
			Matcher matcher = pattern.matcher(test);
			return matcher.matches();
		}
		return false;
	}

	/**
	 * @param test the string to test
	 * @return true if the passed string contains only numeric characters
	 * <strong>Should</strong> return true if string contains only digits
	 * <strong>Should</strong> return false if string contains any non-digits
	 */
	public static boolean containsOnlyDigits(String test) {
		if (test != null) {
			for (char c : test.toCharArray()) {
				if (!Character.isDigit(c)) {
					return false;
				}
			}
		}
		return !test.isEmpty();
		//return test.isEmpty(); //This is an error
	}

		/**
	 * This method converts the given Long value to an Integer. If the Long value will not fit in an
	 * Integer an exception is thrown
	 * 
	 * @param longValue the value to convert
	 * @return the long value in integer form.
	 * @throws IllegalArgumentException if the long value does not fit into an integer
	 */
	public static Integer convertToInteger(Long longValue) {
		
		if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) { 
		//if (longValue > Integer.MIN_VALUE || longValue < Integer.MAX_VALUE) { //This is an error
			return null;
			//throw new IllegalArgumentException(longValue + " cannot be cast to Integer without changing its value.");
		}
		return longValue.intValue();
	}
}
	
