package task_9;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSorter {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Banana", "Apple", "Orange", "Mango", "Grapes");

        // Sorting in ascending order
        List<String> sortedAscending = strings.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted in Ascending Order: " + sortedAscending);

        // Sorting in descending order
        List<String> sortedDescending = strings.stream()
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
        System.out.println("Sorted in Descending Order: " + sortedDescending);
    }
}
