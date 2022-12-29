package hasA;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class Vet implements Serializable{

	private String name;
	private  String Address;
	private String PhoneNumber;
	private boolean[] OpenDays;
	
	
	public Vet(String name, String address, String phoneNumber, boolean[] openDays) {
		
		this.name = name;
		this.Address = address;
		this.PhoneNumber = phoneNumber;
		this.OpenDays = openDays;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	/* parameter olarak index girdim baska turlu yapmamız gerekiyorsa duzeltirim */

	public boolean isOpen(Calendar day) {
		return OpenDays[day.DAY_OF_WEEK - 1];
	}


	public void setOpenDays(int index, boolean openDays) {
		OpenDays[index] = openDays;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vet other = (Vet) obj;
		return Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Vet"
				+"\nName: " + name 
				+ "\nAddress: " + Address
				+ "\nPhone Number: " + PhoneNumber 
				+ "\nOpen Days:\n"
				+ "Mon: " + (OpenDays[0] ? "Open\n" : "Close\n")
				+ "Tue: " + (OpenDays[1] ? "Open\n" : "Close\n")
				+ "Wed: " + (OpenDays[2] ? "Open\n" : "Close\n")
				+ "Thu: " + (OpenDays[3] ? "Open\n" : "Close\n")
				+ "Fri: " + (OpenDays[4] ? "Open\n" : "Close\n")
				+ "Sat: " + (OpenDays[5] ? "Open\n" : "Close\n")
				+ "Sun: " + (OpenDays[6] ? "Open\n" : "Close\n");
	}
	
	
	
	
	}
	
	
	

