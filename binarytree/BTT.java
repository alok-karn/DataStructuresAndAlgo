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

    // find the number of external, internal and total number of nodes
    // swap the children of binary node
    // find the largest and smallest element in a binary tree
    // find the sibling of a node
    // convert a sorted LL into a balanced BST

    // find the external node

    public int externalNode(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return externalNode(node.left) + externalNode(node.right);
    }

    // find the internal node

    public int internalNode(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 0;
        return 1 + internalNode(node.left) + internalNode(node.right);
    }

    // find the total number of nodes

    public int totalNode(Node node) {
        if (node == null)
            return 0;
        return 1 + totalNode(node.left) + totalNode(node.right);
    }

    // swap the children of binary node

    public void swapChildren(Node node) {
        if (node == null)
            return;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        swapChildren(node.left);
        swapChildren(node.right);
    }

    // find the largest and smallest element in a binary tree

    public int largestElement(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int res = node.data;
        int lres = largestElement(node.left);
        int rres = largestElement(node.right);
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    public int smallestElement(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;
        int res = node.data;
        int lres = smallestElement(node.left);
        int rres = smallestElement(node.right);
        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }

    // find the sibling of a node

    public void sibling(Node node, int data) {
        if (node == null)
            return;
        if (node.left != null && node.left.data == data) {
            if (node.right != null)
                System.out.println(node.right.data);
            else
                System.out.println("No sibling");
        }
        if (node.right != null && node.right.data == data) {
            if (node.left != null)
                System.out.println(node.left.data);
            else
                System.out.println("No sibling");
        }
        sibling(node.left, data);
        sibling(node.right, data);
    }

    // convert a sorted LL into a balanced BST

    public Node sortedLLtoBST(Node head) {
        if (head == null)
            return null;
        Node mid = getMiddle(head);
        Node node = new Node(mid.data);
        if (head == mid)
            return node;
        node.left = sortedLLtoBST(head);
        node.right = sortedLLtoBST(mid.right);
        return node;
    }

    public Node getMiddle(Node node) {
        if (node == null)
            return node;
        Node slow = node;
        Node fast = node;
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    // to check if two binary trees are identical or not

    public boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null)
            return (node1.data == node2.data && isIdentical(node1.left, node2.left)
                    && isIdentical(node1.right, node2.right));
        return false;
    }

    // to check if the tree is BST or not

    public boolean isBST(Node node) {
        return isBSTHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data < min || node.data > max)
            return false;
        return (isBSTHelper(node.left, min, node.data - 1) && isBSTHelper(node.right, node.data + 1, max));
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