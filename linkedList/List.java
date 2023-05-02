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
    Vertex head, tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // add element to end of list
    public void insert(int data) {
        Vertex newNode = new Vertex(data);

        if (head == null) {
            head = newNode;
//            tail = newNode;
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
//        newNode.next = head;
//        head = newNode;
//        tail = newNode;

        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // insert element to end of list

    public void insertAtEnd(int data) {
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


    // remove element from front of list

    public void removeAtStart() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // remove element from end of list1


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

    // reverse the list

    public void reverse() {
        if (head == null) {
            return;
        }
        Vertex current = head;
        Vertex prev = null;
        Vertex n;
        while (current != null) {
            n = current.next;
            current.next = prev;
            prev = current;
            current = n;
        }
        tail = head;
        head = prev;
    }

    // split the list into two equal halves

    public void split() {
        if (head == null) {
            return;
        }
        Vertex slow = head;
        Vertex fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Vertex head2 = slow.next;
        slow.next = null;
        Vertex current = head2;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // split the list into 2 list by counting number of nodes

    public void splitCount() {
        if (head == null) {
            return;
        }
        int count = 0;
        Vertex current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        int half = count / 2;
        current = head;
        for (int i = 0; i < half - 1; i++) {
            current = current.next;
        }
        Vertex head2 = current.next;
        current.next = null;
        current = head2;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // rotate by kth position

    public Vertex rotate(Vertex head, int k) {
        if (head == null) {
            return null;
        }
        Vertex current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return head;
        }
        Vertex kthNode = current;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
        return head;
    }

    // compare two list

    public boolean compare(Vertex head1, Vertex head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        Vertex current1 = head1;
        Vertex current2 = head2;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        if (current1 != null || current2 != null) {
            return false;
        }
        return true;
    }

    // skip the alternate nodes

    public void skipAlternate() {
        if (head == null) {
            return;
        }
        Vertex current = head;
        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
    }

    // swap alternate nodes

    public void swapAlternate() {
        if (head == null) {
            return;
        }
        Vertex current = head;
        while (current != null && current.next != null) {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
    }
    // sorting in ascending order

    public void sortAscending() {
        if (head == null) {
            return;
        }
        Vertex current = head;
        while (current != null) {
            Vertex index = current.next;
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

    // sorting in descending order

    public void sortDescending() {
        if(head == null) {
            return;
        }
        Vertex current = head;
        while(current != null) {
            Vertex index = current.next;
            while(index != null) {
                if(current.data < index.data) {
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

    public LinkedList concatenate(LinkedList list1, LinkedList list2) {

        if (list1.head == null) {
            return list2;
        }
        if (list2.head == null) {
            return list1;
        }
        list1.tail.next = list2.head;
        list1.tail = list2.tail;
        return list1;
    }

    // printing the list recursively
    void displayList(Vertex t) {
        if (t == null) {
            return;
        }
        System.out.print(t.data + " ");
        displayList(t.next);
    }

    // skip alternate and copy the result in the another list

    public void skipAlternate2(LinkedList list2) {
        if (head == null) {
            return;
        }
        Vertex current = head;
        while (current != null && current.next != null) {
            list2.insertAtEnd(current.next.data);
            current.next = current.next.next;
            current = current.next;
        }
    }

    // count number of nodes

    public int countNodes() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Vertex current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


}


public class List {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        LinkedList list2 = new LinkedList();
        LinkedList conList = new LinkedList();

        LinkedList copyList = new LinkedList();

        list2.insertAtStart(1);
        list2.insertAtStart(2);
        list2.insertAtStart(3);


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
        System.out.println("12. Reverse list");
        System.out.println("13. Split list");
        System.out.println("14. Display Recursively");
        System.out.println("15. Skip Alternate Nodes");
        System.out.println("16. Swap Alternate Nodes");
        System.out.println("17. Split list using Count");
        System.out.println("18. Sort Ascending");
        System.out.println("19. Sort Descending");
        System.out.println("20. Concatenate List");
        System.out.println("21. Skip Alternate Node and store");
        System.out.println("22. Exit");



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
                     list.reverse();
//                    list.split();
                    break;
                case 13:
                    list.split();
                    break;
                case 14:
                    list.displayList(list.head);
                    break;
                case 15:
                    list.skipAlternate();
                    break;
                case 16:
                    list.swapAlternate();
                    break;
                case 17:
                    list.splitCount();
                    break;
                case 18:
                    list.sortAscending();
                    break;
                case 19:
                    list.sortDescending();
                    break;
                case 20:
                    conList.concatenate(list, list2);
                    conList.printList();
                    break;
                case 21:
                    list.skipAlternate2(copyList);
                    copyList.printList();
                    break;
                case 22:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
            list.printList();
//            sc.close();
        }


    }

}

