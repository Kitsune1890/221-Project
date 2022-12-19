package mainAndSys;

import java.util.Calendar;

public class PetiaryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		
		boolean[] arr = {true, true, true, true, true, true, true};
		
		PetiarySys.addVet("haha", "ankara", "23423424", arr);
		
		
		PetiarySys.addCat(111,"tekir", "mahmut", Calendar.getInstance(), "", PetiarySys.searchVet("haha"), 10);
		PetiarySys.addVaccination(PetiarySys.searchPet("111"),45,Calendar.getInstance());
		System.out.println("dvsklvkl"+PetiarySys.displayVac(PetiarySys.searchPet("111")));

		PetiarySys.searchPet("111").calcNextCheckup();
		System.out.println(PetiarySys.displayPet());
		
		//PetiarySys.addVet("ahmet", "çanakkale", "555", new boolean[]{true,true,true,true,true,true,true});
		//
	}

}
