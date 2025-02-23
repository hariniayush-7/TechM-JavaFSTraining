package task_3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filereader{
    public static void main(String[] args) {
        String filePath = "/Users/sambandamagoramoorthy/Downloads/ayush/ece138.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
