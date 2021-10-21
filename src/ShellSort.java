import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Shell Sort - It is a variation of insertion sort.
     * It is designed to reduce the movements which are greater in insertion sort.
     * It is in-place but not stable.
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     *
     * @param arr - array to be sorted
     */
    private static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap >= 1; gap = gap / 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
        }
    }
}
