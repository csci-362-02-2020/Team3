package testCaseExecutables;
public class containsOnlyDigitsDriver{

	public static void main(String[] args) {
		String input = args[0];
			if(args[0].toLowerCase().compareTo("null") == 0){
				input = null;
			}
		
		boolean output = OpenmrsUtil.containsOnlyDigits(input);
		System.out.println(output);
	}
}
