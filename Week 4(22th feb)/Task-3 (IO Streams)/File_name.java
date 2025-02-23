package task_3;

import java.io.File;

public class  File_name{
    public static void main(String[] args) {
       
        String directoryPath = "/Users/sambandamagoramoorthy/Downloads/Anger"; 
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
           String[] filesAndDirs = directory.list();
            if (filesAndDirs != null) {
                System.out.println("Files and directories in " + directoryPath + ":");
                for (String name : filesAndDirs) {
                    System.out.println(name);
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }
}
