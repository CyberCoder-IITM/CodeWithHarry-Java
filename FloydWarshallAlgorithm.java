public class FloydWarshallAlgorithm {
    
}
public class FloydWarshallAlgorithm {
    // A large number representing infinity.
    // We use a safe value to prevent overflow when adding two "infinite" paths.
    final static int INF = 1000000000; 

    // Number of vertices
    private int V;
    
    // Distance matrix
    private int[][] dist;

    public FloydWarshallAlgorithm(int V, int[][] graph) {
        this.V = V;
        this.dist = new int[V][V];
        
        // 1. Initialization
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] == 0 && i != j) {
                    // Set non-existent edges (that aren't self-loops) to INF
                    this.dist[i][j] = INF;
                } else {
                    // Copy direct weights (and self-loops, which are 0)
                    this.dist[i][j] = graph[i][j];
                }
            }
        }
    }
    
    public int[][] runFloydWarshall() {
        // 2. Triple Loop
        // k is the intermediate vertex
        for (int k = 0; k < V; k++) {
            // i is the starting vertex
            for (int i = 0; i < V; i++) {
                // j is the ending vertex
                for (int j = 0; j < V; j++) {
                    
                    // Check if the path through k is shorter than the current path
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Note: The resulting matrix 'dist' will also show negative cycles
        // if dist[i][i] becomes negative for any i.
        
        return dist;
    }

    public static void main(String[] args) {
        /* Example Graph (4 vertices):
         Weights: 
         (0 -> 2) = 5
         (0 -> 3) = 10
         (1 -> 0) = 3
         (2 -> 3) = 1
         (3 -> 1) = -4  <-- Handles negative weights!
         
         Matrix Representation (0 for no edge, 0 for self-loop)
        */
        int[][] graph = {
            {0, 0, 5, 10},
            {3, 0, 0, 0},
            {0, 0, 0, 1},
            {0, -4, 0, 0}
        };
        int V = 4;

        FloydWarshallAlgorithm fw = new FloydWarshallAlgorithm(V, graph);
        int[][] result = fw.runFloydWarshall();

        System.out.println("All-Pairs Shortest Path Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (result[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(result[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}