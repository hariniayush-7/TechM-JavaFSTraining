package task_7;
class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList1 {
    Node1 head;

    // Method to add a new node at the end of the list
    public void add(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
        } else {
            Node1 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to iterate through the linked list
    public void iterate() {
        Node1 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class IterateLinkedList {
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Elements in the linked list:");
        list.iterate();
    }
}
