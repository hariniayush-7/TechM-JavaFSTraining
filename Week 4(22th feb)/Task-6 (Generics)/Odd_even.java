package task_6;

import java.util.List;

public class Odd_even {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        double evenSum = 0;
        double oddSum = 0;

        for (T number : numbers) {
            if (number.intValue() % 2 == 0) {
                evenSum += number.doubleValue();
            } else {
                oddSum += number.doubleValue();
            }
        }

        System.out.println("Sum of Even Numbers: " + evenSum);
        System.out.println("Sum of Odd Numbers: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        List<Double> doubleList = List.of(1.5, 2.5, 3.5, 4.5);

        System.out.println("For Integer List:");
        sumEvenOdd(intList);

        System.out.println("\nFor Double List:");
        sumEvenOdd(doubleList);
    }
}
