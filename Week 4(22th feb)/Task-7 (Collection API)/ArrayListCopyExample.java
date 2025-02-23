package task_7;
import java.util.ArrayList;

public class ArrayListCopyExample {
    public static void main(String[] args) {
       
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");

        ArrayList<String> copiedList = new ArrayList<>();
        copiedList.addAll(originalList);
        System.out.println("Original List: " + originalList);
        System.out.println("Copied List: " + copiedList);
    }
}
