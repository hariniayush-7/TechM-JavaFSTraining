import java.io.File;
import java.util.Scanner;

public class eg4 {
    public static void main(String[] args) {
        System.out.println("Press 1 to Create a file without creating a folder");
        System.out.println("Press 2 to create 3 files by creating a folder");
        System.out.println("Press 3 to create 4 files by creating a folder");

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case 1: {
                File f1 = new File("/Users/sambandamagoramoorthy/Downloads/file1.txt");
                try {
                    f1.createNewFile();

                } catch (Exception ignored) {
                }
                break;
            }

            case 2: {
                File folder = new File("/Users/sambandamagoramoorthy/Downloads/138");
                folder.mkdir();
                File f2 = new File(folder, "file2");
                File f3 = new File(folder, "file3");
                File f4 = new File(folder, "file4 ");

                try {

                    f2.createNewFile();
                    f3.createNewFile();
                    f4.createNewFile();
                } catch (Exception ignored) {
                }
                break;


            }
            case 3: {
                File newfolder = new File("/Users/sambandamagoramoorthy/Downloads/ayush");
                newfolder.mkdir();
                File f2 = new File(newfolder, "file2");
                File f3 = new File(newfolder, "file3");
                File f4 = new File(newfolder, "file4 ");
                File f5 = new File(newfolder, "file4 ");


                try {

                    f2.createNewFile();
                    f3.createNewFile();
                    f4.createNewFile();
                    f5.createNewFile();
                } catch (Exception ignored) {
                }
                break;
            }
            default: System.out.println("inavalid number entered");


        }

        System.out.println("created succesfully");
    }
}