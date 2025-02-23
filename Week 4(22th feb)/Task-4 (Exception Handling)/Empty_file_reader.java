package task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Empty_file_reader {
    public static void main(String[] args) {
        String filePath = "/Users/sambandamagoramoorthy/Downloads/138/file2"; 

        try {
            readFile(filePath);
        } catch (EmptyFileException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void readFile(String filePath) throws IOException, EmptyFileException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean isEmpty = true;

        while ((line = reader.readLine()) != null) {
            isEmpty = false;
            System.out.println(line);
        }

        reader.close();

        if (isEmpty) {
            throw new EmptyFileException("The file is empty.");
        }
    }
}
