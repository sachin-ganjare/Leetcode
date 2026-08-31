public class DemoAdjacencyMatrix {

    public static void main(String[] args) {
        int v = 5;
        int[][] graph = new int[v][v];

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

        // Undirected weighted graph
        graph[0][1] = 5;
        graph[1][0] = 5;

        graph[0][2] = 2;
        graph[2][0] = 2;

        graph[0][3] = 1;
        graph[3][0] = 1;

        graph[1][4] = 3;
        graph[4][1] = 3;

        graph[2][3] = 4;
        graph[3][2] = 4;

        graph[3][4] = 1;
        graph[4][3] = 1;

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
