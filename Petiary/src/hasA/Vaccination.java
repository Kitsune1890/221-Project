package hasA;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;

import java.util.Calendar;

import interfaces.SimpleDate;
import mainAndSys.PetiarySys;

public class Vaccination implements Serializable, SimpleDate{

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
		if(vactinationDates.size() == 0 && date.compareTo(Calendar.getInstance()) <= 0) {
			vactinationDates.add(date);
			return true;
		}
		else if(vactinationDates.get(vactinationDates.size()-1).compareTo(date) < 0 && date.compareTo(Calendar.getInstance()) <= 0) {
			vactinationDates.add(date);
			return true;
		}
		else return false;
			
	}
	
	//calculates next vaccination date
	public String calcVacDate(Calendar bDate) {
		Calendar newDate = null;
		Calendar sysdate = Calendar.getInstance();
		double days = (double) Duration.between(bDate.toInstant(), sysdate.toInstant()).toDays();
		int months = (int) days / 30;
		
		if(months > StartMonth) {
			if(vactinationDates.size() != 0) {
				newDate = (Calendar) vactinationDates.get(vactinationDates.size()-1).clone();
				newDate.add(Calendar.MONTH, vacPeriod);
				days = (double) Duration.between(sysdate.toInstant(), newDate.toInstant()).toDays();
				months = (int) (days/30);
				
				System.out.println(days);
				System.out.println(months);
				
				if(months <= 0 || months > vacPeriod)
					return "You should go to vet to Vaccination of your pet";
				else {
					newDate = (Calendar) vactinationDates.get(vactinationDates.size()-1).clone();
					newDate.add(Calendar.MONTH, vacPeriod);
					return "There is " + months + " to vaccination.\nYour recomended vaccination date is " + sdf.format(newDate.getTime());  		
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
			str += "\n\t" + sdf.format(temp.getTime());
		}
		return "Vactination"
				+ "\nName= " + Name 
				+ "\nStart Month= " + StartMonth 
				+ "\nVactination Period= " + vacPeriod
				+ "\nVactination Dates= " + str + "\n";
	}
	
	
	
	
	
	
}
