package task_7;

import java.util.LinkedList;

public class LinkedListOccurrence {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(40);
        list.add(50);

        int elementToFind = 20;
        int firstIndex = getFirstOccurrence(list, elementToFind);
        int lastIndex = getLastOccurrence(list, elementToFind);
        System.out.println("First occurrence of " + elementToFind + " is at index: " + firstIndex);
        System.out.println("Last occurrence of " + elementToFind + " is at index: " + lastIndex);
    }
    public static int getFirstOccurrence(LinkedList<Integer> list, int element) {
        return list.indexOf(element);
    }

    public static int getLastOccurrence(LinkedList<Integer> list, int element) {
        return list.lastIndexOf(element);
    }
}
