public class HTask5 {
    public static void main(String[] args)
    {
        threadRunnable2 tr2=new threadRunnable2();
        Thread thr2= new Thread(tr2); // THREAD1
        thr2.start();

        threadRunnable2 tr22=new threadRunnable2();
        Thread ttr2= new Thread(tr22);
        ttr2.start(); //THREAD2

    }
}

class threadRunnable2 implements Runnable{
    public void run()
    {
        System.out.println(" from threadRunnable2!");
        System.out.println(" from threadRunnable2!");
        System.out.println(" from threadRunnable2!");
    }
}