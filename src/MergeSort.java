import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Merge Sort - It is a divide and conquer algorithm.
     * It is stable but not in-place.
     * Time Complexity - O(nlogn)
     * Space Complexity - O(n) (not in-place)
     *
     * @param arr   - array to be sorted
     * @param left  - left index of array
     * @param right - right index of array
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        for (int i = 0; i < size1; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < size2; ++j)
            rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
