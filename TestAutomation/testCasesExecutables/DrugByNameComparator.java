package testCaseExecutables;
import java.io.Serializable;
import java.util.Comparator;

public class DrugByNameComparator{
	private static final long serialVersionUID = 1L;

	public int compareDrugNamesInoringNumericals(String d1, String d2){
		String firstDrugName = remove(d1);
		String secondDrugName = remove(d2);

		return firstDrugName.compareToIgnoreCase(secondDrugName);
	}

	public String remove(String drugName){
		return drugName.replaceAll("[^a-zA-Z]", "");
	}
}
