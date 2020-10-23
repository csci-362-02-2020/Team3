package testCaseExecutables;

public class DrugsByNameDriver{

	public static void main(String args[]){
	
	DrugByNameComparator drugs = new DrugByNameComparator();

	String inputString[] = args[0].split(" ");
	int output = drugs.compareDrugNamesInoringNumericals(inputString[0],inputString[1]);
	System.out.println(output);
	}
}
