package linkedList;

import java.util.Scanner;

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

    // insert element after a given element

    public void insertAfter(int data, int after) {
        Vertex newNode = new Vertex(data);
        Vertex current = head;
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
        Vertex newNode = new Vertex(data);
        if (head == null) {
            return;
        }
        if (head.data == before) {
            insertAtStart(data);
            return;
        }
        Vertex current = head;
        while (current.next != null && current.next.data != before) {
            current = current.next;
        }
        if (current.next == null) {
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // remove element after a given element

    public void removeAfter(int after) {
        if (head == null) {
            return;
        }
        Vertex current = head;
        while (current != null && current.data != after) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    // remove element before a given element

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
        Vertex current = head;
        while (current.next.next != null && current.next.next.data != before) {
            current = current.next;
        }
        if (current.next.next == null) {
            return;
        }
        current.next = current.next.next;
    }

}


public class List {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.printList();

        list.remove(5);
        list.printList();


        // if (condition) {
        //     list.insertAtStart(0);
        //     list.printList();
        // }

        System.out.println("Enter the operations you want to perform on the list");
        System.out.println("1. Insert at start");
        System.out.println("2. Insert at end");
        System.out.println("3. Insert at position");
        System.out.println("4. Insert after");
        System.out.println("5. Insert before");
        System.out.println("6. Remove at start");
        System.out.println("7. Remove at end");
        System.out.println("8. Remove at position");
        System.out.println("9. Remove after");
        System.out.println("10. Remove before");
        System.out.println("11. Print list");
        System.out.println("12. Exit");

        

        while (true) {
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted");
                    int data = sc.nextInt();
                    list.insertAtStart(data);
                    break;
                case 2:
                    System.out.println("Enter the element to be inserted");
                    data = sc.nextInt();
                    list.insert(data);
                    break;
                case 3:
                    System.out.println("Enter the element to be inserted");
                    data = sc.nextInt();
                    System.out.println("Enter the position");
                    int position = sc.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    System.out.println("Enter the element to be inserted");
                    data = sc.nextInt();
                    System.out.println("Enter the element after which the new element is to be inserted");
                    int after = sc.nextInt();
                    list.insertAfter(data, after);
                    break;
                case 5:
                    System.out.println("Enter the element to be inserted");
                    data = sc.nextInt();
                    System.out.println("Enter the element before which the new element is to be inserted");
                    int before = sc.nextInt();
                    list.insertBefore(data, before);
                    break;
                case 6:
                    list.removeAtStart();
                    break;
                case 7:
                    list.removeAtEnd();
                    break;
                case 8:
                    System.out.println("Enter the position");
                    position = sc.nextInt();
                    list.removeAtPosition(position);
                    break;
                case 9:
                    System.out.println("Enter the element after which the element is to be removed");
                    after = sc.nextInt();
                    list.removeAfter(after);
                    break;
                case 10:
                    System.out.println("Enter the element before which the element is to be removed");
                    before = sc.nextInt();
                    list.removeBefore(before);
                    break;
                case 11:
                    list.printList();
                    break;
                case 12:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
            list.printList();
            sc.close();
        }

        
    }
    
}
 
