package task_1;

import java.util.Arrays;
public class Equals {
    public static void main(String[] args) {
        // Example of equals() method
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        
        System.out.println("Using equals(): " + str1.equals(str2)); // true

        // Example of deepEquals() method
        int[][] array1 = { {1, 2}, {3, 4} };
        int[][] array2 = { {1, 2}, {3, 4} };
        
        System.out.println("Using deepEquals(): " + Arrays.deepEquals(array1, array2)); // true

        // Modifying array2 to demonstrate deepEquals
        array2[0][1] = 5;
        System.out.println("Using deepEquals() after modification: " + Arrays.deepEquals(array1, array2)); // false
    }

}


