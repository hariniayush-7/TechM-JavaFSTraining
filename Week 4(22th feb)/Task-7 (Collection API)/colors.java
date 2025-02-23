package task_7;

import java.util.ArrayList;

public class colors {
    public static void main(String[] args) {
      
        ArrayList<String> colors = new ArrayList<>();       
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");
        System.out.println("Colors in the ArrayList:");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}
