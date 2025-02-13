public class HTask3 {
    public static void main(String[] args)
    {
        thread3 t3=new thread3();
        t3.start(); // THREAD1
        System.out.println("--------------------");
        t3.run();

        Thread tt3= new Thread(t3);
        tt3.start(); //THREAD2
        System.out.println("--------------------");

        new Thread(t3).start();
        System.out.println("--------------------");
        t3.run(); //THREAD3
    }
}

class thread3 extends Thread{
    public void run()
    {
        System.out.println(" from thread3!");
        System.out.println(" from thread3!");
        System.out.println(" from thread3!");
        System.out.println(" from thread3!");
        System.out.println(" from thread3!");

    }
}