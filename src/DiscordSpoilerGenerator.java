import java.util.Scanner;

public class DiscordSpoilerGenerator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String originalText = in.nextLine();
		StringBuilder newText = new StringBuilder();
		for (char i : originalText.toCharArray()) {
			newText.append("||");
			newText.append(i);
			newText.append("||");
		}
		System.out.println(newText);
	}
}
