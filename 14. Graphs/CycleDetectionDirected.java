import java.util.ArrayList;

public class CycleDetectionDirected {
    static class Edge {
        int src;
        int dest;
        
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    boolean hasCycleDirected(ArrayList<Edge>[] graph) {
        boolean result;
        boolean[] vis = new boolean[graph.length];
        boolean[] stk = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(helperHasCycleDirected(graph, i, vis, stk)) {
                    return true;
                }
            }
        }
        return result;
    }

    void helperHasCycleDirected(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] path){
        // add element into the path
        vis[curr] = true;
        path[curr] = true; 

        
        // visit each neighbour of current node.
        for(Edge e: graph[curr]) {
            Edge neigh = e;

            // if node was never visited, mark it as visited, and proceed to next neighbour
            if(!vis[neigh]) {
                if(helperHasCycleDirected(graph, neigh, vis, stk)) {
                    return true;
                }
            }

            // else if an element already found in path, cycle exists!
            else if(path[neigh.dest]) {
                return true;
            }
        }

        // remove element from the (stack) path.
        path[curr] = false;
        return false;
    }

    public static void main(String[] args) {
    
        // Graph 1: Complex directed graph with multiple cycles
        ArrayList<Edge>[] Graph1 = new ArrayList[10];

        for (int i = 0; i < Graph1.length; i++) {
            Graph1[i] = new ArrayList<>();
        }

        Graph1[0].add(new Edge(0, 1));
        Graph1[0].add(new Edge(0, 2));

        Graph1[1].add(new Edge(1, 3));
        Graph1[1].add(new Edge(1, 4));

        Graph1[2].add(new Edge(2, 5));
        Graph1[2].add(new Edge(2, 6));

        Graph1[3].add(new Edge(3, 7));
        Graph1[4].add(new Edge(4, 5));

        Graph1[5].add(new Edge(5, 6));
        Graph1[5].add(new Edge(5, 8));

        Graph1[6].add(new Edge(6, 2));  // Cycle: 2 -> 6 -> 2

        Graph1[7].add(new Edge(7, 8));
        Graph1[8].add(new Edge(8, 9));

        Graph1[9].add(new Edge(9, 3));  // Cycle: 3 -> 7 -> 8 -> 9 -> 3
        Graph1[9].add(new Edge(9, 5));  // Additional cycle paths

    }
}
