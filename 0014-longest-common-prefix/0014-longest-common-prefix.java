// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 1) return strs[0];
//         Arrays.sort(strs, (a, b) -> Integer.compare(a.length(), b.length()));
//        String str = strs[0];
//        int count = 0;
//         for(int i = 0 ; i < str.length(); i++ ){
//             for(int j = 1; j < strs.length ; j++){
//                 if(str.charAt(i) != strs[j].charAt(i)){
//                     return str.substring(0, i);
//                 }
//                 else{
//                     if(j == strs.length-1){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return str;
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Loop through the characters of the very first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            // Compare against all other strings
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}