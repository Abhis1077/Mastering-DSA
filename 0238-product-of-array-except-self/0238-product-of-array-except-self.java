class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] answer = new int[n];
        int leftP = 1;
        int rightP = 1;
        answer[0] = 1;
        for(int i = 1;i<n;i++){
            answer[i] = nums[i-1]*leftP;
            leftP = answer[i];
        }

        for(int i = n-2;i>=0;i--){
            rightP = nums[i+1]*rightP;
            answer[i] = answer[i]*rightP;
        }

        return answer;
    }
}