package task_7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleArrayList {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Date");
        items.add("Elderberry");
        System.out.println("Original List: " + items);

        Collections.shuffle(items);
        System.out.println("Shuffled List: " + items);
    }
}
