import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

    // Travel to immediage neighbours first
    // LevelOrderTraversal
    // Visit root, add into queue.
    // Graph[V].ArrayList<Edge - src, dest, wt>)

    static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0); //0 vertex
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i); // graph[curr] has many edges connected.
                    q.add(e.dest); // as src is already visited, add its destination.
                }
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

        bfs(graph);
    }
}