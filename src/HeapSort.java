import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Heap Sort - It is comparison based algorithm that is similar to selection sort.
     * It is in-place and unstable sorting algorithm.
     * Time Complexity - O(nlogn) (all cases)
     * Space Complexity - O(1)
     *
     * @param arr - array to be sorted
     */
    private static void heapSort(int[] arr) {
        //1. Build the max heap first.
        buildHeap(arr);
        //2. swap the root node with last node and reduce the heap size by 1 and then heapify it again
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        //find all internal nodes and then heapify the sub-tree.
        //parent of any child element i is (i-1)/2
        //so parent of last element of array at n-1 is at ((n-1)-1)/2 = (n-2)/2
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    }

    private static void maxHeapify(int[] arr, int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < length && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < length && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, length, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
