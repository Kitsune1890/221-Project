package mainAndSys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import hasA.Vaccination;
import hasA.Vet;
import isA.Cat;
import isA.Dog;
import isA.Pet;

public class PetiarySys {
	private static HashSet<Pet> pets = new HashSet<Pet>();
	private static HashSet<Vet> vets = new HashSet<Vet>();
	private static ArrayList<Vaccination> vacTemplate = new ArrayList<Vaccination>();
	private final static String PetSave = "petSave.bin", VetSave = "vetSave.bin", templateVacSave = "template.bin";
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	
	public static boolean addCat(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight) {
		Pet p = new Cat(id, name, breed, bDate, illness, vet, weight);
		//p.calcNextCheckup();
		if(pets.add(p)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static HashSet<Pet> getPets() {
		return pets;
	}

	public static HashSet<Vet> getVets() {
		return vets;
	}

	public static ArrayList<Vaccination> getVacTemplate() {
		return vacTemplate;
	}

	public static int getVacTemplateIndex(String name) {
		for (int i = 0; i < vacTemplate.size(); i++) {
			if(vacTemplate.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public static String getTemplateVacSave() {
		return templateVacSave;
	}



	public static boolean addDog(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight, String dogSize) {
		Pet p = new Dog(id, name, breed, bDate, illness, vet, weight, dogSize);
		//p.calcNextCheckup();
		if(pets.add(p)) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean addVaccination(Pet pet, int vacId, Calendar date) {
		for (int i = 0; i < pet.getVac().size(); i++) {
			Vaccination v = pet.getVac().get(i);
			if(v.getId() == vacId) {
				v.addVacDate(date);
				return true;
			}
		}
		
		for (int i = 0; i < vacTemplate.size(); i++) {
			if(vacTemplate.get(i).getId() == vacId) {
				Vaccination v = vacTemplate.get(i);
				pet.getVac().add(v);
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean addVet(String name, String address, String phoneNumber, boolean[] openDays) {
		Vet v = new Vet(name, address, phoneNumber, openDays);
		if(vets.add(v)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
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


	public static String displayVac(Pet pet) {
		String str = "";
		for(Vaccination temp : pet.getVac()) {
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
	
	public static boolean removePet(String id) {
		int Id = Integer.parseInt(id);
		
		for(Pet temp: pets) {
			if(temp.getId() == Id) {
				pets.remove(temp);
				return true;
			}
		}
		return false;
	}
	
	public static boolean removeVet(String name) {
		boolean flag = true;
		for(Vet temp: vets) {
			if(temp.getName().equals(name)) {
				for(Pet pets: pets) {
					if(pets.getVet() == temp) {
						flag = false;
					}
				}
				if(flag) {
					vets.remove(temp);
					return true;
				}
			}
		}
		return false;
	}
	
	public static String[] getVetnames()
	{
		HashSet<Vet> vetset=PetiarySys.getVets();
		String[] names=new String[vetset.size()];
		int n=0;
		for(Vet v : vetset) 
		{
			names[n]= v.getName();
			n++;
		}
		return names;
	}
	
	public static String[] getPetIds()
	{
		HashSet<Pet> petSet = PetiarySys.getPets();
		String[] ids = new String[petSet.size()];
		int i = 0;
		for(Pet p : petSet) {
			ids[i] = Integer.toString(p.getId());
			i++;
		}
		
		return ids;
	}
	
	public static String[] getVacNames() {
		String[] str = new String[5];
		int i = 0;
		for(Vaccination vac : vacTemplate) {
			str[i] = vac.getName();
			i++;
		}
		return (str);
	}
	
	public static boolean readFromFile() throws ClassNotFoundException {
		try {
			FileInputStream pf = new FileInputStream(PetSave);
			FileInputStream vf = new FileInputStream(VetSave);
			FileInputStream tf = new FileInputStream(templateVacSave);
			
			ObjectInputStream POS = new ObjectInputStream(pf);
			ObjectInputStream VOS = new ObjectInputStream(vf);
			ObjectInputStream TOS = new ObjectInputStream(tf);
			
			pets.addAll((HashSet<Pet>)POS.readObject());
			vets.addAll((HashSet<Vet>)VOS.readObject());
			vacTemplate.addAll((ArrayList<Vaccination>)TOS.readObject());
			
			pf.close();
			vf.close();
			tf.close();
			
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
	
	
	public static boolean writeIntoFile() {
		try {
			FileOutputStream pf = new FileOutputStream(PetSave);
			FileOutputStream vf = new FileOutputStream(VetSave);
			
			ObjectOutputStream POS = new ObjectOutputStream(pf);
			ObjectOutputStream VOS = new ObjectOutputStream(vf);
			
			POS.writeObject((HashSet<Pet>)pets);
			VOS.writeObject((HashSet<Vet>)vets);
			
			pf.close();
			vf.close();
			
			POS.close();
			VOS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		//
	}
	
	public static boolean writeTemplate() throws FileNotFoundException {
		
		try {
			FileOutputStream vac = new FileOutputStream(templateVacSave);
			ObjectOutputStream VAC = new ObjectOutputStream(vac);
			VAC.writeObject((ArrayList<Vaccination>)vacTemplate);
			vac.close();
			VAC.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	
	
	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static Calendar stringtoCalendar(String str) throws ParseException {
		Date date = sdf.parse(str);
        return dateToCalendar(date);
	}
	
	private static Calendar dateToCalendar(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	
	
}
