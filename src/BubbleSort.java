import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    /**
     * Bubble Sort - It is stable and in-place sorting algorithm.
     * Time Complexity - O(n^2) (Best - n, worst - n^2)
     * Space Complexity - O(1)
     *
     * @param arr - array to be sorted
     * @return arr - sorted array
     */
    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int swapCount = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                }
            }
            if (swapCount == 0) {
                break;
            }
        }
        return arr;
    }

}
