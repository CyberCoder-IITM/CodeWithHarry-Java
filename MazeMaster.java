import java.util.Arrays;
import java.util.Collections;

/**
 * MazeMaster - A standalone program that generates a random maze 
 * using Depth-First Search and backtracking algorithms.
 */
public class MazeMaster {
    private final int width;
    private final int height;
    private final int[][] maze;

    public MazeMaster(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new int[this.width][this.height];
        generateMaze(0, 0);
    }

    private void generateMaze(int cx, int cy) {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, width) && between(ny, height) && (maze[nx][ny] == 0)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }

    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    public void display() {
        for (int i = 0; i < height; i++) {
            // draw the north edge
            for (int j = 0; j < width; j++) {
                System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < width; j++) {
                System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
            }
            System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < width; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    }

    public static void main(String[] args) {
        int x = args.length >= 1 ? Integer.parseInt(args[0]) : 15;
        int y = args.length >= 2 ? Integer.parseInt(args[1]) : 10;
        MazeMaster mazeObj = new MazeMaster(x, y);
        System.out.println("\n--- GENERATED RECURSIVE MAZE ---\n");
        mazeObj.display();
    }
}
