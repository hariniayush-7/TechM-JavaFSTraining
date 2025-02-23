package task_5;

public class Hello_java extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        Hello_java thread = new Hello_java();
        thread.start();
    }
}
