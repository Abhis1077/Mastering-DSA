class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = 0;
        maxRight[n-1] = 0;

        for( int i = 1; i < n ; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }

        for( int j = n-2; j >= 0 ; j--){
            maxRight[j] = Math.max(maxRight[j+1], height[j+1]);
        }
        int count = 0;

        for(int i = 0; i < n;i++){
            if((Math.min(maxRight[i],maxLeft[i])-height[i]) > 0){
                count += (Math.min(maxRight[i],maxLeft[i])-height[i]);
            }
        }
        return count;
    }
}