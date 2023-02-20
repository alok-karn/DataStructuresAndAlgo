
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

class IntoPost {

    private String input;
    private String output = "";
    private stackData theStack;

    public IntoPost(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new stackData(stackSize);
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }
        theStack.displayStack("End ");
        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch) {
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }
    }

}

public class InfixToPostfix {
    public static void main(String[] args) {

        String input = "1+2*4/5-7+3/6";
        String output;
        IntoPost theTrans = new IntoPost(input);
        output = theTrans.doTrans();
        System.out.println("Infix is " + input + '\n' + "Postfix is " + output);
        // System.out.println(output);
        StringBuilder revOutput = new StringBuilder(output);
        System.out.println(revOutput.reverse());

    }
}
