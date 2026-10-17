class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] arr = new int[2];
        // int s = 0;
        // int e = 1;

        // int n = numbers.length;

        // while(s < n && e < n){
        //     if((numbers[s]+numbers[e]) < target){
        //         e++;
        //         s++;
        //     }else if((numbers[s]+numbers[e]) > target){
        //         s--;
        //     }
        //     else{
        //         arr[0] = s+1;
        //         arr[1] = e+1;
        //         break;
        //     }
        // }

        int left  = 0;
        int right = numbers.length -1;

        while(left < right){
            if((numbers[left]+ numbers[right]) < target){
                left++;
            }else if((numbers[left]+ numbers[right]) > target){
                right--;
            }else{
                arr[0] = left+1;
                arr[1] = right+1;
                break;
            }
        }
        return arr;
    }
}