

public class DrugsByNameDriver{

	public static void main(String args[]){
	
	DrugByNameComparator drugs = new DrugByNameComparator();

	System.out.println("DayQuil, Allegra: " + drugs.compareDrugNamesInoringNumericals("DayQuil", "Allegra"));
	System.out.println("Allegra, Allegra: " + drugs.compareDrugNamesInoringNumericals("Allegra", "Allegra"));
	System.out.println("Allegra, DayQuil: " + drugs.compareDrugNamesInoringNumericals("Allegra", "DayQuil"));
	System.out.println("3Allegra, 5DayQuil: " + drugs.compareDrugNamesInoringNumericals("3Allegra", "5DayQuil"));
	System.out.println("Allegra, NULL: " + drugs.compareDrugNamesInoringNumericals("Allegra", null));
	}
}
