class Solution {


    public void gameOfLife(int[][] board) {
        
        int n = board[0].length;
        int m = board.length;
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        for(int i = 0; i < m ; i++ ){
            for(int j = 0; j < n ; j++){
                int liveCount = 0;
                for(int k = 0 ; k <8 ; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if( nr >=0 && nr < m && nc >=0 && nc < n){
                        if(board[nr][nc] == 1 || board[nr][nc] == 2){
                            liveCount++;
                        }
                    }

                }
                if(board[i][j] == 1){
                    if(liveCount < 2 || liveCount > 3){
                        board[i][j] = 2;
                    }
                }else{
                    if(liveCount == 3){
                        board[i][j] = 3;
                    }
                }

            }


        }

        for(int i = 0; i < m ; i++ ){
            for(int j = 0; j < n ; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
}