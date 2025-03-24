import java.util.Random;
import java.util.Stack;

public class Bogosort {
	public static void bogosort(int[] array) {
		Random rng = new Random();
		int length = array.length;
		boolean unsorted = true;
		int i, selectIndex, temp;
		
		int iterations = 0;
		while (unsorted) {
			for (i = 0; i < length; ++i) {
				selectIndex = rng.nextInt(i, length);
				temp = array[selectIndex];
				array[selectIndex] = array[i];
				array[i] = temp;
			}
			
			/*for (i = 0; i < length; ++i)
				System.out.print(array[i] + " ");
			System.out.println();*/
			
			unsorted = false;
			for (i = 1; i < length; ++i)
				if (array[i - 1] > array[i]) {
					unsorted = true;
					break;
				}
			
			++iterations;
		}
		
		System.out.println("Iterations: " + iterations);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 5, 4, 3, 6, 2};
		bogosort(array);
	}
}