package DotComV2;

import java.util.*;

public class DotComBust {

	private GameHelper helper = new GameHelper();
	private ArrayList dotComsList = new ArrayList();
	private int numOfGuesses = 0;

	private void setUpGame() {
		// first make some dot coms and give them locations
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("Random.com");
		DotCom three = new DotCom();
		three.setName("Github.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		System.out.println("Your goal is to sink three dot coms.");

		System.out.println("Try to sink them all in the fewest number of guesses");

		for (int i = 0; i < dotComsList.size(); i++) {
			ArrayList newLocation = helper.placeDotCom(3);
			DotCom dotComToSet = (DotCom) dotComsList.get(i);
			dotComToSet.setLocationCells(newLocation);
			System.out.println(dotComToSet.getName());
			System.out.println(dotComToSet.getLocationCells());
			
			
		} // close for loop

	}// close setUpGame method

	private void startPlaying() {
		while (!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		} // close while
		finishGame();
	}// close startPlaying Method

	private void checkUserGuess(String userGuess) {
		numOfGuesses++;

		String result = "miss";

		for (int i = 0; i < dotComsList.size(); i++) {
			DotCom dotComToTest = (DotCom) dotComsList.get(i);
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				dotComsList.remove(i);
				break;
			}

		} // close for
		System.out.println(result);
	}// close method

	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options");

		}
	}// close method

	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}// close method

}
