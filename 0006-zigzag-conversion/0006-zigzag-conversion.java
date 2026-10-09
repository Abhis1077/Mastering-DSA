class Solution {
    public String convert(String s, int numRows) {

        if ( numRows == 1 || numRows >= s.length()){
            return s;
        }

        StringBuilder[] row = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
                row[i] = new StringBuilder(); 
            }

        int currRow = 0;
        boolean goingDown =false;

        for(int i = 0 ; i < s.length();i++){
            if(currRow == 0 || currRow == numRows -1){
                goingDown = !goingDown;
            }
            
               row[currRow].append(s.charAt(i));

            if (goingDown) {
                    currRow++;
                } else {
                    currRow--;
                }
        }

        StringBuilder sbf = new StringBuilder();

        for(StringBuilder sb : row){
            sbf.append(sb);
        }

        return sbf.toString();        
    }
}