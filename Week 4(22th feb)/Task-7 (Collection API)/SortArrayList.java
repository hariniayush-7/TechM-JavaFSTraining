package task_7;
import java.util.ArrayList;
import java.util.Collections;

public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(4);
        

        System.out.println("Original ArrayList: " + numbers);
        Collections.sort(numbers);
        System.out.println("Sorted ArrayList: " + numbers);
    }
}
