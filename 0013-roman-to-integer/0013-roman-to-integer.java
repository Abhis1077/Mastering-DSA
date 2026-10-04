class Solution {

    private int getValue(char ch){
        return switch (ch){
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };

    }
    public int romanToInt(String s) {

        //FIRST BRUTE FORCE APPROACH
        // HashMap<Character, Integer> map = new HashMap<>();
        
        // map.put('I',1);
        // map.put('V',5);
        // map.put('X',10);
        // map.put('L',50);
        // map.put('C',100);
        // map.put('D',500);
        // map.put('M',1000);

        // int sum = 0;

        // for(int i = 0 ; i < s.length();i++){
        //     if(i <s.length()-1 && map.get(s.charAt(i+1)) > map.get(s.charAt(i))){
        //         sum += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
        //         i++;
        //     }
        //     else{
        //         sum += map.get(s.charAt(i));
        //     }
        // }

        // return sum;
        int sum = 0;
        int prev = 0;

        for(int i = s.length()- 1 ; i >= 0 ; i--){
            int curr = getValue(s.charAt(i));
            if(curr < prev){
                sum -= curr;
            }
            else{
                sum += curr;
            }
            prev = curr;
        }

    return sum;
    }
}