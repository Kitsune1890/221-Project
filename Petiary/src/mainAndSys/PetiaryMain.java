package mainAndSys;

import java.util.ArrayList;
import java.util.Calendar;
import hasA.*;

public class PetiaryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		
		/*boolean[] arr = {true, true, true, true, true, true, true};
		
		PetiarySys.addVet("haha", "ankara", "23423424", arr);
		
		PetiarySys.getVacTemplate().add(new Vaccination(111,  "fvdv",5,  2));
		PetiarySys.addCat(111,"tekir", "mahmut", Calendar.getInstance(), "", PetiarySys.searchVet("haha"), 10);
		PetiarySys.addVaccination(PetiarySys.searchPet("111"),111,Calendar.getInstance());
		System.out.println("dvsklvkl"+PetiarySys.displayVac(PetiarySys.searchPet("111")));

		PetiarySys.searchPet("111").calcNextCheckup();
		System.out.println(PetiarySys.displayPet());
		
		PetiarySys.writeIntoFile();*/
		try {
			PetiarySys.readFromFile();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(PetiarySys.displayPet());
		
		//PetiarySys.addVet("ahmet", "çanakkale", "555", new boolean[]{true,true,true,true,true,true,true});
		//
	}

}
