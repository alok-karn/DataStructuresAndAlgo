
class QueueData {
    final int size = 1000;
    int[] arr = new int[size];
    int front, rear;

    public QueueData() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return (front == 1 && rear == (size - 1)) ? true : false;
    }

    boolean isEmpty() {
        return (front == -1) ? true : false;
    }

    void enQueue(int x) {
        if (isFull()) {
            System.out.println("OVERFLOW");
        } else {
            arr[++rear] = x;
            System.out.println(x + " is added to the list");
        }
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("UNDERFLOW");
            return 0;
        } else if (front == rear) {
            int ele = arr[front];
            front = -1;
            rear = -1;
            return ele;
        } else {
            int ele = arr[front];
            front++;
            return ele;
        }
    }

    void viewElements() {
        for (int i = front; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    int length() {
        return (front == rear) ? 1 : (rear - front) + 1;
    }
}

public class Queue {
    public static void main(String[] args) {
        QueueData list = new QueueData();
        list.enQueue(10);
        list.enQueue(20);
        list.enQueue(30);
        list.enQueue(40);
        list.enQueue(50);

        list.viewElements();
        list.length();

        list.deQueue();
        list.deQueue();

        list.length();
        list.viewElements();
    }
}
