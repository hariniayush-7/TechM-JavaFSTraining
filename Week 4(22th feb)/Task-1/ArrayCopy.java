package task_1;

import java.util.Arrays;

public class ArrayCopy {
    
    public static void main(String[] args) {
        // Original array
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Define the range to copy
        int start = 3; // Starting index (inclusive)
        int end = 7;   // Ending index (exclusive)
        
        // Copy the range of values
        int[] copiedArray = arrayCopyRange(originalArray, start, end);
        
        // Display the copied array
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));
    }
    
    public static int[] arrayCopyRange(int[] source, int start, int end) {
        // Validate the range
        if (start < 0 || end > source.length || start >= end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        
        // Calculate the length of the new array
        int length = end - start;
        int[] destination = new int[length];
        
        // Copy the specified range
        for (int i = 0; i < length; i++) {
            destination[i] = source[start + i];
        }
        
        return destination;
    }
}
