import java.util.Arrays;

public class LevelUpThresholds {
	public static void main(String[] args) {
		int[] thresholds = new int[100];
		int increment = 5;
		
		for (int i = 1; i < 100; ++i) {
			thresholds[i] = thresholds[i - 1] + increment++;
		}
		
		System.out.println(Arrays.toString(thresholds));
	}
}
