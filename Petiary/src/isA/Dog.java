package isA;

import java.util.Calendar;
import hasA.*;

public class Dog extends Pet {
	
		String dogSize;

		public Dog(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight, String dogSize) {
			super(id, name, breed, bDate, illness, vet, weight);
			this.dogSize = dogSize;
		}

		@Override
		public String toString() {
			return  "Dog Information:\n\nId: " + id 
					+ "\nName: " + name 
					+ "\nBreed: " + breed 
					+ "\nIllness: " + illness
					+ "\nBirth date: " + sdf.format(bDate.getTime())
					+ "\nWeight: " + weight
					+ "\nDog Size: " + dogSize
					+ "\nHealth: " + (isHealthy() ? "Healthy" : "Unhealthy")
					+ "\nNext checkup -> " + sdf.format(checkup.getTime())
					+ "\nVeterinary: " + vet.getName();
		}
		
		
		public boolean checkWeight() {
			if(dogSize.equalsIgnoreCase("small") && weight>4&&weight<10) {
				return true;
			}
			else if(dogSize.equalsIgnoreCase("middle") && weight>10&&weight<25) {
				return true;
			}
			else if(dogSize.equalsIgnoreCase("big") && weight>25&&weight<40){
				return true;
			}
			else {
				return false;
			}
		}

	
		
		@Override
		public boolean isHealthy() {
			if(illness.isBlank() && checkWeight())
				return true;
			else
				return false;
		}

	

}
