import java.util.Arrays;

public class SortingAlgorithmsApr24 {
    public static void mergeSort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left != mid && right != mid) {
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
        }

        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        for (; i <= mid && j <= right; ++k) {
            if (array[i] < array[j])
                temp[k] = array[i++];
            else
                temp[k] = array[j++];
        }
        for (; i <= mid; ++k) temp[k] = array[i++];
        for (; j <= right; ++k) temp[k] = array[j++];

        for (k = 0; k < temp.length; ++k)
            array[left++] = temp[k];
    }

    public static void main(String[] args) {
        int[] array = {43, 2, 71, 55, 21, 31, 46, 102, 3001, 11, 75};
        System.out.println("Unsorted: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted: " + Arrays.toString(array));
    }
}