import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static HashMap<Integer,Integer> majEle(int nums[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if(map.containsKey(nums[i])){
            //     map.put(nums[i], (map.get(nums[i]))+ 1);
            // }
            // else{
            //     map.put(nums[i], 1);
            // }
        
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return map;
    }
    
    public static void main(String[] args) {
        //int nums[] = {1,3,2,5,1,3,1,5,1};
        int nums[] = {1,2};
        int d = (nums.length)/3;


        HashMap<Integer,Integer> map = majEle(nums);

        for( Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue()>=d){
                System.out.println(e.getKey());
            }
       }
    }

}
