import java.util.Scanner;

public class RMSAssistant {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String userInput = in.nextLine();
		String[] cords = userInput.split(" ");
		for (int i = 0; i < cords.length; ++i) {
			System.out.println("{LMouse down (" + cords[i++] + "," + cords[i] + ")}");
		}
		
		/*while (!userInput.equalsIgnoreCase("quit")) {
			String[] cords = userInput.split(" ");
			System.out.println("{LMouse down (" + cords[0] + "," + cords[1] + ")}");
			userInput = in.nextLine();
		}*/
	}
}
