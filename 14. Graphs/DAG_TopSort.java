import java.util.ArrayList;
import java.util.Stack;

class DAG_TopSort {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    void topSort(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortHelper(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " -> ");
        }
    }

    void topSortHelper(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        // Visit current vertex
        vis[curr] = true;

        // Visit its neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topSortHelper(graph, e.dest, vis, s);
            }
        }

        // Push current vertex after visiting all neighbours
        s.push(curr);
    }

    public static void main(String[] args) {

        /*
                  GRAPH 1: DIRECTED ACYCLIC GRAPH (DAG)

                            0
                           / \
                          v   v
                          1   2
                         / \ / \
                        v   v   v
                        3   4   5
                        |  / \   |
                        v v   v  v
                        7     8
                        |     |
                        v     v
                        9 <---+

                  Additional edges:
                  6 -> 8
                  2 -> 6

                  Complete edge list:
                  0 -> 1, 0 -> 2
                  1 -> 3, 1 -> 4
                  2 -> 5, 2 -> 6
                  3 -> 7
                  4 -> 7, 4 -> 8
                  5 -> 8
                  6 -> 8
                  7 -> 9
                  8 -> 9

                  No cycles present.
        */

        ArrayList<Edge>[] Graph1 = new ArrayList[10];

        for (int i = 0; i < Graph1.length; i++) {
            Graph1[i] = new ArrayList<>();
        }

        // Vertex 0
        Graph1[0].add(new Edge(0, 1));
        Graph1[0].add(new Edge(0, 2));

        // Vertex 1
        Graph1[1].add(new Edge(1, 3));
        Graph1[1].add(new Edge(1, 4));

        // Vertex 2
        Graph1[2].add(new Edge(2, 5));
        Graph1[2].add(new Edge(2, 6));

        // Vertex 3
        Graph1[3].add(new Edge(3, 7));

        // Vertex 4
        Graph1[4].add(new Edge(4, 7));
        Graph1[4].add(new Edge(4, 8));

        // Vertex 5
        Graph1[5].add(new Edge(5, 8));

        // Vertex 6
        Graph1[6].add(new Edge(6, 8));

        // Vertex 7
        Graph1[7].add(new Edge(7, 9));

        // Vertex 8
        Graph1[8].add(new Edge(8, 9));

        // Vertex 9 has no outgoing edges

        DAG_TopSort obj = new DAG_TopSort();

        System.out.println("Topological Sorting:");
        obj.topSort(Graph1);
    }
}