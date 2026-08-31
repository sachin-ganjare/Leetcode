import java.util.ArrayList;

public class DemoEdgeList {

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

    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();

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

        // Undirected graph stored as pairs of directed edges
        graph.add(new Edge(0, 1, 5));
        graph.add(new Edge(1, 0, 5));

        graph.add(new Edge(0, 2, 2));
        graph.add(new Edge(2, 0, 2));

        graph.add(new Edge(0, 3, 1));
        graph.add(new Edge(3, 0, 1));

        graph.add(new Edge(1, 4, 3));
        graph.add(new Edge(4, 1, 3));

        graph.add(new Edge(2, 3, 4));
        graph.add(new Edge(3, 2, 4));

        graph.add(new Edge(3, 4, 1));
        graph.add(new Edge(4, 3, 1));

        System.out.println("Edge List:");
        for (int i = 0; i < graph.size(); i++) {
            Edge e = graph.get(i);
            System.out.println(e.src + " -> " + e.dest + " (wt = " + e.wt + ")");
        }
    }
}
