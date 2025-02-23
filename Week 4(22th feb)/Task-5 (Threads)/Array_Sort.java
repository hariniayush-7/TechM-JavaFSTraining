package task_5;
import java.util.Arrays;

public class Array_Sort{

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 6, 2, 7, 4, 1};
        System.out.println("Original Array: " + Arrays.toString(array));

       
        int mid = array.length / 2;
        Thread leftThread = new Thread(() -> mergeSort(array, 0, mid));
        Thread rightThread = new Thread(() -> mergeSort(array, mid, array.length));

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        merge(array, 0, mid, array.length);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(array, start, mid);
        int[] right = Arrays.copyOfRange(array, mid, end);

        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
