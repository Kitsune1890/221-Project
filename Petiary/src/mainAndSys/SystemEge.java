package mainAndSys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;

import hasA.Vaccination;
import hasA.Vet;
import isA.Pet;

public class SystemEge {
	private static HashSet<Pet> pets = new HashSet<Pet>();
	private static HashSet<Vet> vets = new HashSet<Vet>();
	private static ArrayList<Vaccination> template = new ArrayList<Vaccination>();
	private final static String PetSave = "petSave.bin", VetSave = "vetSave.bin", templateVac = "template.bin";
	
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
	public static String display(Pet pet) {
		String str = "";
		for(Vaccination temp : pet.getArr()) {
			str += temp.toString();
		}
		return str;
	}
	
	public static Pet searchPet(String id) {
		int Id = Integer.parseInt(id);
		
		for(Pet temp : pets) {
			if(temp.getId() == Id)
				return temp;
		}
		
		return null;
	}
	
	public static Vet searchVet(String name) {
		for(Vet temp: vets) {
			if(temp.getName().equals(name))
				return temp;
		}
		return null;
	}
	
	public static boolean readFromFile() throws ClassNotFoundException {
		try {
			ObjectInputStream POS = new ObjectInputStream(new FileInputStream(PetSave));
			ObjectInputStream VOS = new ObjectInputStream(new FileInputStream(VetSave));
			ObjectInputStream TOS = new ObjectInputStream(new FileInputStream(templateVac));
			
			pets.addAll((HashSet<Pet>)POS.readObject());
			vets.addAll((HashSet<Vet>)POS.readObject());
			template.addAll((ArrayList<Vaccination>)POS.readObject());
			
			POS.close();
			VOS.close();
			TOS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
