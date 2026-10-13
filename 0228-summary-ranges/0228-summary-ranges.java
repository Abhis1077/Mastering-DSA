class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> range = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            int start = nums[i];

            while(i+1 < nums.length && nums[i+1] == nums[i]+1 ){
                i++;
            }

            if(start == nums[i]){
                range.add(Integer.toString(nums[i]));
            }
            else{
                range.add(start+ "->"+nums[i]);
            }
        }

        return range;
    }
}