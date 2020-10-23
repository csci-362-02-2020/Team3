package testCaseExecutables;
import java.util.Date;
import java.time.Instant;


public class DateUtilDriver{

	public static void main(String args[]){
		long dateVal = Long.parseLong(args[0]);
		Date date1 = new Date(dateVal);
		DateUtil date = new DateUtil();
	
		System.out.println(date.truncateToSeconds(date1));
	}
}
