class Solution {

    public boolean isSafe(char c, int i, int j, char[][] board){
        int count = 0;
        for(int m = 0; m < 9; m++ ){
            if(board[i][m] == c){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        count = 0;

        for(int n = 0; n < 9; n++ ){
            if(board[n][j] == c){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        count = 0;
        int strtRow = (i/3)*3;
        int startCol = (j/3)*3;

        for(int a = strtRow ; a < strtRow+3; a++){
            for(int b = startCol; b < startCol+3;b++){
                if(board[a][b] == c){
                count++;
            }
            if(count > 1){
                return false;
            }
            }
        } 
        return true;
    }
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9 ; i++){
            for(int j = 0 ; j <9 ; j++){
                if(board[i][j] != '.'){
                 if(!isSafe(board[i][j], i , j, board)){
                    return false;
                    }
                }
            }
        }
        return true;
    }
}