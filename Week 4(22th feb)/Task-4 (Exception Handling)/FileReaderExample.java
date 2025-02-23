package task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderExample {

    public static void main(String[] args) {
        String filePath = "/Users/sambandamagoramoorthy/Downloads/Anger/blue.html"; 
        try {
            readFile(filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file was not found. Please check the file path.");
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred while reading the file.");
        }
    }

    public static void readFile(String filePath) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
