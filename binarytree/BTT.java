class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    // inserting a node

    public void insertNode(int data) {
        root = insertNodeHelper(root, data);
    }

    private Node insertNodeHelper(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.data)
            node.left = insertNodeHelper(node.left, data);
        else
            node.right = insertNodeHelper(node.right, data);
        return node;
    }

    // find minimum

    private int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // deleting a node

    public void deleteNode(int data) {
        root = deleteNodeHelper(root, data);
    }

    private Node deleteNodeHelper(Node node, int data) {
        if (node == null)
            return node;
        if (data < node.data)
            node.left = deleteNodeHelper(node.left, data);
        else if (data > node.data)
            node.right = deleteNodeHelper(node.right, data);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            node.data = minValue(node.right);
            node.right = deleteNodeHelper(node.right, node.data);
        }
        return node;
    }

    // searing a node

    public boolean searchNode(Node key, int data) {
        if (key == null)
            return false;
        if (key.data == data)
            return true;
        if (data < key.data)
            return searchNode(key.left, data);
        else
            return searchNode(key.right, data);
    }

    // balancing AVL

    public int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    public Node rightRotate(Node node) {
        Node x = node.left;
        Node y = x.right;

        x.right = node;
        node.left = y;

        return x;
    }

    public Node leftRotate(Node node) {
        Node x = node.right;
        Node y = x.left;

        x.left = node;
        node.right = y;

        return x;
    }

    public Node balancing(Node node, int data) {
        int balance = getBalance(node);
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // inorder traversal
    private void printInorderHelper(Node node) {
        if (node == null)
            return;
        printInorderHelper(node.left);
        System.out.print(node.data + " ");
        printInorderHelper(node.right);
    }

    public void printInoder() {
        printInorderHelper(root);
        System.out.println();
    }

    // preorder traversal
    private void printPreorderHelper(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorderHelper(node.left);
        printPreorderHelper(node.right);
    }

    public void printPreoder() {
        printPreorderHelper(root);
        System.out.println();
    }

    // post order traversal

    private void printPostorderHelper(Node node) {
        if (node == null)
            return;
        printPostorderHelper(node.left);
        printPostorderHelper(node.right);
        System.out.print(node.data + " ");
    }

    public void printPostoder() {
        printPostorderHelper(root);
        System.out.println();
    }

}

public class BTT {
    public static void main(String[] args) {
        // System.out.println("Hello world");

        BinaryTree tree = new BinaryTree();
        tree.insertNode(5);
        tree.insertNode(10);
        tree.insertNode(12);
        tree.insertNode(15);

        tree.deleteNode(10);
        tree.printInoder();

        System.out.println(tree.root.data);
    }
}