package mainAndSys;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import hasA.Vaccination;

public class Template_generator {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		int id = 0;
		String Name = "Internal Parasite";
		int start = 3;
		int period = 2;
			
		PetiarySys.getVacTemplate().add(new Vaccination(id,Name,start,period));
		
		id = 1;
		Name = "External Parasite";
		start = 3;
		period = 2;
			
		PetiarySys.getVacTemplate().add(new Vaccination(id,Name,start,period));
		
		id = 2;
		Name = "Mixed";
		start = 6;
		period = 12;
			
		PetiarySys.getVacTemplate().add(new Vaccination(id,Name,start,period));
		
		id = 3;
		Name = "Rabies";
		start = 4;
		period = 12;
			
		PetiarySys.getVacTemplate().add(new Vaccination(id,Name,start,period));
		
		id = 4;
		Name = "Leukemia";
		start = 12;
		period = 12;
			
		PetiarySys.getVacTemplate().add(new Vaccination(id,Name,start,period));
		
		
		for(Vaccination temp : PetiarySys.getVacTemplate()) {
			System.out.println(temp.toString());
			
		}
		PetiarySys.writeTemplate();
	}

}
