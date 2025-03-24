import java.util.Scanner;

public class ScannerTests {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String userInputStr = "";
		int userInputInt = 0;
		double userInputDbl = 0.;
		
		System.out.print("int > ");
		userInputInt = in.nextInt();
		in.nextLine();
		System.out.print("str > ");
		userInputStr = in.nextLine();
		System.out.print("dbl > ");
		userInputDbl = in.nextDouble();
		System.out.println();
		System.out.printf("%s, %d, %f", userInputStr, userInputInt, userInputDbl);
	}
}
