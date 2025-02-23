package task_7;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSearch {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Date");
        items.add("Elderberry");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element to search for: ");
        String searchElement = scanner.nextLine();
        int index = items.indexOf(searchElement);
        if (index != -1) {
            System.out.println("Element '" + searchElement + "' found at index: " + index);
        } else {
            System.out.println("Element '" + searchElement + "' not found in the list.");
        }
        scanner.close();
    }
}
