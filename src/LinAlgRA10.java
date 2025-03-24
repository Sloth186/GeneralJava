import java.util.Arrays;
import java.util.Scanner;

public class LinAlgRA10 {
	public static void main(String[] args) {
		final double[][] A = {{0.5, 0.3}, {0.5, 0.7}};
		double[] x0 = {0.1, 0.9};
		System.out.print(Arrays.toString(x0));
		double[] x1 = {0, 0};
		Scanner in = new Scanner(System.in);
		String userInput = in.nextLine();
		
		while(!userInput.equalsIgnoreCase("quit")) {
			x1[0] = x0[0]*A[0][0] + x0[1]*A[0][1];
			x1[1] = x0[0]*A[1][0] + x0[1]*A[1][1];
			x0[0] = x1[0];
			x0[1] = x1[1];
			System.out.print(Arrays.toString(x0));
			userInput = in.nextLine();
		}
	}
}
