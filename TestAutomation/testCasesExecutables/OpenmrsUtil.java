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
	 * Compares two java.util.Date objects, but handles java.sql.Timestamp (which is not directly
	 * comparable to a date) by dropping its nanosecond value.
	 */
	public static int compare(Date d1, Date d2) {
		if (d1 instanceof Timestamp && d2 instanceof Timestamp) {
			return d1.compareTo(d2);
		}
		if (d1 instanceof Timestamp) {
			d1 = new Date(d1.getTime());
		}
		if (d2 instanceof Timestamp) {
			d2 = new Date(d2.getTime());
		}
		return d1.compareTo(d2);
	}

	/**
	 * Compares two Date/Timestamp objects, treating null as the earliest possible date.
	 */
	public static int compareWithNullAsEarliest(Date d1, Date d2) {
		if (d1 == null && d2 == null) {
			return 0;
		}
		if (d1 == null) {
			return -1;
		} else if (d2 == null) {
			return 1;
		} else {
			return compare(d1, d2);
		}
	}

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
		calender.set(Calendar.MILLISECOND, 999);
		
		return calender.getTime();
	}


	public static Date safeDate(Date d1) {
		return new Date(d1.getTime());
	}

	// /**
	//  * Tests if the given String starts with any of the specified prefixes
	//  * 
	//  * @param str the string to test
	//  * @param prefixes an array of prefixes to test against
	//  * @return true if the String starts with any of the specified prefixes, otherwise false.
	//  */
	// public static boolean stringStartsWith(String str, String[] prefixes) {
	// 	for (String prefix : prefixes) {
	// 		if (StringUtils.startsWith(str, prefix)) {
	// 			return true;
	// 		}
	// 	}
		
	// 	return false;
	// }


	/**
	 * Loops over the collection to check to see if the given object is in that collection. This
	 * method <i>only</i> uses the .equals() method for comparison. This should be used in the
	 * patient/person objects on their collections. Their collections are SortedSets which use the
	 * compareTo method for equality as well. The compareTo method is currently optimized for
	 * sorting, not for equality. A null <code>obj</code> will return false
	 * 
	 * @param objects collection to loop over
	 * @param obj Object to look for in the <code>objects</code>
	 * @return true/false whether the given object is found
	 * <strong>Should</strong> use equals method for comparison instead of compareTo given List collection
	 * <strong>Should</strong> use equals method for comparison instead of compareTo given SortedSet collection
	 */
	public static boolean collectionContains(Collection<?> objects, Object obj) {
		if (obj == null || objects == null) {
			return false;
		}
		
		for (Object o : objects) {
			if (o != null && o.equals(obj)) {
				return true;
			}
		}
		
		return false;
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
			return null;
			//throw new IllegalArgumentException(longValue + " cannot be cast to Integer without changing its value.");
		}
		return longValue.intValue();
	}
}
	
