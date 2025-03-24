import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmsBenchmark {
	public static void main(String[] args) {
		Random rg = new Random();
		final int LENGTH = 20_000;
		final int[] UNSORTED_ARRAY = new int[LENGTH];
		for (int i = 0; i < LENGTH; ++i)
			UNSORTED_ARRAY[i] = rg.nextInt(LENGTH*100);

		long[] elapsedTime = new long[10];
		long startTime;
		final long NANO_TO_MICRO = 1000;
		int[] unsortedArray;

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		Arrays.sort(unsortedArray);
		elapsedTime[0] = System.nanoTime() - startTime;
		System.out.println("Integrated sort (Dual-Pivot Quicksort): " + elapsedTime[0] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		insertionSortIterative(unsortedArray);
		elapsedTime[1] = System.nanoTime() - startTime;
		System.out.println("Insertion sort iterative: " + elapsedTime[1] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		insertionSortRecursive(unsortedArray);
		elapsedTime[2] = System.nanoTime() - startTime;
		System.out.println("Insertion sort recursive: " + elapsedTime[2] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		bubbleSortIterative(unsortedArray);
		elapsedTime[3] = System.nanoTime() - startTime;
		System.out.println("Bubble sort iterative: " + elapsedTime[3] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		bubbleSortRecursive(unsortedArray);
		elapsedTime[4] = System.nanoTime() - startTime;
		System.out.println("Bubble sort recursive: " + elapsedTime[4] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		mergeSortIterative(unsortedArray);
		elapsedTime[5] = System.nanoTime() - startTime;
		System.out.println("Merge sort iterative: " + elapsedTime[5] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		mergeSortRecursive(unsortedArray, 0, unsortedArray.length - 1);
		elapsedTime[6] = System.nanoTime() - startTime;
		System.out.println("Merge sort recursive: " + elapsedTime[6] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		quickSortRecursive(unsortedArray, 0, unsortedArray.length - 1);
		elapsedTime[7] = System.nanoTime() - startTime;
		System.out.println("Quick sort recursive: " + elapsedTime[7] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		selectionSortIterative(unsortedArray);
		elapsedTime[8] = System.nanoTime() - startTime;
		System.out.println("Selection sort iterative: " + elapsedTime[8] / NANO_TO_MICRO + " microseconds");

		unsortedArray = Arrays.copyOf(UNSORTED_ARRAY, UNSORTED_ARRAY.length);
		startTime = System.nanoTime();
		selectionSortRecursive(unsortedArray);
		elapsedTime[9] = System.nanoTime() - startTime;
		System.out.println("Selection sort recursive: " + elapsedTime[9] / NANO_TO_MICRO + " microseconds");
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