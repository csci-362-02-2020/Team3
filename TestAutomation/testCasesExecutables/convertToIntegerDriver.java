package testCaseExecutables;
public class convertToIntegerDriver{

	public static void main(String args[]){


			Long input = Long.parseLong(args[0]); 	//Turns strings pass in to Longs
				//Stores the expected val in var
			Integer actual_output = OpenmrsUtil.convertToInteger(input);	//Runs the method and saves output
			String actual_output_string;

			//If the output is null save that as the output sting
			System.out.println(actual_output);

		}
	}
