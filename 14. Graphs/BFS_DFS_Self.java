import java.util.*;
// import java.collections.LinkedList;

class Graph {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    Graph(int vertices) {
        V = vertices;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);  // Undirected graph
    }

    void BFS(int start) {
        boolean vis[] = new boolean[adj.size()];
        // add first element in the queue
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        // recursively process the following:
        while(!q.isEmpty()) {
            int curr = q.poll();
            // mark curr as visited
            if(!vis[curr]) {
                System.out.print(curr + " -> ");
                vis[curr] = true;
                // add its neighbours in the queue
                ArrayList<Integer> neigh = adj.get(curr);
                q.addAll(neigh);
            }
        }
    }

    void DFS(int start) {
        // Complete DFS function here
        boolean vis[] = new boolean[adj.size()];
        int curr = start;
        dfsHelper(curr, vis);
    }

    void dfsHelper(int curr, boolean vis[]) {
        if(!vis[curr]) {
            System.out.print(curr + " ");
            vis[curr] = true;
            ArrayList<Integer> neigh = adj.get(curr);
            for(int neighbour: neigh){
              if(!vis[neighbour]) {
                    dfsHelper(neighbour, vis);
                }
            }
        }
    }

    void displayGraph() {
        System.out.println("Adjacency List:");

        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");

            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
public class BFS_DFS_Self {
    public static void main(String[] args) {

        Graph g = new Graph(5);

        // Adding edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        // Display adjacency list
        g.displayGraph();

        int start = 0;

        System.out.println("\nBFS Traversal:");
        g.BFS(start);

        System.out.println("\nDFS Traversal:");
        // g.DFS(start);
    }
}

/*
Expected Output:

Adjacency List:
0 -> 1 2
1 -> 0 3 4
2 -> 0 4
3 -> 1
4 -> 1 2

BFS Traversal:
0 1 2 3 4

DFS Traversal:
0 1 3 4 2

*/