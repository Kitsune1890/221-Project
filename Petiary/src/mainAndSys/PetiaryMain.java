package mainAndSys;

import java.util.ArrayList;
import java.util.Calendar;

import GUI.MainFrame;
import hasA.*;

public class PetiaryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PetiarySys.readFromFile();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainFrame mf = new MainFrame();
		mf.setVisible(true); //push plss
	}

}
