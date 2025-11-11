import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Collections;

/**
 * Implements the A* (A-Star) pathfinding algorithm on a 2D grid.
 * Finds the shortest path from a start 'S' to an end 'E', avoiding obstacles 'X'.
 */
public class AStarPathfinder {

    // A Node represents a square on the grid
    static class Node implements Comparable<Node> {
        int x, y;
        int gCost; // Cost from start to this node
        int hCost; // Heuristic: estimated cost from this node to end
        int fCost; // gCost + hCost
        Node parent;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // The PriorityQueue will use this to sort nodes, lowest fCost first
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.fCost, other.fCost);
        }

        // Used by HashSet to check if a node is already in the set
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    private char[][] grid;
    private Node startNode;
    private Node endNode;
    private int gridWidth;
    private int gridHeight;

    public AStarPathfinder(char[][] grid) {
        this.grid = grid;
        this.gridHeight = grid.length;
        this.gridWidth = grid[0].length;

        // Find start and end nodes
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                if (grid[y][x] == 'S') {
                    startNode = new Node(x, y);
                } else if (grid[y][x] == 'E') {
                    endNode = new Node(x, y);
                }
            }
        }
    }

    /**
     * Calculates the heuristic (Manhattan distance) from one node to another.
     */
    private int calculateHeuristic(Node from, Node to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }

    /**
     * The main A* algorithm logic.
     */
    public List<Node> findPath() {
        if (startNode == null || endNode == null) {
            System.out.println("Start 'S' or End 'E' node not found on the grid.");
            return null;
        }

        // 1. Initialize the open and closed sets
        // The open set contains nodes to be evaluated, sorted by fCost
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        // The closed set contains nodes already evaluated
        HashSet<Node> closedSet = new HashSet<>();

        // 2. Add the start node to the open set
        startNode.gCost = 0;
        startNode.hCost = calculateHeuristic(startNode, endNode);
        startNode.fCost = startNode.gCost + startNode.hCost;
        openSet.add(startNode);

        // 3. Loop until the open set is empty (no path) or we find the end
        while (!openSet.isEmpty()) {
            // Get the node with the lowest fCost
            Node currentNode = openSet.poll();

            // 4. Check if we reached the end
            if (currentNode.equals(endNode)) {
                return reconstructPath(currentNode);
            }

            // Add current node to the closed set
            closedSet.add(currentNode);

            // 5. Explore neighbors
            // (Up, Down, Left, Right)
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int newX = currentNode.x + dx[i];
                int newY = currentNode.y + dy[i];

                // Check bounds and obstacles
                if (newX < 0 || newX >= gridWidth || newY < 0 || newY >= gridHeight || grid[newY][newX] == 'X') {
                    continue;
                }

                Node neighbor = new Node(newX, newY);

                // Skip if neighbor is already evaluated
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                // 6. Calculate new costs
                int tentativeGCost = currentNode.gCost + 1; // 1 is the cost to move to a neighbor

                // If this is a better path to the neighbor
                if (tentativeGCost < neighbor.gCost || !openSet.contains(neighbor)) {
                    neighbor.gCost = tentativeGCost;
                    neighbor.hCost = calculateHeuristic(neighbor, endNode);
                    neighbor.fCost = neighbor.gCost + neighbor.hCost;
                    neighbor.parent = currentNode;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        // 7. No path found
        return null;
    }

    /**
     * Traces back from the end node to the start node to get the final path.
     */
    private List<Node> reconstructPath(Node endNode) {
        List<Node> path = new ArrayList<>();
        Node current = endNode;
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path); // Reverse to get path from start to end
        return path;
    }

    /**
     * Prints the grid with the final path marked with '*'.
     */
    public void printPath(List<Node> path) {
        char[][] pathGrid = new char[gridHeight][gridWidth];
        for (int y = 0; y < gridHeight; y++) {
            System.arraycopy(grid[y], 0, pathGrid[y], 0, gridWidth);
        }

        if (path != null) {
            for (Node node : path) {
                if (pathGrid[node.y][node.x] == '.') {
                    pathGrid[node.y][node.x] = '*'; // Mark path
                }
            }
        }

        System.out.println("\n--- Pathfinding Result ---");
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                System.out.print(pathGrid[y][x] + " ");
            }
            System.out.println();
        }
    }


    // --- Main method to run the program ---
    public static void main(String[] args) {
        // 'S' = Start, 'E' = End, 'X' = Obstacle, '.' = Empty
        char[][] grid = {
            {'S', '.', '.', '.', 'X', '.', '.', '.', '.', '.'},
            {'X', 'X', 'X', '.', 'X', '.', 'X', 'X', 'X', '.'},
            {'.', '.', '.', '.', 'X', '.', 'X', '.', '.', '.'},
            {'.', 'X', 'X', 'X', 'X', '.', 'X', '.', 'X', '.'},
            {'.', '.', '.', '.', '.', '.', 'X', '.', 'X', '.'},
            {'.', 'X', 'X', 'X', 'X', 'X', 'X', '.', 'X', '.'},
            {'.', 'X', '.', '.', '.', '.', '.', '.', 'X', '.'},
            {'.', 'X', '.', 'X', 'X', 'X', 'X', 'X', 'X', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E'}
        };

        AStarPathfinder pathfinder = new AStarPathfinder(grid);
        List<Node> path = pathfinder.findPath();

        if (path != null) {
            System.out.println("Path found! Length: " + (path.size() - 1));
            pathfinder.printPath(path);
        } else {
            System.out.println("No path could be found.");
            pathfinder.printPath(null);
        }
    }
}