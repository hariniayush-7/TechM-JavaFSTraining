import java.util.ArrayList;
import java.util.List;

public class ArrayListthread extends Thread {
     public  void run() {
         List<Integer> list1 = new ArrayList<>();
         //System.out.println("Is list1 empty? "+list1.isEmpty());
         list1.add(30);
         list1.add(17);
         list1.add(1);
         list1.add(19);
         //System.out.println("Is list1 empty? "+list1.isEmpty());
         System.out.println("The given list is:"+list1);
         System.out.println("Number of elements in the list: " + list1.size());

         //Adding one element
         list1.add(9);
         System.out.println("After adding one element:");
         System.out.println("The given list is :" + list1);
         System.out.println("The number of elements in the list: " + list1.size());
          //Checking for an element
         System.out.println("Is 566 available in the list:" + list1.contains(7));
         System.out.println("The given list before removing elements is :" + list1);
         list1.remove(2);//Removing element by its index
         list1.remove(3);//Removing element by its index
         System.out.println("After removing elements:");
         System.out.println("The given list is :" + list1);
         System.out.println("The number of elements in the list: " + list1.size());
     }
 }