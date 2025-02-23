package task_7;
import java.util.ArrayList;

public class RemoveThirdElement {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Date");
        items.add("Elderberry");
        System.out.println("Original ArrayList: " + items);
        if (items.size() >= 3) {
            items.remove(2);
        } else {
            System.out.println("The ArrayList does not have enough elements to remove the third one.");
        }
        System.out.println("Modified ArrayList: " + items);
    }
}
