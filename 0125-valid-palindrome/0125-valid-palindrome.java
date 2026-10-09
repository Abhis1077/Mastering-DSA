class Solution {
    public boolean isPalindrome(String s) {

        // s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0 ;
        int end = s.length() -1;

        // for(int i = 0 ; i < s.length()/2 ; i++){
        //     if(s.charAt(start) == s.charAt(end) ){
        //         end--;
        //         start++;
        //     }else{
        //         return false;
        //     }
        // }
        // return true;

        //OPTIMISED

        while(start < end){
            char cStart = s.charAt(start);
            char cEnd = s.charAt(end);

            if(!Character.isLetterOrDigit(cStart)){
                start++;
            }
            else if(!Character.isLetterOrDigit(cEnd)){
                end--;
            }
            else{
                if(Character.toLowerCase(cStart) != Character.toLowerCase(cEnd)){
                    return false;
                }
                start++;
                end--;
            }
        }
            return true;
    }
}