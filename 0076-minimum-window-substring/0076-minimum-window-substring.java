class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()){
            return "";
        }

        int left = 0, right = 0, k = 0, ans = Integer.MAX_VALUE, index = -1;
        String str = "";

        int[] count = new int[256];

        while(k<t.length()){
            count[t.charAt(k)]++;
            k++;
        } 

        
        while(right < s.length()){

            count[s.charAt(right)]--;

            if(count[s.charAt(right)] >= 0){
                    k--;
            }

            while( k == 0 && left <= right){
                if(ans > right-left+1){
                    ans = right-left+1;
                    index = left;
                }
                count[s.charAt(left)]++;
                if(count[s.charAt(left)] > 0){
                    k++;
                }
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE?"":s.substring(index, index+ans);
    }
}