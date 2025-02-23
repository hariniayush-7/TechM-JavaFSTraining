package task_6;
import java.util.List;

public class Search {

    public static <T> int findIndex(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
       
        List<String> stringList = List.of("apple", "banana", "cherry", "date");
        System.out.println("Index of 'cherry': " + findIndex(stringList, "cherry"));
        System.out.println("Index of 'fig': " + findIndex(stringList, "fig")); 

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        System.out.println("Index of 3: " + findIndex(integerList, 3)); 
        System.out.println("Index of 6: " + findIndex(integerList, 6)); 
    }
}
