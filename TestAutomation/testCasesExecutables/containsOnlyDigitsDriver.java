package testCaseExecutables;
public class containsOnlyDigitsDriver{

	public static void main(String[] args) {
		String input = args[0];
			if(args[0].toLowerCase().compareTo("null") == 0){
				input = null;
			}
		OpenmrsUtil oMrs = new OpenmrsUtil();
		boolean output = oMrs.containsOnlyDigits(input);
		System.out.println(output);
	}
}