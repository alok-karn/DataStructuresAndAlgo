
import java.util.Scanner;
class stackData {

    int MAX = 1000;
    int top;
    char[] arr = new char[MAX];

    public stackData() {
        top = -1;
    }

    public stackData(int len) {
        this.MAX = len;
    }

    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    boolean isFull() {
        return (top == MAX - 1) ? true : false;
    }

    void push(char x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");
        } else {
            arr[++top] = x;
            System.out.println(x + " is Pushed into the stack");
        }
    }

    char pop() {
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
            return 0;
        } else {
            char x = arr[top--];
            return x;
        }
    }

    int length() {
        return top + 1;
    }

    void displayStack(String str) {
        System.out.println(str);
    }
}

class PostfixCalc {

    private String input;
    private String output = "";
    private stackData theStack;

    public PostfixCalc(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new stackData(stackSize);
    }

    public int doCalc() {
        int j;
        int num1, num2, interAns;

        for (j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.displayStack("For " + ch + " ");
            if (ch >= '0' && ch <= '9') {
                theStack.push((int) (ch - '0'));
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }

}

public class PostfixEval {
    public static void main(String args[]) {
    }
}
