package task_3;
import java.io.File;

public class File_Exist  {
    public static void main(String[] args) {
       
        String pathname = "/Users/sambandamagoramoorthy/Downloads/138";
        File file = new File(pathname);

        if (file.exists()) {
            System.out.println("The file or directory exists.");
        } else {
            System.out.println("The file or directory does not exist.");
        }
    }
}
