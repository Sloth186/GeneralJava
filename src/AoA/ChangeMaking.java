package AoA;

public class ChangeMaking {
	public static int num_coins(int cents, int[] denominations) {
		int numRows = denominations.length + 1;
		int numCols = cents + 1;
		int[][] table = new int[numRows][numCols];
		int i, j, sub = 0;
		
		for (i = 0; i < numRows; ++i)
			table[i][0] = Integer.MAX_VALUE;
		for (i = 0; i < numCols; ++i)
			table[0][i] = 0;
		
		for (i = 1; i < numCols; ++i) {
			for (j = 1; j < numRows; ++j) {
				sub += i * j;
			}
		}
		
		return sub;
	}
}