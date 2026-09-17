import java.util.*;

public class CycleDetection {
    // Edge structure for an adjacency list representation
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Checks every component of the graph.
    // If any component contains a cycle, return true.
    static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // Start DFS from every unvisited vertex
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS helper for cycle detection in an undirected graph
    // curr = current node, par = parent node from which curr was reached
    static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        // Mark current node as visited
        vis[curr] = true;

        // Check all neighbors of current node
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 1: neighbor not visited yet, keep exploring
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            // Case 2: neighbor already visited and is not the parent
            // This means we found a back edge, so a cycle exists
            } else if (e.dest != par) {
                return true;
            }
        }
        return false;
    }
    
     public static void main(String[] args) {
        int v = 5; // number of vertices

        // Create an adjacency list for each vertex
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

        // Vertex 0 connections
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 2));
        graph[0].add(new Edge(0, 3, 1));

        // Vertex 1 connections
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 4, 3));

        // Vertex 2 connections
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 3, 4));

        // Vertex 3 connections
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 4));
        graph[3].add(new Edge(3, 4, 1));

        // Vertex 4 connections
        graph[4].add(new Edge(4, 1, 3));
        graph[4].add(new Edge(4, 3, 1));

        // Print neighbors of vertex 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.src + " -> " + e.dest + " (wt = " + e.wt + ")");
        }
    }
}
