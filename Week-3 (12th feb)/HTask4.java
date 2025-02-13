public class HTask4 {
    public static void main(String[] args)
    {
        //threadRunnable1 tr1=new threadRunnable1();
        //tr1.start();
        //tr1.run();

        threadRunnable1 tr11=new threadRunnable1();
        Thread tri2= new Thread(tr11);
        tri2.start(); //THREAD4
    }
}

class threadRunnable1 implements Runnable{
    public void run()
    {
        System.out.println(" from threadRunnable1!");
        System.out.println(" from threadRunnable1!");
    }
}