package task_7;

class Node4 {
    int data;
    Node4 next;

    Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList4 {
    Node4 head;

    public void insertAtBeginning(int data) {
        Node4 newNode = new Node4(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node4 newNode = new Node4(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node4 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void display() {
        Node4 current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList4 linkedList = new LinkedList4();

        linkedList.insertAtEnd(10);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtBeginning(40);

        linkedList.display();
    }
}
