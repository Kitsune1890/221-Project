package mainAndSys;

import java.util.HashSet;

import hasA.Vet;
import isA.Pet;

public class SystemEge {
	private static HashSet<Pet> pets = new HashSet<Pet>();
	private static HashSet<Vet> vets = new HashSet<Vet>();
	
	public static String displayPet() {
		String str = "";
		for(Pet temp : pets) {
			str += temp.toString();
		}
		return str;
	}
	
	public static String displayVet() {
		String str = "";
		for(Vet temp : vets) {
			str += temp.toString();
		}
		return str;
	}
	
	public static String displayVac() {
		String str = "";
		for(Pet temp : pets) {
			str += temp.toString();
		}
		return str;
	}
}
