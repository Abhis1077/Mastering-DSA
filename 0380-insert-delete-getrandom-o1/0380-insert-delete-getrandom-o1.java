// class RandomizedSet {
//         Map<Integer,Integer> map = new HashMap<>();

//         List<Integer> list = new ArrayList<>();

//         Random rand = new Random();
//     public RandomizedSet() {
        
//     }
    
//     public boolean insert(int val) {
//         if(map.containsKey(val)){
//             return false;
//         }
//         map.put(val,list.size());
//         list.add(val);

//         return true;
        
//     }
    
//     public boolean remove(int val) {
//         if(!map.containsKey(val)){
//             return false;
//         } 
//         int targetIndex = map.get(val);
//         int lastElement = list.get(list.size()-1);
//         list.set(targetIndex,lastElement);
//         map.put(lastElement,targetIndex);
//         list.remove(list.size()-1);
//         map.remove(val);

//         return true;

//     }
    
//     public int getRandom() {
//         int randomIndex = rand.nextInt(list.size());

//         return list.get(randomIndex);
//     }
// }

import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        // Map the value to its index at the end of the array
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        // 1. Get the index of the value to remove
        int targetIndex = map.get(val);
        
        // 2. Grab the last element in the list
        int lastElement = list.get(list.size() - 1);
        
        // 3. Move the last element into the target index position
        list.set(targetIndex, lastElement);
        map.put(lastElement, targetIndex);
        
        // 4. Remove the last element from list and the target value from map
        list.remove(list.size() - 1);
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        // Pick a random index from 0 to list.size() - 1
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */