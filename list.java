// import javax.sound.sampled.Line;

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
        this.head = null;
        this.tail = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = null;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // removing element from the list

    public void remove(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            return;
        } else {
            current.next = current.next.next;
        }
    }


    // insert element at front 

    public void insertFront(int data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    };

    // insert element at end

    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    // remove element from the front 

    public void removeFront() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // remove element from the end of list
    
    public void removeEnd() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;

    }


    // insert element at the given position

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            insertFront(data);
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }
    
    // removing element at a given position

    public void removeAtPosition(int position) {
        if (position == 0) {
            removeFront();
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
    
    // insert element after a given element

    public void insertAfter(int data, int after) {
        Node newNode = new Node(data);
        Node current = head;

        while (current != null && current.data != after) {
            current = current.next;
        }

        if (current == null) {
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // insert element before a given element

    public void insertBefore(int data, int before) {
        Node newNode = new Node(data);
        if (head == null) {
            return;
        }
        if (head.data == before) {
            insertFront(data);
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != before) {
            current = current.next;
        }
        if (current.next == null) {
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // remove after

    public void removeAfter(int after) {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null && current.data != after) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    // remove before

    public void removeBefore(int before) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            return;
        }
        if (head.next.data == before) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next.next != null && current.next.next.data != before) {
            current = current.next;
        }
        if (current.next.next == null) {
            return;
        }
        current.next = current.next.next;

    }
    
    public void reverse() {
        if (head == null) {
            return;
        }
        Node current = head;
        Node prev = null;
        Node n;

        while (current != null) {
            n = current.next;
            current.next = prev;
            prev = current;
            current = n;
        }
        tail = prev;
        head = prev;

    }

    // split the list into two equal halves

    public void split() {
        if (head == null) {
            return;
        }
        Node slow = null;
        Node fast = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node head2 = slow.next;
        slow.next = null;
        Node current = head2;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // split by the count

    public void splitCount() {
        if (head == null) {
            return;
        }
        int count = 0;
        Node current = head;
        while (current != head) {
            count++;
            current = current.next;
        }

        int half = count / 2;
        current = head;

        for (int i = 0; i < half - 1; i++) {
            current = current.next;
        }

        Node head2 = current.next;
        current.next = null;
        current = head2;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    // skip alternates

    public void skipAlternate() {
        if (head == null) {
            return;
        }
        Node current = head;
        while(current != null && current.next != null){
            current.next = current.next.next;
            current = current.next;
        }
    }

    // swap alternate node

    public void swapAlternate() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
    }

    // ascending sorting

    public void sortAscending() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void sortDescending() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.data < index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // concatenate two lists

    public LinkedList concatenate(LinkedList l1, LinkedList l2) {
        if (l1.head == null) {
            return l2;
        }
        if (l2.head == null) {
            return l1;
        }
        l1.tail.next = l2.head;
        l1.tail = l2.tail;
        return l1;
    }

    // printing the list recursively

    void display(Node t) {
        if (t == null) {
            return;
        }
        System.out.println(t.data + " ");
        display(t.next);
    }

    // skip alternate and save to other list

    public void skipAlternateStore(LinkedList list2){
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            list2.insertEnd(current.next.data);
            current.next = current.next.next;
            current = current.next;
        }
    }


}

public class list {
    
}
