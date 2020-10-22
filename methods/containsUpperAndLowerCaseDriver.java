
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// @param objects collection to loop over
//  * @param obj Object to look for in the <code>objects</code>
//  * @return true/false whether the given object is found
//  * <strong>Should</strong> use equals method for comparison instead of compareTo given List collection
//  * <strong>Should</strong> use equals method for comparison instead of compareTo given SortedSet collection
 public class containsUpperAndLowerCaseDriver{
	public static boolean containsUpperAndLowerCase(String test) {
		if (test != null) {
			Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])[\\w|\\W]*$");
			Matcher matcher = pattern.matcher(test);
			return matcher.matches();
		}
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
	if(args.length < 2){
			System.out.println("Please pass in input and expected output");
		}
		else{

			PrintStream o = new PrintStream(new File("Output.txt"));
			System.setOut(o);
			String input = args[0]; 	//save input as a sting 
			boolean expected_output = Boolean.valueOf(args[1]); 		//Stores the expected val in var
			boolean actual_output = containsUpperAndLowerCase(input);  //Runs the method and saves output


			//compare expected output to actual, if they are the same then the test is passed
			if(expected_output == actual_output){
				System.out.println("TEST PASSED");
			}

			//if they are differnt the test is failds
			else{ System.out.println("TEST FAILED");}
		
	}
}
}