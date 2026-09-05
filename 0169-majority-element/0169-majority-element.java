class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int majEle = 0;

        Arrays.sort(nums);
        int current = nums[0];

        int c = 1;
        for(int i = 1 ; i<n ; i++)
        {
            if(current == nums[i]){
                c++;
            }
            else
            {
                if(c > n/2){
                    return current;
                }
                current = nums[i];
                c = 1;
            }
        }
                if(c > n/2){
                    majEle =  current;
                }
 return majEle;
    }
}