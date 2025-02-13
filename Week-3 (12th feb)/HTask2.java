public class HTask2 {
    public static void main(String[] args)
    {
        thread2 t2=new thread2();
        t2.start(); // THREAD1
        t2.run();

        Thread tt2= new Thread(t2);
        tt2.start(); //THREAD2
    }

}

class thread2 extends Thread{
    public void run()
    {
        System.out.println(" from thread2!");
        System.out.println(" from thread2!");
        System.out.println(10/0);
    }
}