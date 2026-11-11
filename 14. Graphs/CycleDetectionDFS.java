import java.util.*;

class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class CycleDetectionDFS {

    boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean isCycleUtil(ArrayList<Edge>[] graph, int curr,
                        boolean[] vis, boolean[] stack) {

        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // If destination is already in recursion stack
            if(stack[e.dest]) {
                return true;
            }

            // If destination is not visited
            if(!vis[e.dest] &&
               isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        // Remove current vertex from recursion stack
        stack[curr] = false;

        return false;
    }

    public static void main(String args[]) {

        int V = 4;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize graph
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add directed edges
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        CycleDetectionDFS obj = new CycleDetectionDFS();

        if(obj.isCycle(graph)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}
