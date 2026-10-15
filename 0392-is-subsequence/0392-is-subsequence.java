class Solution {
    public boolean isSubsequence(String s, String t) {
         int sc = 0;
         int tc = 0;

         if(t.length() < s.length()){
            return false;
         }
         if(s.length() == 0){
            return true;
         }

         for(int i = 0; i < t.length();i++ ){
            if(s.charAt(sc) == t.charAt(tc) && sc < s.length()){
                sc++;
                tc++;
                if(sc == s.length()){
            return true;
         }

            }
            else{
                tc++;
            }
         }

         if(sc == s.length()){
            return true;
         }

        return false;
    }
}