import java.util.ArrayList;
import java.util.PriorityQueue;

class DijkstrasAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // we have to create "comparable" pairs of src - dest.
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override 
        public int compareTo(Pair other) {
            return Integer.compare(this.path, other.path); // sort pairs ascending.
        }
    }

    static void dijkstrasAlgorithm(ArrayList<Edge>[] graph, int src) {
        // initialize other distances
        int dist[] = new int[graph.length];
        for(int i = 0; i < dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE; // set to infinity.
            }
        }        
        Pair first = new Pair(src, 0); // starts with zero distance.
        boolean vis[] = new boolean[graph.length];


        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(first);
        
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            // visit current node if not visited.
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                // process neighbours of current node.
                for(int i = 0; i < graph[curr.n].size(); i++) {
                    Edge nei = graph[curr.n].get(i);
                    int u = nei.src;
                    int v = nei.dest;
                    int wt = nei.wt;

                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v])); // next pair might not be neighbour -> add next pair.
                    }         
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String args[]) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected weighted graph: every undirected edge is stored twice.
        addEdge(graph, 0, 1, 5);
        addEdge(graph, 0, 2, 2);
        addEdge(graph, 0, 3, 1);
        addEdge(graph, 1, 4, 3);
        addEdge(graph, 2, 3, 4);
        addEdge(graph, 3, 4, 1);

        System.out.println("Weighted graph:");
        System.out.println("    (5)       (3)");
        System.out.println("  0 --- 1 -------- 4");
        System.out.println("  |   /          /");
        System.out.println("(2)| (1)      (1)/");
        System.out.println("  2 --- 3 --------");
        System.out.println("      (4)");

        System.out.println("\nSSSP from source 0:");
        dijkstrasAlgorithm(graph, 0);
    }

    static void addEdge(ArrayList<Edge>[] graph, int src, int dest, int wt) {
        graph[src].add(new Edge(src, dest, wt));
        graph[dest].add(new Edge(dest, src, wt));
    }
}