package isA;

import java.io.Serializable;import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import hasA.*;
import interfaces.SimpleDate;
import interfaces.WeightCheck;

public abstract class Pet implements WeightCheck ,Serializable, SimpleDate{

	protected int id;
	protected String name,
					 breed,
					 illness;
	protected Calendar bDate,
					   checkup;
	protected double weight;
	protected ArrayList<Vaccination> arr = new ArrayList();
	protected Vet vet;
	protected static int NumOfPets=0;
	
	public Pet(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.illness = illness;
		this.bDate = bDate;
		this.weight=weight;
		this.vet = vet;
		NumOfPets++;

	}

	public String getIllnes() {
		return illness;
	}

	public void setIllnes(String illness) {
		this.illness = illness;
	}

	public Calendar getCheckup() {
		return checkup;
	}

	public void setCheckup(Calendar checkup) {
		this.checkup = checkup;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vet getVet() {
		return vet;
	}

	public void setVet(Vet vet) {
		this.vet = vet;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public Calendar getbDate() {
		return bDate;
	}

	public ArrayList<Vaccination> getVac() {
		return arr;
	}

	public static int getNumOfPets() {
		return NumOfPets;
	}
	
	public int calcAge() {
		Calendar c = Calendar.getInstance();
		
		return(c.get(Calendar.YEAR)-bDate.get(Calendar.YEAR));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return id == other.id;
	}
	
	public abstract boolean isHealthy();
	
	public abstract boolean checkWeight();
	
	public void calcNextCheckup() {
		//int dayOfWeek;
		if(checkup == null) {
			checkup = Calendar.getInstance();
			checkup.add(Calendar.MONTH, 2);
		}
		else {
			if(isHealthy()) {
				checkup.add(Calendar.MONTH, 3);
			}
			else {
				checkup.add(Calendar.MONTH, 2);
			}
		}
		
		while(!vet.isOpen(checkup)) {
			checkup.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
