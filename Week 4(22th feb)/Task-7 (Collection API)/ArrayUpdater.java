package task_7;
import java.util.Scanner;

public class ArrayUpdater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Original Array: ");
        displayArray(numbers);
        System.out.print("Enter the index of the element to update (0 to " + (numbers.length - 1) + "): ");
        int index = scanner.nextInt();
        
        System.out.print("Enter the new value: ");
        int newValue = scanner.nextInt();
        if (index >= 0 && index < numbers.length) {
            numbers[index] = newValue;
            System.out.println("Updated Array: ");
            displayArray(numbers);
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
        
        scanner.close();
    }

    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
