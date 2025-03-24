import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchAlgorithms {
	public static void main(String[] args) {
		int[][] allTests = new int[100][];
		
		int i, j, k;
		for (i = 0; i < 100; ++i) {
			allTests[i] = new int[i + 1];
			k = 1;
			for (j = 0; j <= i; ++j) {
				allTests[i][j] = k;
				k += 2;
			}
		}
		
		int[] testResults = new int[4];
		
		for (int[] subTest : allTests) {
			for (int indiv : subTest) {
				int index = linearSearchIterative(subTest, indiv - 1);
				if (linearSearchRecursive(subTest, indiv - 1) == index)
					++testResults[0];
				if (linearSearchRecursive(subTest, subTest.length, indiv - 1) == index)
					++testResults[1];
				if (binarySearchIterative(subTest, indiv - 1) == index)
					++testResults[2];
				if (binarySearchRecursive(subTest, indiv - 1, 0, subTest.length - 1) == index)
					++testResults[3];
			}
		}
		
		for (int result : testResults) {
			System.out.print(result + " ");
		}
		System.out.println();
		
		Random rg = new Random();
		Scanner in = new Scanner(System.in);
		int key;
		int[] sequence = new int[10];
		
		sequence[0] = rg.nextInt(10);
		for (i = 1; i < 10; ++i)
			sequence[i] = rg.nextInt(sequence[i - 1] + 1, sequence[i - 1] + 5);
		
		System.out.println("Sequence: " + Arrays.toString(sequence));
		System.out.print("Number to find: ");
		key = in.nextInt();
		
		int result_1 = linearSearchIterative(sequence, key);
		System.out.println("LSI: " + result_1);
		
		int result_2 = linearSearchRecursive(sequence, key);
		System.out.println("LSR: " + result_2);
		
		int result_3 = linearSearchRecursive(sequence, sequence.length, key);
		System.out.println("LSR2: " + result_3);
		
		int result_4 = binarySearchIterative(sequence, key);
		System.out.println("BSI: " + result_4);
		
		int result_5 = binarySearchRecursive(sequence, key, 0, sequence.length - 1);
		System.out.println("BSR: " + result_5);
	}
	
	static int linearSearchIterative(int[] array, int key) {
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	static int linearSearchRecursive(int[] array, int key) {
		int n = array.length - 1;
		if (array[n] == key)
			return n;
		else if (n == 0)
			return -1;
		else
			return linearSearchRecursive(Arrays.copyOfRange(array, 0, n), key);
	}
	
	static int linearSearchRecursive(int[] array, int n, int key) {
		int m = n - 1;
		if (array[m] == key)
			return m;
		else if (m == 0)
			return -1;
		else
			return linearSearchRecursive(array, m, key);
	}
	
	static int binarySearchIterative(int[] array, int key) {
		int start = 0, end = array.length - 1, mid;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (key == array[mid])
				return mid;
			else if (key > array[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		return -1;
	}
	
	static int binarySearchRecursive(int[] array, int key, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			
			if (key == array[mid])
				return mid;
			else if (key > array[mid])
				return binarySearchRecursive(array, key, mid + 1, end);
			else
				return binarySearchRecursive(array, key, start, mid - 1);
		}
		return -1;
	}
}
