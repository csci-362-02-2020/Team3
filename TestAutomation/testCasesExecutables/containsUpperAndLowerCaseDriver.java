package testCaseExecutables;
import java.util.Comparator;

// @param objects collection to loop over
//  * @param obj Object to look for in the <code>objects</code>
//  * @return true/false whether the given object is found
//  * <strong>Should</strong> use equals method for comparison instead of compareTo given List collection
//  * <strong>Should</strong> use equals method for comparison instead of compareTo given SortedSet collection
 public class containsUpperAndLowerCaseDriver{
	

	public static void main(String[] args) {
			String input = args[0];
			if(args[0].toLowerCase().compareTo("null") == 0){
				input = null;
			}
		//Stores the expected val in var
			boolean actual_output = OpenmrsUtil.containsUpperAndLowerCase(input);  //Runs the method and saves output
			System.out.println(actual_output);

			//compare expected output to actual, if they are the same then the test is passed

		
	
}
}
