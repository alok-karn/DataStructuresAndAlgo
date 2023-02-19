
import java.util.*;

class stackData {

    final int MAX = 1000;
    int top;
    int[] arr = new int[MAX];

    public stackData() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    boolean isFull() {
        return (top == MAX - 1) ? true : false;
    }

    void push(int x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");
        } else {
            arr[++top] = x;
            System.out.println(x + " is Pushed into the stack");
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
            return 0;
        } else {
            int x = arr[top--];
            return x;
        }
    }

    int length() {
        return top + 1;
    }
}

public class Stack {

    public static void main(String args[]) {
        // System.out.println("Hello World");
        Scanner userInput = new Scanner(System.in);
        stackData list = new stackData();

        boolean condition = true;
        int ch;

        int val;

        System.out.println("Enter the choice: ");
        ch = userInput.nextInt();

        while (condition) {
            System.out.println("Enter the value");
            val = userInput.nextInt();
            if (ch == 1) {
                list.push(val);
                System.out.println("Enter the choice again: ");
                ch = userInput.nextInt();
                if (ch == 0) {
                    condition = false;
                }
            } else {
                break;
            }
        }

        // if (list.isEmpty()) {
        // System.out.println("list is Empty");
        // } else {
        // System.out.println("List is not Empty");
        // }

        // list.push(10);
        // list.push(20);
        // list.push(30);
        // list.push(40);
        // list.push(50);

        // int ele = list.pop();
        // System.out.println(ele + " is popped out");
        System.out.println("The length of list is " + list.length());
    }
}
