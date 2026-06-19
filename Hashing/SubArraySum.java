import java.util.HashMap;

public class SubArraySum {

    public static int findSubArray(int nums[], int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if(map.containsKey(currSum-k)){
                count = count + map.get(currSum-k);
            }

            if(map.containsKey(currSum)){
                map.put(currSum, map.get(currSum)+1);
            }
            else{
                map.put(currSum, 1);
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = {10,2,-2,-20,10};
        int k = -10;
        System.out.print(findSubArray(nums,k));
    }
    
}
