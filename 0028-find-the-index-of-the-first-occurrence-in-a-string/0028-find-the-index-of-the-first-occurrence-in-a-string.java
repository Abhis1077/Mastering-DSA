class Solution {

    // BRUTE FORCE
    // public boolean compare(String haystack,String needle, int idx){
    //     int n1 = haystack.length();
    //     int n2 = needle.length();

    //     for(int i = 0 ; i <n2 ; i++){
    //         if(idx>=n1) return false;
    //         if(haystack.charAt(idx++) != needle.charAt(i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public int strStr(String haystack, String needle) {
    //     int n1 = haystack.length();

    //     for(int i = 0 ; i < n1;i++){
    //         if(haystack.charAt(i) == needle.charAt(0)){
    //             if(compare(haystack, needle, i)){
    //                 return i;
    //             }
    //         }
    //     }
    //     return -1;
    // }


    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();


        if(n2>n1) return -1;

        for(int i = 0 ; i <=n1-n2;i++){
            if(haystack.substring(i,i+n2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}