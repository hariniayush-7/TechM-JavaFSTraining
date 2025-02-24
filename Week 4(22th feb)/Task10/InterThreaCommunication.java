package task_10;

public class InterthreadCommunication {

    private static final Object lock = new Object();
    private static boolean isReady = false;

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("Producer: Producing data...");
                isReady = true;
                lock.notify(); // Notify the consumer that data is ready
                System.out.println("Producer: Data is ready.");
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (!isReady) {
                    try {
                        System.out.println("Consumer: Waiting for data...");
                        lock.wait(); // Wait until the producer notifies
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Consumer: Consuming data...");
            }
        }
    }
}
