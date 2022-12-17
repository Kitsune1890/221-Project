package mainAndSys;

import java.util.ArrayList;
import java.util.Calendar;
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
	private static String img;
	private static String saveFileLocation;
	private static ArrayList<Vaccination> vacTemplate;
	
	public static boolean addCat(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight) {
		Pet p = new Cat(id, name, breed, bDate, illness, vet, weight);
		if(pets.add(p)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean addDog(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight, String dogSize) {
		Pet p = new Dog(id, name, breed, bDate, illness, vet, weight, dogSize);
		if(pets.add(p)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean addVatination(int pet, int vacId, Calendar date) {
		
	}
}
