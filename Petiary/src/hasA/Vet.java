package hasA;

public class Vet {

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

	public boolean isOpenDays(int index) {
		return OpenDays[index];
	}


	public void setOpenDays(int index, boolean openDays) {
		OpenDays[index] = openDays;
	}


	@Override
	public String toString() {
		return "Vet"
				+"\nName= " + name 
				+ "\nAddress= " + Address
				+ "\nPhone Number= " + PhoneNumber 
				+ "\nOpen Days= " + OpenDays;
	}
	
	
	
	
	}
	
	
	

