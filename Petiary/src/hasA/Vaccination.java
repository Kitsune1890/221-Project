package hasA;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;

import java.util.Calendar;

import mainAndSys.PetiarySys;

public class Vaccination implements Serializable{

	private int id;
	private String Name;
	private int StartMonth;// min age to be vaccinated
	private int vacPeriod; //in months
	public ArrayList<Calendar> vactinationDates;
	
	
	public Vaccination(int id, String name, int startMonth, int vacPeriod) {
		super();
		this.id = id;
		this.Name = name;
		this.StartMonth = startMonth;
		this.vacPeriod = vacPeriod;
		this. vactinationDates =  new ArrayList<Calendar>();
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
	
	public boolean addVacDate(Calendar date) {
		vactinationDates.add(date);
		return true;
	}
	
	//calculates next vaccination date
	public String calcVacDate(Calendar bDate) {
		Calendar newDate = null;
		Calendar sysdate = Calendar.getInstance();
		double days = (double) Duration.between(sysdate.toInstant(), bDate.toInstant()).toDays();
		int months = (int) days / 30;
		
		if(months > StartMonth) {
			if(vactinationDates.size() != 0) {
				days = (double) Duration.between(sysdate.toInstant(), vactinationDates.get(vactinationDates.size()-1).toInstant()).toDays();
				months = (int) days/30;
				if(months < 0)
					return "You should go to vet to Vaccination of your pet";
				else {
					newDate = (Calendar) vactinationDates.get(vactinationDates.size()-1).clone();
					newDate.add(Calendar.MONTH, months);
					return "There is " + months + " to vaccination. Your recomended vaccination date is " + PetiarySys.getSdf().format(newDate.getTime());  		
				}
					
			}else
				return "There is no date records";
		}else {
			return "Your pet is too young for this vaccine";
		}
		
		/*
		
		if (vactinationDates.size() == 0) {
			if(months < StartMonth) {
				newDate = (Calendar) bDate.clone();
				newDate.add(Calendar.MONTH, StartMonth);
			}
			else {
				newDate = (Calendar) Calendar.getInstance();
			}
		}		
		else {
			newDate = vactinationDates.get(vactinationDates.size() - 1);
			newDate.add(Calendar.MONTH, vacPeriod);
		}
		return newDate;*/
		
	}

	@Override
	public String toString() {
		String str = "";
		for(Calendar temp : vactinationDates) {
			str += "\n\t" + PetiarySys.getSdf().format(temp.getTime());
		}
		return "Vactination"
				+ "\nName= " + Name 
				+ "\nStart Month= " + StartMonth 
				+ "\nVactination Period= " + vacPeriod
				+ "\nVactination Dates= " + str;
	}
	
	
	
	
	
	
}
