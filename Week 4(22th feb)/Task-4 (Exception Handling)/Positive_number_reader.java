package task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Positive_number_reader {
    public static void main(String[] args) {
        String filePath = "/Users/sambandamagoramoorthy/Downloads/Example/file1.txt"; 

        try {
            readNumbersFromFile(filePath);
        } catch (PositiveNumberException e) {
            System.err.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File reading error: " + e.getMessage());
        }
    }

    public static void readNumbersFromFile(String filePath) throws IOException, PositiveNumberException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line.trim());
            if (number > 0) {
                throw new PositiveNumberException("Positive number found: " + number);
            }
        }
        reader.close();
    }
}