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

    // SUBSTRING APPROACH
    // public int strStr(String haystack, String needle) {
    //     int n1 = haystack.length();
    //     int n2 = needle.length();


    //     if(n2>n1) return -1;

    //     for(int i = 0 ; i <=n1-n2;i++){
    //         if(haystack.substring(i,i+n2).equals(needle)){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public int[] LPS(String str){

        int suf = 1;
        int pre = 0;
        int n = str.length();

        int[] lpsArr = new int[n];

        while(suf < n){
            if(str.charAt(pre) == str.charAt(suf)){
                lpsArr[suf] = pre+1;
                pre++;
                suf++;
                
            }
            else{
                if(pre == 0 ){
                    lpsArr[suf] = 0;
                    suf++;
                }
                else{
                    pre = lpsArr[pre-1];
                }
            }
        }

        return lpsArr;
    }


    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();

        int[] lpsArr = new int[n2];

        lpsArr = LPS(needle);

        int first = 0;
        int sec = 0;

        while(first < n1 && sec < n2){
            if(haystack.charAt(first) == needle.charAt(sec)){
                first++;
                sec++;
                
            }
            else{
                if(sec == 0){
                    first++;
                }
                else{
                    sec = lpsArr[sec-1];
                }
            }
        }
        if(sec == n2){
            return first-sec;
        }
        else
        return -1;
    }
}