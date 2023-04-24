
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head, tail;

    public LinkedList() {
        this.head = this.tail = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove() {
        if (head == null) {
            System.out.println("Queue is empty");
        } else {
            head = head.next;
        }
    }

    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("Queue is empty");
        } else {
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}

public class QueueIntoStack {
    
}
