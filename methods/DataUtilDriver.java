

import java.util.Date;

public class DataUtilDriver{

	public static void main(String args[]){
		Date date1 = new Date();
		DateUtil data = new DateUtil();
		Instant instant = date.toInstant();
	
	
	System.out.println(date1.getTime());
	System.out.println(data.truncateToSeconds(date1));
	System.out.println(instant);

	//System.out.println();
	//System.out.println();
	//System.out.println();
	//System.out.println();
	}
}
