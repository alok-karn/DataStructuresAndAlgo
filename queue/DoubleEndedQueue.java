

class DoubleQueue {
    private int maxSize = 1000;
    private long[] queArray;
    private int front;

    private int rear;
    private int nItems;

    public DoubleQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }



    public void insertLeft(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;

        System.out.println(j + " inserted at rear" + rear);
        nItems++;
    }

    public void insertRight(long j) {
        if (front == 0) {
            front = maxSize;
        }
        queArray[--front] = j;
        System.out.println(j + " inserted at front" + front);

        nItems++;
    }

    public long removeLeft() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        System.out.println(nItems + " removed at front" + front);
        nItems--;
        return temp;
    }

    public long removeRight() {
        long temp = queArray[rear--];
        if (rear == -1) {
            rear = maxSize - 1;
        }
        System.out.println(nItems + " removed at rear" + rear);
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

}
public class DoubleEndedQueue {
    public static void main(String[] args) {

        DoubleQueue theQueue = new DoubleQueue(5);

        theQueue.insertLeft(10);
        theQueue.insertLeft(20);
        theQueue.insertLeft(30);
        theQueue.insertLeft(40);
        theQueue.insertLeft(50);

        theQueue.insertRight(60);
        theQueue.insertRight(70);
        theQueue.insertRight(80);
        theQueue.insertRight(90);
        theQueue.insertRight(100);

        while (!theQueue.isEmpty()) {
            long n = theQueue.removeLeft();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
        while (!theQueue.isEmpty()) {
            long n = theQueue.removeRight();
            System.out.print(n);
            System.out.print(" ");
        }
        
    }
    
}

