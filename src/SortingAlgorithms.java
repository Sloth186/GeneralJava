import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
	public static void main(String[] args) {
		Random rg = new Random();
		int[][] allTests1 = new int[100][];
		int[][] allTests2 = new int[100][];
		int[][] allTests3 = new int[100][];
		int[][] allTests4 = new int[100][];
		int[][] allTests5 = new int[100][];
		int[][] allTests6 = new int[100][];
		int[][] allTests7 = new int[100][];
		int[][] allTests8 = new int[100][];
		int[][] allTests9 = new int[100][];
		
		for (int i = 0; i < allTests1.length; ++i) {
			allTests1[i] = new int[i + 1];
			allTests2[i] = new int[i + 1];
			allTests3[i] = new int[i + 1];
			allTests4[i] = new int[i + 1];
			allTests5[i] = new int[i + 1];
			allTests6[i] = new int[i + 1];
			allTests7[i] = new int[i + 1];
			allTests8[i] = new int[i + 1];
			allTests9[i] = new int[i + 1];
			for (int j = 0; j < i + 1; ++j) {
				allTests1[i][j] = rg.nextInt(0, 100);
				allTests2[i][j] = allTests1[i][j];
				allTests3[i][j] = allTests1[i][j];
				allTests4[i][j] = allTests1[i][j];
				allTests5[i][j] = allTests1[i][j];
				allTests6[i][j] = allTests1[i][j];
				allTests7[i][j] = allTests1[i][j];
				allTests8[i][j] = allTests1[i][j];
				allTests9[i][j] = allTests1[i][j];
			}
		}
		
		/*System.out.println(Arrays.deepToString(allTests1));
		System.out.println(Arrays.deepToString(allTests2));*/
		
		for (int[] subTest : allTests1)
			insertionSortIterative(subTest);
		for (int[] subTest : allTests2)
			insertionSortRecursive(subTest);
		for (int[] subTest : allTests3)
			bubbleSortIterative(subTest);
		for (int[] subTest : allTests4)
			bubbleSortRecursive(subTest);
		for (int[] subTest : allTests5)
			mergeSortIterative(subTest);
		for (int[] subTest : allTests6)
			mergeSortRecursive(subTest, 0, subTest.length - 1);
		for (int[] subTest : allTests7)
			quickSortRecursive(subTest, 0, subTest.length - 1);
		for (int[] subTest : allTests8)
			selectionSortIterative(subTest);
		for (int[] subTest : allTests9)
			selectionSortRecursive(subTest);
		
	/*	System.out.println(Arrays.deepToString(allTests1));
		System.out.println(Arrays.deepToString(allTests2));*/
		
		boolean[] equalities = {true, true, true, true, true, true, true, true};
		for (int i = 0; i < allTests1.length; ++i) {
			if (!Arrays.equals(allTests1[i], allTests2[i]))
				equalities[0] = false;
			if (!Arrays.equals(allTests1[i], allTests3[i]))
				equalities[1] = false;
			if (!Arrays.equals(allTests1[i], allTests4[i]))
				equalities[2] = false;
			if (!Arrays.equals(allTests1[i], allTests5[i]))
				equalities[3] = false;
			if (!Arrays.equals(allTests1[i], allTests6[i]))
				equalities[4] = false;
			if (!Arrays.equals(allTests1[i], allTests7[i]))
				equalities[5] = false;
			if (!Arrays.equals(allTests1[i], allTests8[i]))
				equalities[6] = false;
			if (!Arrays.equals(allTests1[i], allTests9[i]))
				equalities[7] = false;
		}
		
		System.out.println(Arrays.toString(equalities));
	}
	
	static void insertionSortIterative(int[] array) {
		int i, j, temp;
		for (i = 1; i < array.length; ++i) {
			temp = array[i];
			for (j = i; j > 0 && array[j - 1] > temp; --j)
				array[j] = array[j - 1];
			array[j] = temp;
		}
	}
	
	static void insertionSortRecursive(int[] array) {
		insertionSortRecursive(array, 0);
	}
	
	static private void insertionSortRecursive(int[] array, int i) {
		int temp = array[i], j;
		for (j = i; j > 0 && array[j - 1] > temp; --j)
			array[j] = array[j - 1];
		array[j] = temp;
		
		if (i < array.length - 1)
			insertionSortRecursive(array, ++i);
	}
	
	static void bubbleSortIterative(int[] array) {
		int i, j, temp;
		for (i = array.length - 1; i > 0; --i) {
			for (j = 0; j < i; ++j) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	static void bubbleSortRecursive(int[] array) {
		bubbleSortRecursive(array, array.length - 1);
	}
	
	static private void bubbleSortRecursive(int[] array, int i) {
		if (i > 0) {
			int temp;
			for (int j = 0; j < i; ++j) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
			bubbleSortRecursive(array, i - 1);
		}
	}
	
	static private void merge(int[] array, int leftBound, int mid, int rightBound) {
		int leftArraySize = mid - leftBound + 1;
		int rightArraySize = rightBound - mid;
		
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];
		
		System.arraycopy(array, leftBound, leftArray, 0, leftArraySize);
		System.arraycopy(array, mid + 1, rightArray, 0, rightArraySize);
		
		int i = 0, j = 0, k = leftBound;
		for (; i < leftArraySize && j < rightArraySize; ++k) {
			if (leftArray[i] < rightArray[j])
				array[k] = leftArray[i++];
			else
				array[k] = rightArray[j++];
		}
		
		for (; i < leftArraySize; ++i)
			array[k++] = leftArray[i];
		for (; j < rightArraySize; ++j)
			array[k++] = rightArray[j];
	}
	
	static void mergeSortIterative(int[] array) {
		final int ARRAY_END = array.length - 1;
		int leftStart, mid, rightEnd;
		for (int currentSize = 1; currentSize < array.length; currentSize *= 2) {
			for (leftStart = 0; leftStart < ARRAY_END; leftStart += currentSize * 2) {
				mid = Math.min(leftStart + currentSize - 1, ARRAY_END);
				rightEnd = Math.min(leftStart + 2 * currentSize - 1, ARRAY_END);
				
				merge(array, leftStart, mid, rightEnd);
			}
		}
	}
	
	static void mergeSortRecursive(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			
			mergeSortRecursive(array, left, mid);
			mergeSortRecursive(array, mid + 1, right);
			
			merge(array, left, mid, right);
		}
	}
	
	static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start - 1, temp;
		
		for (int j = start; j < end; ++j) {
			if (array[j] < pivot) {
				temp = array[++i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		temp = array[++i];
		array[i] = array[end];
		array[end] = temp;
		
		return i;
	}
	
	static void quickSortRecursive(int[] array, int start, int end) {
		if (start < end) {
			int pi = partition(array, start, end);
			quickSortRecursive(array, start, pi - 1);
			quickSortRecursive(array, pi + 1, end);
		}
	}
	
	static void selectionSortIterative(int[] array) {
		final int LENGTH = array.length;
		int i, j, lowest, temp;
		
		for (i = 0; i < LENGTH; ++i) {
			lowest = i;
			for (j = i + 1; j < LENGTH; ++j) {
				if (array[j] < array[lowest])
					lowest = j;
			}
			temp = array[i];
			array[i] = array[lowest];
			array[lowest] = temp;
		}
	}
	
	static void selectionSortRecursive(int[] array) { selectionSortRecursive(array, 0); }
	
	static void selectionSortRecursive(int[] array, int i) {
		int j, lowest, temp;
		for (; i < array.length; ++i) {
			lowest = i;
			for (j = i + 1; j < array.length; ++j) {
				if (array[j] < array[lowest])
					lowest = j;
			}
			temp = array[i];
			array[i] = array[lowest];
			array[lowest] = temp;
		}
	}
}