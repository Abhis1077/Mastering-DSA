class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;


        for(int num : nums){
            int count = 0;
            for(int num1 : nums){
                if((num^num1) != 0){
                    count++;
                }
            }
            if(count == n-1){
                return num;
            }
        }
        
        return -1;
    }
}