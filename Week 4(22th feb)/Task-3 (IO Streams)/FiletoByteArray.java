package task_3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FiletoByteArray {
    public static void main(String[] args) {
        String filePath = "/Users/sambandamagoramoorthy/Downloads/Example/BOOKS.zip";
        byte[] fileData = readFileToByteArray(filePath);
        
        if (fileData != null) {
            System.out.println("File read successfully. Size: " + fileData.length + " bytes.");
        }
    }

    public static byte[] readFileToByteArray(String filePath) {
        File file = new File(filePath);
        byte[] fileData = new byte[(int) file.length()];

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(fileData);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }

        return fileData;
    }
}
