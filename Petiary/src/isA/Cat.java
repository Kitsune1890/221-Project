package isA;

import java.util.Calendar;
import hasA.*;

public class Cat extends Pet{

	public Cat(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight) {
		super(id, name, breed, bDate, illness, vet, weight);
	}

	@Override
	public String toString() {
		return  "Cat Information:\n\nId: " + id
				+ "\nName: " + name 
				+ "\nBreed: " + breed 
				+ "\nIllness: " + illness
				+ "\nBirth date: " + sdf.format(bDate.getTime())
				+ "\nWeight: " + weight
				+ "\nHealth: " + (isHealthy() ? "Healthy" : "Unhealthy")
				+ "\nNext checkup -> " + sdf.format(checkup.getTime()) 
				+ "\nVeterinary: "+vet.getName();
				
		
		
		
	}
	
	
	public boolean checkWeight() {
		if(weight>0 && weight<=4)
		    return true;
		else 
			return false;
	}

	@Override
	public boolean isHealthy() {
		// TODO Auto-generated method stub
		if(illness.isBlank() && checkWeight())
			return true;
		else
			return false;
	}

	
	
	
}
