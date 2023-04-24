package linkedList;


// implementing circular linked list
class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

}

class circularList {
    Node tail;



    public void insert(int data) {
        Node newVertex = new Node(data);
        if (tail == null) {
            tail = newVertex;
            tail.next = tail;
        } else {
            newVertex.next = tail.next;
            tail.next = newVertex;
            tail = newVertex;
        }
    }
    // insert remove
    public void remove() {
        if (tail == null) {
            return;
        } else {
            tail.next = tail.next.next;
        }
    }
    // insert after function

    public void insertAfter(int data, int after) {
        Node newVertex = new Node(data);
        Node current = tail.next;
        while (current != tail && current.data != after) {
            current = current.next;
        }
        if (current == tail) {
            return;
        } else {
            newVertex.next = current.next;
            current.next = newVertex;
        }
    }

    // insert before function

    public void insertBefore(int data, int before) {
        Node newVertex = new Node(data);
        Node current = tail.next;
        while (current != tail && current.data != before) {
            current = current.next;
        }
        if (current == tail) {
            return;
        } else {
            newVertex.next = current;
            current.next = newVertex;
        }
    }
    
    // shift by Kth position

    public void shiftByKth(int k) {
        Node current = tail.next;
        while (k > 0) {
            current = current.next;
            k--;
        }
        tail = current;
    }

    // reversing list using tail
  
    public void reverseList() {
        Node current = tail.next;
        Node prev = null;
        Node next = null;
        while (current != tail) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        tail = current;
    }

    // Implement search function

    public boolean search(int data) {
        Node current = tail.next;
        while (current != tail && current.data != data) {
            current = current.next;
        }
        if (current == tail) {
            return false;
        } else {
            return true;
        }
    }

    // implement circular Queue

    public void circularQueue() {
        Node current = tail.next;
        while (current != tail) {
            current = current.next;
        }
        current.next = tail.next;
        tail = tail.next;
    }

    // insert front

    public void insertFront(int data) {
        Node newVertex = new Node(data);
        if (tail == null) {
            tail = newVertex;
            tail.next = tail;
        } else {
            newVertex.next = tail.next;
            tail.next = newVertex;
        }
    }

    // insert last

    public void insertLast(int data) {
        Node newVertex = new Node(data);
        if (tail == null) {
            tail = newVertex;
            tail.next = tail;
        } else {
            newVertex.next = tail.next;
            tail.next = newVertex;
            tail = newVertex;
        }
    }

    // remove front

    public void removeFront() {
        if (tail == null) {
            return;
        } else {
            tail.next = tail.next.next;
        }
    }

    // remove last

    public void removeLast() {
        if (tail == null) {
            return;
        } else {
            Node current = tail.next;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
    }

    // print list

    public void printList() {
        Node current = tail.next;
        while (current != tail) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }


}

public class CircularLinkedList {
    public static void main(String[] args){
        circularList list = new circularList();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.printList();
    }
}