package mainAndSys;

import java.util.Calendar;

public class PetiaryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetiarySys.addCat(111,"tekir", "mahmut", Calendar.getInstance(), "", null, 10);
		PetiarySys.searchPet("111").calcNextCheckup();
		System.out.println(PetiarySys.displayPet());
		
		PetiarySys.addVet("ahmet", "çanakkale", "", null)
		
	}

}
