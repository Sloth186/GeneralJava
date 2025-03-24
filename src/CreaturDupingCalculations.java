import java.util.Scanner;

public class CreaturDupingCalculations {
	public static void main(String[] args) {
		long player1 = 130000;
		int deaths1 = 0;
		long player2 = 130000;
		int deaths2 = 0;
		int turn = 0;
		Scanner in = new Scanner(System.in);
		String userInput;
		
		do {
			System.out.println("Player 1 has mass " + player1 + " and " + deaths1 + " deaths");
			System.out.println("Player 2 has mass " + player2 + " and " + deaths2 + " deaths");
			if (turn == 0) {
				player1 += player2;
				player2 /= 2;
				++deaths2;
				System.out.println("Player 1 eats Player 2");
				turn = 1;
			} else {
				player2 += player1;
				player1 /= 2;
				++deaths1;
				System.out.println("Player 2 eats Player 1");
				turn = 0;
			}
			userInput = in.nextLine();
		} while (!userInput.equalsIgnoreCase("quit"));
	}
}
