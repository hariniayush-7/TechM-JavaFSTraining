import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class eg3 {

    public static void BufferMethod() throws IOException {
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter the input :");
        String s = r.readLine();
        System.out.println("this is the input from buffer reader method");
        System.out.println(s);

    }

    public void ScannerMethod()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a integer:");
        int a = sc.nextInt();
        System.out.println("enter a float value:");
        float b = sc.nextFloat();
        System.out.println("enter a String:");
        String k  = sc.next();
        System.out.println("this are the inputs from scanner method ");
        System.out.println(a);
        System.out.println(b);
        System.out.println(k);
    }
}