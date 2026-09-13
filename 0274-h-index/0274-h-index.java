class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        for(int i = 0 ; i < citations.length;i++){
            int k = citations.length-i;
            if(citations[i] >= k){
                return k;
            }

        }
        return 0;
    }
}