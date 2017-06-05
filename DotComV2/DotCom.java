package DotComV2;

import java.util.*;

public class DotCom {
	private ArrayList locationCells;
	private String name;

	public void setLocationCells(ArrayList loc) {
		locationCells = loc;
	}

	public void setName(String n) {
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList getLocationCells(){
		return locationCells;
	}

	public String checkYourself(String userInput) {
		String status = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) {
				status = "kill";
				System.out.println("Ouch! you sunk " + name + " : (");
			} else {
				status = "hit";
			}
		} // close if
		return status;
	}// close method

}// close class
