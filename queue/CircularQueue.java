class CircularData {
    final int maxSize = 1000;
    int front, rear;
    int items[] = new int[maxSize];

    CircularData() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (front == 0 && rear == maxSize - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    void insertItem(int key) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % maxSize;
            items[rear] = key;
            System.out.println("Inserted " + key);
        }
    }


    int deleteItem() {
        int key;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            key = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } /* Q has only one key, so we reset the queue after deleting it. */
            else {
                front = (front + 1) % maxSize;
            }
            return (key);
        }
    }

    void displayItems() {
        int i;

        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % maxSize)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);

        }
    }


   
}
public class CircularQueue {
    public static void main(String[] args) {
        CircularData obj = new CircularData();

        obj.insertItem(1);
        obj.insertItem(2);
        obj.insertItem(3);
        obj.insertItem(4);
        obj.insertItem(5);
        obj.insertItem(6);
        obj.displayItems();
        int key = obj.deleteItem();
       
        if(key != -1)
            System.out.println("Deleted Element is " + key);
        obj.displayItems();

        obj.insertItem(7);
        obj.displayItems();
        obj.insertItem(10);

    }
}
