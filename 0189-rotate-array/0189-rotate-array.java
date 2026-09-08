class Solution {
    public void rotate(int[] nums, int k) {
        // int[] arr = new int[nums.length];

        // k = k%nums.length;
        // int n = 0;
        // for(int i=nums.length-k ; i <nums.length; i++){
        //     arr[n] = nums[i];
        //     n++;
        // }
        // for(int i= 0  ; i <nums.length-k; i++){
        //     arr[n] = nums[i];
        //     n++;
        // }

        // for(int i= 0  ; i <nums.length; i++){
        //     nums[i] = arr[i];
            
        // }
        int n =nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }

    public void reverse(int[] nums1, int start, int end){

        while(end>start){
            int temp = nums1[start];
            nums1[start] = nums1[end];
            nums1[end] = temp;
            start++;
            end--;
        }
    }
}