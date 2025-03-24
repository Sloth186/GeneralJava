import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmsMar24 {
    public static void main(String[] args) {
        Random rg = new Random();
        int[] array = new int[20];
        for (int i = 0; i < 20; ++i) array[i] = rg.nextInt(100);
        System.out.println("Starting array: " + Arrays.toString(array));
        quickSort(array);
        System.out.println("Final array: " + Arrays.toString(array));
    }

    static void quickSort(int[] arr) {
        quickSort_(arr, 0, arr.length - 1);
    }

    static void quickSort_(int[] arr, int left, int right) {
        System.out.println("Initial left: " + left);
        System.out.println("Initial right: " + right);
        if (left < right) {
            int pivotIndex = right, pivotValue = arr[right];
            System.out.println("Pivot value: " + pivotValue);
            System.out.println("Initial pivot index: " + pivotIndex);
            while (left < right) {
                if (arr[left] > pivotValue) {
                    arr[pivotIndex] = arr[left];
                    arr[left] = arr[--pivotIndex];
                } else ++left;
                System.out.println("Arr: " + Arrays.toString(arr));
                System.out.println("Left: " + left);
                System.out.println("Pivot index: " + pivotIndex);
            }
            arr[pivotIndex] = pivotValue;
        }
    }
}