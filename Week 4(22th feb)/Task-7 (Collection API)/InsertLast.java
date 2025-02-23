package task_7;

class Node6 {
    int data;
    Node6 next;

    Node6(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList6 {
    Node6 head;

    public void insertAtEnd(int data) {
        Node6 newNode = new Node6(data);
        if (head == null) {
            head = newNode;
        } else {
            Node6 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }
    public void display() {
        Node6 current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class InsertLast {
    public static void main(String[] args) {
        LinkedList6 linkedList = new LinkedList6();
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        
        System.out.println("Linked List after inserting elements:");
        linkedList.display();
    }
}
