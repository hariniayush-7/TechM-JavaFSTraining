package task_7;

class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList3 {
    Node3 head;

    public void insertAtPosition(int data, int position) {
        Node3 newNode = new Node3(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node3 current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }


    public void display() {
        Node3 current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class InsertLinkedList {
    public static void main(String[] args) {
        LinkedList3 linkedList = new LinkedList3();
        linkedList.insertAtPosition(10, 0); 
        linkedList.insertAtPosition(20, 1);
        linkedList.insertAtPosition(30, 1); 
        linkedList.insertAtPosition(40, 3); 

        linkedList.display();
    }
}
