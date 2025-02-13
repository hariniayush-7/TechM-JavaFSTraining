public class HTask1 {
    public static void main(String[] args)
    {
       thread1 t1=new thread1();
       t1.start();
       t1.run();
    }
}

class thread1 extends Thread{
    public void run()
    {
        System.out.println(" from thread1!");
        System.out.println(" from thread1!");
        System.out.println(" from thread1!");
    }
}
