import java.util.LinkedList;
import java.util.List;

public class LinkedListThread extends Thread{
    public  void run() {
        List<Integer> list2 = new LinkedList<>();
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        list2.add(30);
        list2.add(17);
        list2.add(1);
        list2.add(19);
        list2.add(17);
        list2.add(17);
        list2.add(17);

        //System.out.println("Is list1 empty? "+list1.isEmpty());
        System.out.println("The given list is:"+list2);
        System.out.println("Number of elements in the list: " + list2.size());

        //Adding one element
        list2.add(9);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + list2);
        System.out.println("The number of elements in the list: " + list2.size());
        //Checking for an element
        System.out.println("Is 566 available in the list:" + list2.contains(7));
        System.out.println("The given list before removing elements is :" + list2);
        list2.remove(2);//Removing element by its index
        list2.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :" + list2);
        System.out.println("The number of elements in the list: " + list2.size());
    }
}
