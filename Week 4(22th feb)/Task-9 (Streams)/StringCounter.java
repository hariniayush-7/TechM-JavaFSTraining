package task_9;
import java.util.Arrays;
import java.util.List;

public class StringCounter {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry", "Cherry", "Apricot");
        char specificLetter = 'A';

        long count = countStringsStartingWith(strings, specificLetter);
        System.out.println("Number of strings starting with '" + specificLetter + "': " + count);
    }

    public static long countStringsStartingWith(List<String> strings, char letter) {
        return strings.stream()
                      .filter(s -> s.toUpperCase().charAt(0) == Character.toUpperCase(letter))
                      .count();
    }
}
