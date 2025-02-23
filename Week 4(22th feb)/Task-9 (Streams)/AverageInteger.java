package task_9;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageInteger {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        
        OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();
        
        if (average.isPresent()) {
            System.out.printf("The average is: %.2f%n", average.getAsDouble());
        } else {
            System.out.println("The list is empty, no average to calculate.");
        }
    }
}
