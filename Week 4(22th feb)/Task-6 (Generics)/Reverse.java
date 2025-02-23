package task_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reverse {

    public static <T> List<T> reverseList(List<T> inputList) {
        List<T> reversedList = new ArrayList<>(inputList);
        Collections.reverse(reversedList);
        return reversedList;
    }

    public static void main(String[] args) {
       
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        List<Integer> reversedIntegerList = reverseList(integerList);
        System.out.println("Reversed Integer List: " + reversedIntegerList);

       
        List<String> stringList = List.of("A", "B", "C", "D");
        List<String> reversedStringList = reverseList(stringList);
        System.out.println("Reversed String List: " + reversedStringList);
    }
}
