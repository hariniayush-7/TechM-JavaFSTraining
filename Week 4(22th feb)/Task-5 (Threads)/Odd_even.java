package task_5;
class EvenNumbers extends Thread {
    public void run() {
        System.out.println("Even Numbers from 1 to 20:");
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class OddNumbers extends Thread {
    public void run() {
        System.out.println("Odd Numbers from 1 to 20:");
        for (int i = 1; i < 20; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Odd_even {
    public static void main(String[] args) {
        EvenNumbers evenThread = new EvenNumbers();
        OddNumbers oddThread = new OddNumbers();

        evenThread.start();
        oddThread.start();
        
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
