class Solution {
    public int jump(int[] nums) {
        int curr = 0;
        int far = 0;
        int count = 0;

        for(int i = 0 ; i < nums.length-1;i++){
            far = Math.max(far , (i+nums[i]));
           
           if( i == curr){
            curr = far;
            count++;
            if(curr >= nums.length-1){
            break;
           }
           }
            
        }
        
        return count;
    }
}