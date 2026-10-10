class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int end  = 0;
        int count = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                count = Math.min(count, i-start+1);
                sum -=nums[start];
                start++;
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}