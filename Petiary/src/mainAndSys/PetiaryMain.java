package mainAndSys;

import java.util.Calendar;

public class PetiaryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		Calendar s = Calendar.getInstance();
		s.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH)+2,c.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(s.get(Calendar.YEAR)+" "+s.get(Calendar.MONTH)+" "+s.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.YEAR)+" "+c.get(Calendar.MONTH)+" "+c.get(Calendar.DAY_OF_MONTH));
	}

}
