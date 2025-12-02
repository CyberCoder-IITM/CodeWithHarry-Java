import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

/**
 * A Recursive Backtracker Maze Generator.
 * Renders a perfect maze using Unicode block characters.
 */
public class ConsoleMazeGen {

    private final int width;
    private final int height;
    private final int[][] grid;
    private final Random rand = new Random();

    // Directions: North, South, East, West
    private final int[] DY = {-1, 1, 0, 0};
    private final int[] DX = {0, 0, 1, -1};

    // Bitmasks for walls
    // 1 = North, 2 = South, 4 = East, 8 = West
    private final int OPPOSITE[] = {2, 1, 8, 4}; 

    public ConsoleMazeGen(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int[height][width];
        generate(0, 0);
    }

    private void generate(int cy, int cx) {
        // 1. Randomize directions
        List<Integer> directions = new ArrayList<>();
        for (int i = 0; i < 4; i++) directions.add(i);
        Collections.shuffle(directions);

        // 2. Iterate through randomized directions
        for (int dir : directions) {
            int ny = cy + DY[dir];
            int nx = cx + DX[dir];

            // 3. Check if neighbor is valid and not visited
            if (isValid(ny, nx) && grid[ny][nx] == 0) {
                // 4. Carve path (using bitwise OR to mark direction)
                // Mark current cell as having a path to neighbor
                grid[cy][cx] |= (1 << dir);
                // Mark neighbor as having a path to current
                grid[ny][nx] |= OPPOSITE[dir];
                
                // 5. Recursive step
                generate(ny, nx);
            }
        }
    }

    private boolean isValid(int y, int x) {
        return (y >= 0 && y < height && x >= 0 && x < width);
    }

    public void display() {
        // Top Border
        System.out.print(" ");
        for (int i = 0; i < width * 2 - 1; i++) System.out.print("_");
        System.out.println();

        for (int y = 0; y < height; y++) {
            System.out.print("|"); // Left Border
            for (int x = 0; x < width; x++) {
                // Determine if there is a South wall or East wall
                boolean south = (grid[y][x] & 2) != 0; 
                boolean east = (grid[y][x] & 4) != 0;

                // Simple Unicode Logic for "cells"
                // If path south, print space, else underscore
                String cell = south ? " " : "_"; 
                
                // If path east, connect, else pipe
                if (east) {
                    System.out.print((south ? " " : "_") + cell);
                } else {
                    System.out.print((south ? " " : "_") + "|");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int w = 20;
        int h = 10;
        
        System.out.println("Generating " + w + "x" + h + " Recursive Maze...\n");
        ConsoleMazeGen maze = new ConsoleMazeGen(w, h);
        maze.display();
        System.out.println("\nAlgorithm: Recursive Backtracker (DFS)");
    }
}