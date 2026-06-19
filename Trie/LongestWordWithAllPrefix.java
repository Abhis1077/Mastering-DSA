import org.w3c.dom.Node;

public class LongestWordWithAllPrefix {
    
    static class  Node {
    
     Node[] chilNodes = new Node[26];
     boolean eow;

     public Node(){
        for (int i = 0; i < chilNodes.length; i++) {
            chilNodes[i] = null;
        }
     }
    }

    public static Node root = new Node();

    public static void insertTrie(String word){

    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i)-'a';
        if(curr.chilNodes[idx] ==null){
            curr.chilNodes[idx] = new Node();
        }
        curr = curr.chilNodes[idx];
    }
    curr.eow = true;
    }

    public static String ans = "";

    public static String longestString(Node root,StringBuilder currStr){

        
        if(root == null){
            return null;
        }

        for (int i = 0; i < root.chilNodes.length; i++) {
            if(root.chilNodes[i] != null && root.chilNodes[i].eow){
                currStr.append((char)(i+'a'));
                if(currStr.length()>ans.length()){
                    ans = currStr.toString();
                }
                longestString(root.chilNodes[i], currStr);
                currStr.deleteCharAt(currStr.length()-1);
            }
        } 
        return ans;
    }

    public static void main(String[] args){
        String[] words = {"a","ap","app","appl","apple","apply","banana"};

        for (int i = 0; i < words.length; i++) {
            insertTrie(words[i]); 
        }

        StringBuilder currStr = new StringBuilder();

        System.out.print(longestString(root,currStr));
    }
}
