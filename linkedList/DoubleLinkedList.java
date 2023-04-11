package linkedList;

class Vertex {
    Vertex next;
    Vertex prev;
    int data;

    Vertex() {
        next = null;
        prev = null;
    }

    Vertex(int data) {
        this.data = data;
        next = null;
        prev = null;
    }

}

class Double_Linked_List {
    Vertex head;
    Vertex tail;

    public Double_Linked_List() {
        this.head = null;
        this.tail = null;
    }

    // insert front

    public void insertFront(int data) {
        Vertex newVertex = new Vertex(data);
        if (head == null) {
            head = newVertex;
            tail = newVertex;
        } else {
            newVertex.next = head;
            head.prev = newVertex;
            head = newVertex;
        }
    }

    // insert back

    public void insertBack(int data) {
        Vertex newVertex = new Vertex(data);
        if (head == null) {
            head = newVertex;
            tail = newVertex;
        } else {
            tail.next = newVertex;
            newVertex.prev = tail;
            tail = newVertex;
        }
    }

    // remove front 

    public void removeFront() {
        if (head == null) {
            return;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // remove back

    public void removeBack() {
        if (head == null) {
            return;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // insert after 

    public void insertAfter(int data, int after) {

        Vertex newVertex = new Vertex(data);
        Vertex current = head;

        while (current != null && current.data != after) {
            current = current.next;
        }

        if (current == null) {
            return;
        } else {
            newVertex.next = current.next;
            current.next = newVertex;
            newVertex.prev = current;
            newVertex.next.prev = newVertex;
        }

    }
    
    // insert before

    public void insertBefore(int data, int before) {

        Vertex newVertex = new Vertex(data);
        Vertex current = head;

        while (current != null && current.data != before) {
            current = current.next;
        }

        if (current == null) {
            return;
        } else {
            newVertex.next = current;
            newVertex.prev = current.prev;
            current.prev.next = newVertex;
            current.prev = newVertex;
        }

    }

    // remove after

    public void removeAfter(int after) {

        Vertex current = head;

        while (current != null && current.data != after) {
            current = current.next;
        }

        if (current == null) {
            return;
        } else {
            current.next = current.next.next;
            current.next.prev = current;
        }

    }


    // remove before

    public void removeBefore(int before) {

        Vertex current = head;

        while (current != null && current.data != before) {
            current = current.next;
        }

        if (current == null) {
            return;
        } else {
            current.prev = current.prev.prev;
            current.prev.next = current;
        }

    }





    // print list

    public void printList() {
        Vertex current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}

public class DoubleLinkedList {
    
    public static void main(String[] args) {

        Double_Linked_List list = new Double_Linked_List();

        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);
        list.insertFront(4);
        list.insertBack(5);

        list.printList();

        System.out.println(" Coded with love:  ❤️ ❤️ ❤️ ");
        
    }
    
}

