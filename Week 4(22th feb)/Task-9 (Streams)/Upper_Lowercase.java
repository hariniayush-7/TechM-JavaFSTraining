package task_9;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Upper_Lowercase{

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World", "Java", "Streams");

        // Convert to Uppercase
        List<String> upperCaseStrings = convertToUpperCase(strings);
        System.out.println("Uppercase: " + upperCaseStrings);

        // Convert to Lowercase
        List<String> lowerCaseStrings = convertToLowerCase(strings);
        System.out.println("Lowercase: " + lowerCaseStrings);
    }

    public static List<String> convertToUpperCase(List<String> strings) {
        return strings.stream()
                      .map(String::toUpperCase)
                      .collect(Collectors.toList());
    }

    public static List<String> convertToLowerCase(List<String> strings) {
        return strings.stream()
                      .map(String::toLowerCase)
                      .collect(Collectors.toList());
    }
}
