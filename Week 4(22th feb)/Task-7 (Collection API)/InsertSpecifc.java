package task_7;

class Node7 {
    int data;
    Node7 next;

    Node7(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList7 {
    Node7 head;

    public void insertAtPosition(int data, int position) {
        Node7 newNode = new Node7(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node7 current = head;
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
    public void printList() {
        Node7 current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class InsertSpecifc {
    public static void main(String[] args) {
        LinkedList7 linkedList = new LinkedList7();
        linkedList.insertAtPosition(10, 0); 
        linkedList.insertAtPosition(20, 1); 
        linkedList.insertAtPosition(30, 1); 
        linkedList.insertAtPosition(40, 3); 
        linkedList.printList(); 
    }
}
