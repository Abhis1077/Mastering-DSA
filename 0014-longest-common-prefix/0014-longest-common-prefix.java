class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs, (a, b) -> Integer.compare(a.length(), b.length()));
       String str = strs[0];
       int count = 0;
        for(int i = 0 ; i < str.length(); i++ ){
            for(int j = 1; j < strs.length ; j++){
                if(str.charAt(i) != strs[j].charAt(i)){
                    return str.substring(0, i);
                }
                else{
                    if(j == strs.length-1){
                        count++;
                    }
                }
            }
        }
        return str;
    }
}