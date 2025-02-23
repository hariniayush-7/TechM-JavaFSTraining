package task_7;

import java.util.LinkedList;
import java.util.ListIterator;

public class ReverseLinkedList {
    public static void main(String[] args) {
       
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Node 1");
        linkedList.add("Node 2");
        linkedList.add("Node 3");
        linkedList.add("Node 4");

        iterateInReverse(linkedList);
    }

    public static void iterateInReverse(LinkedList<String> list) {
 
        ListIterator<String> iterator = list.listIterator(list.size());

        while (iterator.hasPrevious()) {
            String element = iterator.previous();
            System.out.println(element);
        }
    }
}
