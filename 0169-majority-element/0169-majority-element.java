class Solution {
    public int majorityElement(int[] nums) {
//         int n = nums.length;

//         int majEle = 0;

//         Arrays.sort(nums);
//         int current = nums[0];

//         int c = 1;
//         for(int i = 1 ; i<n ; i++)
//         {
//             if(current == nums[i]){
//                 c++;
//             }
//             else
//             {
//                 if(c > n/2){
//                     return current;
//                 }
//                 current = nums[i];
//                 c = 1;
//             }
//         }
//                 if(c > n/2){
//                     majEle =  current;
//                 }
//  return majEle;

//OPTIMAL METHOD

int current = 0;
int count = 0;

for(int num : nums){
    if(count == 0){
        current = num;
    }
    if(num == current){
        count++;
    }
    else{
        count--;
    }
}
return current;
    }
}