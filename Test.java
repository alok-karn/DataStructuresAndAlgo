// implementing circular linked list

class Vertex {
    Vertex next;
    int data;

    public Vertex(int data) {
        this.data = data;
    }

}

class circularList {
    Vertex tail;



    public void insert(int data) {
        Vertex newVertex = new Vertex(data);
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

    public void insertAfter(int data, int after) {
        Vertex newVertex = new Vertex(data);
        Vertex current = tail.next;
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


    // insert last

    public void insertLast(int data) {
        Vertex newVertex = new Vertex(data);
        if (tail == null) {
            tail = newVertex;
            tail.next = tail;
        } else {
            newVertex.next = tail.next;
            tail.next = newVertex;
            tail = newVertex;
        }
    }
    // print list

    public void printList() {
        Vertex current = tail.next;
        while (current != tail) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
}