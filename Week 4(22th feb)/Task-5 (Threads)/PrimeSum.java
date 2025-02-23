package task_5;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeSum {
    private static final int THREAD_COUNT = 4; 
    private static AtomicInteger sum = new AtomicInteger(0); 

    public static void main(String[] args) {
        int limit = 100; 
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int range = limit / THREAD_COUNT;

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * range + 1;
            final int end = (i + 1) * range;

            executor.execute(() -> {
                for (int num = start; num <= end && num <= limit; num++) {
                    if (isPrime(num)) {
                        sum.addAndGet(num);
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Sum of prime numbers up to " + limit + " is: " + sum.get());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
