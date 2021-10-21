import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the range: ");
        int k = scanner.nextInt();
        System.out.println("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        countSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Count Sort- It is not comparison based algorithm.
     * It is based on counting(frequency) of elements present in array.
     * It is stable but not in-place.
     * Time Complexity - O(n+k)
     * Space Complexity - O(n+k)
     *
     * @param arr - array to be sorted
     * @param k   - range of elements present in array [0, k-1]
     */
    private static void countSort(int[] arr, int k) {
        int[] count = new int[k];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

}
