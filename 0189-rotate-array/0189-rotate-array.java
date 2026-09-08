class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        k = k%nums.length;
        int n = 0;
        for(int i=nums.length-k ; i <nums.length; i++){
            arr[n] = nums[i];
            n++;
        }
        for(int i= 0  ; i <nums.length-k; i++){
            arr[n] = nums[i];
            n++;
        }

        for(int i= 0  ; i <nums.length; i++){
            nums[i] = arr[i];
            
        }
        

    }
}