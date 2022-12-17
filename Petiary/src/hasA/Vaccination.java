package hasA;
import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;

import java.util.Calendar;

public class Vaccination implements Serializable{

	private int id;
	private String Name;
	private int StartMonth;
	private int vacPeriod;
	public ArrayList<Calendar> vactinationDates = new ArrayList<>();
	
	
	public Vaccination(int id, String name, int startMonth, int vacPeriod) {
		super();
		this.id = id;
		this.Name = name;
		this.StartMonth = startMonth;
		this.vacPeriod = vacPeriod;
	}


	public Vaccination(int id, String name, int startMonth, int vacPeriod, ArrayList<Calendar> vactinationDates) {
		super();
		this.id = id;
		this.Name = name;
		this.StartMonth = startMonth;
		this.vacPeriod = vacPeriod;
		this.vactinationDates = vactinationDates;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	/* 
	 * this one is unnecesarry
	 * 
	public void setVactinationDates(ArrayList<Calendar> vactinationDates) {
		this.vactinationDates = vactinationDates;
	}*/
	
	public boolean addVacDate(Calendar date) {
		vactinationDates.add(date);
		return true;
	}
	
	//calculates next vaccination date
	public String calcVacDate(Calendar bDate) {
		Calendar sysdate = Calendar.getInstance();
		double days = (double) Duration.between(sysdate.toInstant(), bDate.toInstant()).toDays();
		int months = days
		if() {
			
		}
		return null;
	}

	@Override
	public String toString() {
		return "Vactination"
				+ "\nName= " + Name 
				+ "\nStart Month= " + StartMonth 
				+ "\nVactination Period= " + vacPeriod
				+ "\nVactination Dates= " + vactinationDates;
	}
	
	
	
	
	
	
}
