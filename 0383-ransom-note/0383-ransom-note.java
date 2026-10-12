class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> charMap = new HashMap<>();
      

        for(int i = 0 ; i < magazine.length();i++){
            charMap.put(magazine.charAt(i),charMap.getOrDefault(magazine.charAt(i), 0)+1);
        }
        for(int i = 0 ; i < ransomNote.length();i++){

            char c = ransomNote.charAt(i);

            int count = charMap.getOrDefault(c,0);

            if(count <= 0){
                return false;
            }

            charMap.put(c,count-1);
            
            
        }

        return true;
    }
}