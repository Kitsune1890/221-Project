package hasA;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Calendar;

public class Vaccination implements Serializable{

	private String Name;
	private int StartMonth;
	private int vacPeriod;
	public ArrayList<Calendar> vactinationDates = new ArrayList<>();
	
	
	public Vaccination(String name, int startMonth, int vacPeriod) {
		super();
		this.Name = name;
		this.StartMonth = startMonth;
		this.vacPeriod = vacPeriod;
	}


	public Vaccination(String name, int startMonth, int vacPeriod, ArrayList<Calendar> vactinationDates) {
		super();
		this.Name = name;
		this.StartMonth = startMonth;
		this.vacPeriod = vacPeriod;
		this.vactinationDates = vactinationDates;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getStartMonth() {
		return StartMonth;
	}


	public void setStartMonth(int startMonth) {
		StartMonth = startMonth;
	}


	public int getVacPeriod() {
		return vacPeriod;
	}


	public void setVacPeriod(int vacPeriod) {
		this.vacPeriod = vacPeriod;
	}


	public ArrayList<Calendar> getVactinationDates() {
		return vactinationDates;
	}


	public void setVactinationDates(ArrayList<Calendar> vactinationDates) {
		this.vactinationDates = vactinationDates;
	}
	
	
	/* BURDA KAFAM KARISTI NAPICAM
	 
	 
	public String calcVacDate() {
		
		
	}
	
	*/


	@Override
	public String toString() {
		return "Vactination"
				+ "\nName= " + Name 
				+ "\nStart Month= " + StartMonth 
				+ "\nVactination Period= " + vacPeriod
				+ "\nVactination Dates= " + vactinationDates;
	}
	
	
	
	
	
	
}
