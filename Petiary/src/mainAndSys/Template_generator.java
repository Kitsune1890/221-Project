package mainAndSys;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;

import hasA.Vaccination;
import hasA.Vet;
import isA.Cat;
import isA.Dog;
import isA.Pet;

public class Template_generator {
	private final static String PetSave = "petSave.bin", VetSave = "vetSave.bin", templateVacSave = "template.bin";
	private static HashSet<Pet> pets = new HashSet<Pet>();
	private static HashSet<Vet> vets = new HashSet<Vet>();
	private static ArrayList<Vaccination> vacTemplate = new ArrayList<Vaccination>();
	
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

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		
		int id = 0;
		String Name = "Internal Parasite";
		int start = 3;
		int period = 2;
			
		vacTemplate.add(new Vaccination(id,Name,start,period));
		
		id = 1;
		Name = "External Parasite";
		start = 3;
		period = 2;
			
		vacTemplate.add(new Vaccination(id,Name,start,period));
		
		id = 2;
		Name = "Mixed";
		start = 6;
		period = 12;
			
		vacTemplate.add(new Vaccination(id,Name,start,period));
		
		id = 3;
		Name = "Rabies";
		start = 4;
		period = 12;
			
		vacTemplate.add(new Vaccination(id,Name,start,period));
		
		id = 4;
		Name = "Leukemia";
		start = 12;
		period = 12;
			
		vacTemplate.add(new Vaccination(id,Name,start,period));
		
		
		for(Vaccination temp : vacTemplate) {
			System.out.println(temp.toString());
			
		}
		writeTemplate();
		
		boolean[] arr = {true, true, true, true, true, false, false};
		
		Vet v = new Vet("Bilgi Vet", "Üniversiteliler Mah. Çankaya/Ankara", "312-290-1111", arr);
		
		Calendar c = new Calendar.Builder().setCalendarType("iso8601").setDate(2022, 5, 3).build();	
		
		Cat p = new Cat(1001, "Gojo", "British Shorthair", c, "", v, 3);
		
		System.out.println(p.toString());
		
		pets.add(p);
		vets.add(v);
		
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
