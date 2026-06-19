public class CountSubString {
    
    static class Node{
        Node[] children = new Node[26];
        boolean eow;

        public Node(){

            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insertTrie(String word){

        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static int countNode(Node root){
        int count = 0;
        
        if(root == null){
            return 0;
        }
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null){
                count += countNode(root.children[i]);
                
            }
        }
        return 1+count;
    }


    public static void main(String[] args){
       

        String key = "ababa";

        for (int i = 0; i < key.length(); i++) {
            insertTrie(key.substring(i));
        }

        System.out.print(countNode(root));
        
    }
}
