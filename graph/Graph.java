// package graph;

import java.io.*;
import java.util.*;

public class Graph {
    private int node;
    private LinkedList<Integer> adj[];
    private Queue<Integer> queue;

    public Graph(int node) {
        this.node = node;
        adj = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        queue = new LinkedList<Integer>();
    }

    public void addEdge(int node, int edge) {
        adj[node].add(edge);
    }

    public void BFS(int start) {
        boolean nodes[] = new boolean[node];
        BFSUtil(start, nodes);
    }

    private void BFSUtil(int start, boolean nodes[]) {
        nodes[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            start = queue.poll();
            System.out.print(start + " ");

            for (int i = 0; i < adj[start].size(); i++) {
                int a = adj[start].get(i);
                if (!nodes[a]) {
                    nodes[a] = true;
                    queue.add(a);
                }
            }
        }
    }

    public void DFS(int start) {
        boolean nodes[] = new boolean[node];
        DFSUtil(start, nodes);
    }

    private void DFSUtil(int start, boolean nodes[]) {
        nodes[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < adj[start].size(); i++) {
            int a = adj[start].get(i);
            if (!nodes[a]) {
                DFSUtil(a, nodes);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int node = sc.nextInt();

        Graph graph = new Graph(node);

        while (true) {
            System.out.println(
                    "\nEnter the choice of operation to be performed \n.1 Add Edge \n.2 BFS \n.3 DFS \n.4 Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter the node data: ");
                    int data = sc.nextInt();

                    System.out.println("\nEnter the edge: ");
                    int edge = sc.nextInt();

                    graph.addEdge(data, edge);
                    break;
                case 2:
                    // BFS
                    System.out.println("\nEnter the starting node: ");
                    int start = sc.nextInt();

                    System.out.println("\nBFS traversal is: ");
                    graph.BFS(start);
                    break;
                case 3:
                    // DFS
                    System.out.println("\nEnter the starting node: ");
                    int startNode = sc.nextInt();

                    System.out.println("\nDFS traversal is: ");
                    graph.DFS(startNode);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
