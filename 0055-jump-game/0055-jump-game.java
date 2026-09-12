class Solution {
    public boolean canJump(int[] nums) {
        int val = 0;
        
        for(int i = 0; i < nums.length ; i++){
            if(i > val){
                return false;
            }

            val = Math.max(val,(i+nums[i]));
        }
        if(val >= nums.length-1){
            return true;
        }

        return true;
    }
}