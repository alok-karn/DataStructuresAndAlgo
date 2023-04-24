

class StackDataa {
    final int size = 100;
    int[] arr = new int[size];

    int top = -1;

    public StackDataa() {
        top = -1;
    }

    boolean isFull() {
        return (top == size - 1) ? true : false;
    }

    boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    void push(int x) {
        if (isFull()) {
            return;
        } else {
            arr[++top] = x;
        }
    }

    int pop() {
        if (isEmpty()) {
            return 0;
        } else {
            int x = arr[top--];
            return x;
        }
    }

    int length() {
        return top + 1;
    }

    void display() {
        for (int i = 0; i < length(); i++) {
            System.out.println(arr[i]);
        }
    }
}

class QueueUsingStack {
    StackDataa list1;
    StackDataa list2;
    
    public QueueUsingStack() {
        list1 = new StackDataa();
        list2 = new StackDataa();
    }
    
    public void enQueue(int item) {
        list1.push(item);
    }
    
    public int deQueue() {
        if(list2.isEmpty()) {
            while(!list1.isEmpty()) {
                list2.push(list1.pop());
            }
        }
        
        if(!list2.isEmpty()) {
            return list2.pop();
        } else {
            throw new RuntimeException("Queue is Empty");
        }
    }
    
    public boolean isEmpty() {
        return list1.isEmpty() && list2.isEmpty();
    }
    
    public int size() {
        return list1.length() + list2.length();
    }
    
    public void display() {
        list1.display();
        list2.display();
    }
}

public class StackIntoQueue {

    public static void main(String args[]) {
        QueueUsingStack list = new QueueUsingStack();

        list.enQueue(10);
        list.enQueue(20);
        list.enQueue(30);
        list.enQueue(40);
        list.enQueue(50);

        list.display();
    }
    
}
