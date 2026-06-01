class Solution {

    int minutes = 0;

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[rows][cols];

        int freshOranges = 0;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            boolean anyInfected = false;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                int r = curr[0];
                int c = curr[1];

                for (int dir[] : directions) {
                    int nextrow = r + dir[0];
                    int nextcol = c + dir[1];

                    if (nextrow >= 0 && nextrow < rows && nextcol >= 0 && nextcol < cols) {
                        if (grid[nextrow][nextcol] == 1 && !vis[nextrow][nextcol]) {
                            vis[nextrow][nextcol] = true;
                            grid[nextrow][nextcol] = 2;
                            q.add(new int[] { nextrow, nextcol });
                            freshOranges--;
                            anyInfected = true;

                        }
                    }
                }
            }
            if (anyInfected) {
                minutes++;
            }
        }
        return freshOranges>0? -1 : minutes ;
    }
}