package task_3;

import java.io.File;

public class File_or_directory {
    public static void main(String[] args) {
  
        String pathname = "/Users/sambandamagoramoorthy/Downloads/Example/io";
        File file = new File(pathname);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println(pathname + " is a directory.");
            } else if (file.isFile()) {
                System.out.println(pathname + " is a file.");
            } else {
                System.out.println(pathname + " is neither a file nor a directory.");
            }
        } else {
            System.out.println(pathname + " does not exist.");
        }
    }
}
