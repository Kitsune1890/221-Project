package mainAndSys;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import hasA.Vaccination;

public class Template_generator {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("ID");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Name");
			String Name = sc.nextLine();
			System.out.println("Start");
			int start = sc.nextInt();
			sc.nextLine();
			System.out.println("period");
			int period = sc.nextInt();
			sc.hasNextLine();
			
			PetiarySys.getVacTemplate().add(new Vaccination(id,Name,start,period));
			
			System.out.println("\n\n\n");
		}
		
		for(Vaccination temp : PetiarySys.getVacTemplate()) {
			System.out.println(temp.toString());
			
		}
		PetiarySys.writeTemplate();
	}

}