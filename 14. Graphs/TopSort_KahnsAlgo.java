
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TopSort_KahnsAlgo {

    /*
        KAHN'S ALGORITHM (BFS)

        1. Calculate indegree of every vertex.
        2. Add all vertices with indegree 0 into the queue.
        3. Remove a vertex from the queue and print it.
        4. Visit its neighbours and reduce their indegree by 1.
        5. If a neighbour's indegree becomes 0, add it to the queue.
        6. Repeat until the queue becomes empty.

        Important:
        - Topological sorting is possible only for a DAG.
        - A DAG must have at least one source (indegree 0).
        - A DAG must have at least one sink (outdegree 0).
        - If all vertices are not processed, the graph contains a cycle.
    */

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        // Initialize adjacency lists
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
                    GRAPH DIAGRAM

                    5 --------> 0
                    |           ^
                    |           |
                    v           |
                    2 ------> 3 |
                                |
                    4 --------> 0
                    |           ^
                    |           |
                    v           |
                    1 <---------+

                    Edges:
                    2 -> 3
                    3 -> 1
                    4 -> 0
                    4 -> 1
                    5 -> 0
                    5 -> 2

                    Vertices: 0, 1, 2, 3, 4, 5

                    Initial indegree:
                    0 = 2
                    1 = 2
                    2 = 1
                    3 = 1
                    4 = 0
                    5 = 0
        */

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Calculate indegree of every vertex
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {

        for (int i = 0; i < graph.length; i++) {

            int v = i;

            // Visit all neighbours of vertex v
            for (int j = 0; j < graph[v].size(); j++) {

                Edge e = graph[v].get(j);

                // Increase indegree of destination vertex
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {

        // Step 1: Create indegree array
        int indeg[] = new int[graph.length];

        // Step 2: Calculate indegree
        calcIndeg(graph, indeg);

        // Step 3: Create queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Step 4: Add all vertices having indegree 0
        for (int i = 0; i < indeg.length; i++) {

            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // Count processed vertices to detect cycles
        int count = 0;

        // Step 5: BFS traversal
        while (!q.isEmpty()) {

            // Remove vertex with indegree 0
            int curr = q.remove();

            // Print current vertex
            System.out.print(curr + " -> ");

            count++;

            // Visit all neighbours of current vertex
            for (int i = 0; i < graph[curr].size(); i++) {

                Edge e = graph[curr].get(i);

                // Reduce indegree of neighbour
                indeg[e.dest]--;

                // If indegree becomes 0, add to queue
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        // Step 6: Check whether all vertices were processed
        if (count != graph.length) {
            System.out.println("\nCycle detected! Topological sorting is not possible.");
        }
    }

    public static void main(String[] args) {

        int V = 6;

        // Create adjacency list
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        System.out.println("Topological Sorting using Kahn's Algorithm:");

        topSort(graph);
    }
}
