	
import java.util.Comparator;
import java.io.*;

public class convertToIntegerDriver{


	public static Integer convertToInteger(Long longValue) {
		if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
			return null;
			//throw new IllegalArgumentException(longValue + " cannot be cast to Integer without changing its value.");
		}
		return longValue.intValue();
	}

	public static void main(String args[]) throws FileNotFoundException{

		//Test that the correct number of inputs have been passed throught he command line
		if(args.length < 2){
			System.out.println("Please pass in input and expected output");
		}
		else{

			PrintStream o = new PrintStream(new File("Output.txt"));
			System.setOut(o);
			Long input = Long.parseLong(args[0]); 	//Turns strings pass in to Longs
			String expected_output = args[1]; 		//Stores the expected val in var
			Integer actual_output = convertToInteger(input);	//Runs the method and saves output
			String actual_output_string;

			//If the output is null save that as the output sting
			if(actual_output == null){
				actual_output_string = "null";
			}

			//Otherwise jave the output of the function as a sting 
			else{
				actual_output_string = Integer.toString(actual_output);
			}

			//compare expected output to actual, if they are the same then the test is passed
			if(expected_output.compareTo(actual_output_string) == 0){
				System.out.println("TEST PASSED");
			}

			//if they are differnt the test is failds
			else{ System.out.println("TEST FAILED");}
		}
	}
}
	