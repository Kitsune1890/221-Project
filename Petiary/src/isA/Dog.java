package isA;

import java.util.Calendar;
import hasA.*;

public class Dog extends Pet {
	
		String dogSize;

		public Dog(int id, String name, String breed, Calendar bDate, String illness, Vet vet, double weight) {
			super(id, name, breed, bDate, illness, vet, weight);
		}

		@Override
		public String toString() {
			return  "id=" + id + 
					"\nname=" + name 
					+ "\nbreed=" + breed 
					+ "\nillness=" + illness
					+ "\nbirth date:" + bDate.get(Calendar.DAY_OF_MONTH)+"."+ bDate.get(Calendar.MONTH)+"."+bDate.get(Calendar.YEAR)
					+ "\nNext checkup=" + checkup.get(Calendar.DAY_OF_MONTH)+"."+ checkup.get(Calendar.MONTH)+"."+checkup.get(Calendar.YEAR) 
					+ "\nweight=" + weight
					+"\ncatSize=" + dogSize; 
		}
		
		//değerler biraz rastgele oldu :)
		public void checkWeight() {
			if(weight>8 && weight<=11)
				dogSize="weak";
			else if(weight<=20)
				dogSize="normal";
			else if(weight<26)
				dogSize="oversized";
			else if(weight<35)
				dogSize="obese";
		}

	

}
