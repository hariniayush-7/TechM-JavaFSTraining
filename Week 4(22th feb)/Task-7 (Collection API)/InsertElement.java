package task_7;
import java.util.ArrayList;
public class InsertElement{
    public static void main(String[] args) {
           ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grapes");
        System.out.println("ArrayList before insertion: " + fruits);
        fruits.add(0, "Apple");
        System.out.println("ArrayList after inserting 'Apple' at the first position: " + fruits);
    }
}
