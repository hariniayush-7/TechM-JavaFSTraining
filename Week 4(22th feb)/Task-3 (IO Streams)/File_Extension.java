package task_3;
import java.io.File;
import java.io.FilenameFilter;

public class File_Extension {

    public static void main(String[] args) {
       
        String directoryPath = "/Users/sambandamagoramoorthy/Downloads/html"; 
        String[] extensions = new String[] { "html", "java", "css" }; 
        File[] filteredFiles = getFilesWithExtensions(directoryPath, extensions);

       if (filteredFiles != null && filteredFiles.length > 0) {
            System.out.println("Filtered files:");
            for (File file : filteredFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found with the specified extensions.");
        }
    }

    public static File[] getFilesWithExtensions(String directoryPath, String[] extensions) {
        File directory = new File(directoryPath);
        
       if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified path is not a valid directory.");
            return null;
        }

      
        FilenameFilter filter = (dir, name) -> {
            for (String extension : extensions) {
                if (name.toLowerCase().endsWith("." + extension)) {
                    return true;
                }
            }
            return false;
        };

      return directory.listFiles(filter);
    }
}
