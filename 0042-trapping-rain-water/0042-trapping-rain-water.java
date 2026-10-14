class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int count = 0;
        // int[] maxLeft = new int[n];
        // int[] maxRight = new int[n];

        // maxLeft[0] = 0;
        // maxRight[n-1] = 0;

        // for( int i = 1; i < n ; i++){
        //     maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        // }

        // for( int j = n-2; j >= 0 ; j--){
        //     maxRight[j] = Math.max(maxRight[j+1], height[j+1]);
        // }
        

        // for(int i = 0; i < n;i++){
        //     if((Math.min(maxRight[i],maxLeft[i])-height[i]) > 0){
        //         count += (Math.min(maxRight[i],maxLeft[i])-height[i]);
        //     }
        // }

        int maxHeight = 0;
        int index  = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for( int j = 0; j < n ; j++){
            if(maxHeight < height[j]){
            maxHeight = height[j];
            index = j;
            }
        }


        for( int i = 0; i < index ; i++){
            if(maxLeft > height[i]){
                count += maxLeft-height[i];
            }else{
                maxLeft = height[i];
            }
        }

        for( int i = n-1; i > index ; i--){
            if(maxRight > height[i]){
                count += maxRight-height[i];
            }else{
                maxRight = height[i];
            }
        }
        return count;
    }
}