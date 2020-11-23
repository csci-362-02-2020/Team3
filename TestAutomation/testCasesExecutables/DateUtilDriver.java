package testCaseExecutables;
import java.util.Date;
import java.time.Instant;


public class DateUtilDriver{

	public static void main(String args[]){
if(args.length < 1){
		System.out.println("No input to test");
		}
	else{		
		String[] dateInfo = (args[0].split("/"));
		int[] date = new int[dateInfo.length];
		for(int i = 0; i <dateInfo.length; i++){

			date[i]= Integer.parseInt(dateInfo[i]);
			if(i ==0){
				date[i] = date[i] - 1900;
			}
			if(i == 1){
				date[i] = date[i] - 1;
			}
			}
		Date date1 = new Date(date[0],date[1],date[2],date[3],date[4],date[5]);
			
		System.out.println(DateUtil.truncateToSeconds(date1));
	}
}
}
