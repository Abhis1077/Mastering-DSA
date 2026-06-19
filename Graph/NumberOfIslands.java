public interface NumberOfIslands {

    public static int countISlands(char[][] grid){
        if(grid.length == 0 ){
            return 0;
        }
        int islandsCount = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1'){
                    islandsCount++;
                    sinkIslands(grid, i, j);
                }
            }
        }
        return islandsCount;
    }
    
    public static void sinkIslands(char[][] grid,int r, int c){
        
        int rows = grid.length;
        int cols = grid[0].length;

        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';

        sinkIslands(grid, r - 1, c); // Up
        sinkIslands(grid, r + 1, c); // Down
        sinkIslands(grid, r, c - 1); // Left
        sinkIslands(grid, r, c + 1);

        
    }

    

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(countISlands(grid));
    }
}
