package testCaseExecutables;
import java.util.Calendar;
import java.util.Date;
import java.time.Instant;

public class getLastMomentOfDayDriver{
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("No input to test");
		}
		else{		
			long dateVal = Long.parseLong(args[0]);
			Date date1 = new Date(dateVal);
			System.out.println(OpenmrsUtil.getLastMomentOfDay(date1));
		}
	}
}