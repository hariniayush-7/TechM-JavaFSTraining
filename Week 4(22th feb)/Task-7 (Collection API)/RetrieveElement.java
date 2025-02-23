package task_7;

import java.util.ArrayList;
import java.util.Scanner;

public class RetrieveElement {
    public static void main(String[] args) {
        
        ArrayList<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Date");
        items.add("Elderberry");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the element you want to retrieve (0 to " + (items.size() - 1) + "): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < items.size()) {
            String element = items.get(index);
            System.out.println("Element at index " + index + ": " + element);
        } else {
            System.out.println("Invalid index. Please enter a number between 0 and " + (items.size() - 1) + ".");
        }
        scanner.close();
    }
}
