class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int maxArea = 0;

        while(left< right ){
            int minLength = Math.min(height[left],height[right]);
            maxArea = Math.max((minLength*(right-left)),maxArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}