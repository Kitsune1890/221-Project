package interfaces;

import java.text.SimpleDateFormat;

public interface WeightCheck {
	final static SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
	public boolean checkWeight();
	
}