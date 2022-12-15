package isA;

import java.util.ArrayList;
import java.util.Calendar;
import hasA.*;

public abstract class Pet implements WeightCheck{
	protected int id;
	protected String name,
					 breed,
					 illness;
	protected Calendar bDate,
					   checkup=Calendar.getInstance();;
	protected double weight;
	protected ArrayList<Vaccination> arr=new ArrayList();
	protected Vet vet;
	protected static int NumOfPets=0;
	
	public Pet(int id, String name, String breed, Calendar bDate, String illness, Vet vet,double weight) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.illness = illness;
		this.bDate = bDate;
		this.weight=weight;
		this.arr = arr;
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

	public ArrayList<Vaccination> getArr() {
		return arr;
	}

	public static int getNumOfPets() {
		return NumOfPets;
	}
	
	public int calcAge() {
		Calendar c = Calendar.getInstance();
		
		return(c.get(Calendar.YEAR)-bDate.get(Calendar.YEAR));
	}
	
	public boolean isHealthy() {
		if(illness.isBlank())
			return true;
		else 
			return false;
	}
	
	public abstract void checkWeight();
	
	//şu anki tarihten iki ay sonra diye ayarlıyorum. Olmazsa sonra düzeltirim
	public void calcNextCheckup() {
		Calendar c = Calendar.getInstance();
		checkup.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH)+2,c.get(Calendar.DAY_OF_MONTH));
	}
}
