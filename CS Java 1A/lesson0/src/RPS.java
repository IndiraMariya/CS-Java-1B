import java.util.Scanner;

public class RPS {
	public static void main(String[] args) {
		int playerNumber;
		String playerChoice1;
		int playerResponse1 = 0;
		String playerChoice2;
		int playerResponse2 = 0;

		// initialize Scanner
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\\n");

		System.out.println("Would you like to play with 2 players or 1 player?");
		playerNumber = input.nextInt();
		System.out.println("Please choose Rock, Paper, or Scissors: ");
		playerChoice1 = input.next();
		playerResponse1 = translateChoice(playerChoice1);
		System.out.println(playerResponse1);

		if (playerNumber == 1) {
			playerResponse2 = (int)(Math.random()*3)+1;
		}

		if (playerNumber == 2){
			System.out.println("Please choose Rock, Paper, or Scissors: ");
			playerChoice2 = input.next();
			playerResponse2 = translateChoice(playerChoice2);
		}

		if (playerResponse1 == playerResponse2){
			System.out.println("The game is a Tie!");
			System.out.println("Both players chose: " + detranslateChoice(playerResponse1));
		}

		switch (playerResponse1) {
			case 1:
				switch (playerResponse2){
					case 2:
						System.out.println("PLayer 1 chose:" +detranslateChoice(playerResponse1));
						System.out.println("PLayer 2 chose:" +detranslateChoice(playerResponse2));
						System.out.println("Player 2 Wins!");
						break;
					case 3:
						System.out.println("PLayer 1 chose:" +detranslateChoice(playerResponse1));
						System.out.println("PLayer 2 chose:" +detranslateChoice(playerResponse2));
						System.out.println("Player 1 Wins!");
						break;
				}
				break;
			case 2:
				switch (playerResponse2){
					case 1:
						System.out.println("PLayer 1 chose:" +detranslateChoice(playerResponse1));
						System.out.println("PLayer 2 chose:" +detranslateChoice(playerResponse2));
						System.out.println("Player 1 Wins!");
						break;
					case 3:
						System.out.println("PLayer 1 chose:" +detranslateChoice(playerResponse1));
						System.out.println("PLayer 2 chose:" +detranslateChoice(playerResponse2));
						System.out.println("Player 2 Wins!");
						break;
				}
				break;
			case 3:
				switch (playerResponse2){
					case 1:
						System.out.println("PLayer 1 chose:" +detranslateChoice(playerResponse1));
						System.out.println("PLayer 2 chose:" +detranslateChoice(playerResponse2));
						System.out.println("Player 2 Wins!");
						break;
					case 2:
						System.out.println("PLayer 1 chose:" +detranslateChoice(playerResponse1));
						System.out.println("PLayer 2 chose:" +detranslateChoice(playerResponse2));
						System.out.println("Player 2 Wins!");
						break;
				}
				break;
		}
	}


	public static int translateChoice(String playerChoice) {
		int playerResponse = 0;
		if (playerChoice.equals("rock")) playerResponse = 1;
		if (playerChoice.equals("paper")) playerResponse = 2;
		if (playerChoice.equals("scissors")) playerResponse = 2;

		return playerResponse;
	}

	public static String detranslateChoice(int playerResponse) {
		String playerChoice = "";

		if (playerResponse == 1) playerChoice = "rock";
		if (playerResponse == 2) playerChoice = "paper";
		if (playerResponse == 3) playerChoice = "scissors";

		return playerChoice;
	}
}

//System.out.println("");