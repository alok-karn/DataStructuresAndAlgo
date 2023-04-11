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

    public void remove() {
        if (tail == null) {
            return;
        } else {
            tail.next = tail.next.next;
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