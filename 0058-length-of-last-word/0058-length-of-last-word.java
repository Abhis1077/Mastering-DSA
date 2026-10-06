class Solution {
    public int lengthOfLastWord(String s) {
        int curr = 0;
        for(int i = s.length()-1 ; i >= 0 ;i--){
            
            if(s.charAt(i) != ' '){
                curr++;
            }
            else if (curr != 0){
                break;
            }
        }
        
        return curr;
    }
}