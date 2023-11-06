import java.util.Random;
import java.util.Scanner;

public class QuickSortAnalysis {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void randomizedQuickSort(int[] arr) {
        randomizedQuickSort(arr, 0, arr.length - 1);
    }

    private static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int randomPivot = randomPartition(arr, low, high);
            randomizedQuickSort(arr, low, randomPivot - 1);
            randomizedQuickSort(arr, randomPivot + 1, high);
        }
    }

    private static int randomPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low;

        int temp = arr[high];
        arr[high] = arr[randomIndex];
        arr[randomIndex] = temp;

        return partition(arr, low, high);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] arrCopy = arr.clone();

        long startTime = System.nanoTime();
        quickSort(arr);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.println("Sorted array using Quick Sort (Deterministic Variant):");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nTime taken for Quick Sort (Deterministic Variant): " + elapsedTime + " nanoseconds");

        startTime = System.nanoTime();
        randomizedQuickSort(arrCopy);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("\nSorted array using Quick Sort (Randomized Variant):");
        for (int num : arrCopy) {
            System.out.print(num + " ");
        }
        System.out.println("\nTime taken for Quick Sort (Randomized Variant): " + elapsedTime + " nanoseconds");
    }
}
