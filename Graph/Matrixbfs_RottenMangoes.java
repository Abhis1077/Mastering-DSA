import java.util.*;

public class Matrixbfs_RottenMangoes {

    static int minutes = 0;

    public static void BfsMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[rows][cols];

        int freshOrange = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();
            boolean anyInfected = false;
            for (int i = 0; i < size; i++) {
            
                int[] curr = q.remove();

                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nextrow = r + dir[0];
                    int nextcol = c + dir[1];

                    if (nextrow >= 0 && nextrow < rows && nextcol >= 0 && nextcol < cols) {
                        if (!vis[nextrow][nextcol] && grid[nextrow][nextcol] == 1) {
                            grid[nextrow][nextcol] = 2;
                            q.add(new int[] { nextrow, nextcol });
                            vis[nextrow][nextcol] = true;
                            freshOrange--;
                            anyInfected = true;

                        }
                    }
                }

            }

            if (anyInfected) {
                minutes++;
            }
        }
        if (freshOrange > 0) {
            minutes = -1;
        }

    }

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;

        // Creating the grid graph structure
        // int[][] grid = new int[rows][cols];

        // // Filling the grid with states (e.g., 0 = Empty, 1 = Fresh, 2 = Rotten)
        // grid[0] = new int[]{2, 1, 0}; // Row 0
        // grid[1] = new int[]{1, 1, 0}; // Row 1
        // grid[2] = new int[]{0, 1, 1}; // Row 2

        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        BfsMatrix(grid);
        System.out.print(minutes);

        // Your graph is ready! You can now run BFS directly on this matrix.
        // System.out.println("Value at row 1, col 0: " + grid[1][0]);
    }
}
