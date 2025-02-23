package task_7;

class Node2 {
    int data;
    Node2 next;

    Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList2 {
    Node2 head;

    public void add(int data) {
        Node2 newNode = new Node2(data);
        if (head == null) {
            head = newNode;
        } else {
            Node2 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

  
    public void iterateFromPosition(int position) {
        Node2 current = head;
        int index = 0;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current != null) {
            System.out.println("Elements from position " + position + ":");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        } else {
            System.out.println("Position " + position + " is out of bounds.");
        }
    }
}

public class SpecificLinkedList{
    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.iterateFromPosition(2);

        list.iterateFromPosition(5);
    }
}
