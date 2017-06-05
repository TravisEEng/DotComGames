
public class SimpleDotCom {

	int[] locationCells;
	int numOfHits = 0;

	String checkYourself(String strGuess) {

		int intGuess = Integer.parseInt(strGuess);

		String result = "miss";

		for (int i = 0; i < locationCells.length; i++) {

			if (intGuess == locationCells[i]) {
				result = "hit";

				numOfHits++;

				break;
			} // end if

		} // end for

		if (numOfHits == locationCells.length) {

			result = "kill";
		} // end if

		System.out.println(result);

		return result;
	}// end method

	void setLocationCells(int[] locs) {
		locationCells = locs;
	}
}
