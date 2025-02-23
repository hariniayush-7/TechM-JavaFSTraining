package task_7;

class Node5 {
    int data;
    Node5 next;

    Node5(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList5 {
    Node5 head;
    public void insertAtFront(int data) {
        Node5 newNode = new Node5(data);
        newNode.next = head; 
        head = newNode; 
    }

    public void printList() {
        Node5 current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class InsertFirst {
    public static void main(String[] args) {
        LinkedList5 linkedList = new LinkedList5();
        
        linkedList.insertAtFront(10);
        linkedList.insertAtFront(20);
        linkedList.insertAtFront(30);
        
        linkedList.printList(); 
    }
}
