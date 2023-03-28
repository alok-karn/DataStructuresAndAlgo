package linkedList;
class Vertex {
    int data;
    Vertex next;

    Vertex(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Vertex head;

    public LinkedList() {
        this.head = null;
    }

    // add element to end of list
    public void insert(int data) {
        Vertex newNode = new Vertex(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Vertex current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // remove element from list

    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Vertex current = head;

        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            return;
        } else {
            current.next = current.next.next;
        }
    }

    // display the list
    public void printList() {
        Vertex current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // insert element to front of list

    public void insertAtStart(int data) {
        Vertex newNode = new Vertex(data);
        newNode.next = head;
        head = newNode;
    }


    // remove element from front of list

    public void removeAtStart() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // remove element from end of list

    public void removeAtEnd() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Vertex current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // insert element at a given position

    public void insertAtPosition(int data, int position) {
        Vertex newNode = new Vertex(data);
        if (position == 0) {
            // newNode.next = head;
            // head = newNode;
            // return;
            insertAtStart(data);
            return;
        }
        Vertex current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // remove element at a given position

    public void removeAtPosition(int position) {
        if (position == 0) {
            removeAtStart();
            return;
        }
        Vertex current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    


}


public class List {

    public static void main(String args[]) {
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.printList();

        list.remove(5);
        list.printList();
    }
    
}
 
