package task_3;
import java.io.File;
public class  File_size {
    public static void main(String[] args) {
        String filePath = "/Users/sambandamagoramoorthy/Downloads/Example/BOOKS.zip"; 
        File file = new File(filePath);
        if (file.exists()) {
            long fileSizeInBytes = file.length();
            double fileSizeInKB = fileSizeInBytes / 1024.0;
            double fileSizeInMB = fileSizeInKB / 1024.0;
            System.out.printf("File Size: %d Bytes\n", fileSizeInBytes);
            System.out.printf("File Size: %.2f KB\n", fileSizeInKB);
            System.out.printf("File Size: %.2f MB\n", fileSizeInMB);
        } else {
            System.out.println("The specified file does not exist.");
        }
    }
}
