class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0,len = 0;

        boolean[] count = new boolean[256];

        while(right < s.length()){

            while(count[s.charAt(right)]){
                count[s.charAt(left)] = false;
                left++;
            }
            count[s.charAt(right)] = true;
            len = Math.max(len, right-left+1);
            right++;
        }
        return len;
    }
}