import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
     static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Travel to destination by destination of nodes recursively
    // that's why use Recursion
    // for every node from first try to see if e.dest is visited.

    static void dfs(ArrayList<Edge>[] graph) {
        int curr = 0;
        boolean[] vis = new boolean[graph.length];
        dfsHelper(graph, curr, vis);
    }

    static void dfsHelper(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " "); // visit current
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) { // loop is important here.
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsHelper(graph, e.dest, vis);
            }
        }
    }

  public static void main(String[] args) {
        int v = 5; // vertices
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        } 

        /*
         * Graph looks like this:
         *
         *      (5)
         *   0 ------ 1
         *   | \      |
         * (2)|  \(1) (3)
         *   |    \   |
         *   2 --- 3 --4
         *    \   /
         *    (4)\ /
         *        4
         */

        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 2));
        graph[0].add(new Edge(0, 3, 1));

        // Vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 4, 3));

        // Vertex 2
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 3, 4));

        // Vertex 3 
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 4));
        graph[3].add(new Edge(3, 4, 1));

        // Vertex 4 
        graph[4].add(new Edge(4, 1, 3));
        graph[4].add(new Edge(4, 3, 1));

        // Print neightbors of 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.src + " -> " + e.dest + " (wt = " + e.wt + ")");
        }

        dfs(graph);
    }
}