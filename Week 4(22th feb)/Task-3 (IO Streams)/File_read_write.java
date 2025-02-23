package task_3;
import java.io.File;

public class File_read_write  {

    public static void main(String[] args) {
       
        String path = "/Users/sambandamagoramoorthy/Downloads/Example";
        File file = new File(path);
       checkPermissions(file);
    }

    private static void checkPermissions(File file) {
        if (file.exists()) {
            System.out.println("File/Directory: " + file.getAbsolutePath());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
        } else {
            System.out.println("The specified file or directory does not exist.");
        }
    }
}
