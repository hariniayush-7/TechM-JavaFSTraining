package task_3;

import java.io.File;
import java.text.SimpleDateFormat;

public class LastModifiedDate {
    public static void main(String[] args) {
        
        String filePath = "/Users/sambandamagoramoorthy/Downloads/Example/file1.txt";
        File file = new File(filePath);

        if (file.exists()) {
            long lastModified = file.lastModified();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String formattedDate = sdf.format(lastModified);
            System.out.println("Last Modified Date: " + formattedDate);
        } else {
            System.out.println("The specified file does not exist.");
        }
    }
}
