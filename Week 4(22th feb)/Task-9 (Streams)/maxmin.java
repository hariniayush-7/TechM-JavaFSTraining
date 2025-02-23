package task_9;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class MaxMin {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 8, 2, 7, 4, 6);

        OptionalInt max = numbers.stream()
                                  .mapToInt(Integer::intValue)
                                  .max();

        OptionalInt min = numbers.stream()
                                  .mapToInt(Integer::intValue)
                                  .min();

        if (max.isPresent() && min.isPresent()) {
            System.out.println("Maximum value: " + max.getAsInt());
            System.out.println("Minimum value: " + min.getAsInt());
        } else {
            System.out.println("The list is empty.");
        }
    }
}
