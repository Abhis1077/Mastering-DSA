

import org.w3c.dom.Node;

public class trieBasics {

    static class Node {
        Node[] children = new Node[26];
        boolean eow;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insertTrie(String words){
        Node curr = root;
        for (int i = 0; i < words.length(); i++) {
            int idx = words.charAt(i)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            // if(i == words.length()-1){
            //     curr.children[idx].eow = true;
            // }

            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean searchTrie(String words){
        Node curr = root;
        for (int i = 0; i < words.length(); i++) {
            int idx = words.charAt(i)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for (int i = 1; i <=key.length(); i++) {
            String firstPart = key.substring(0,i);
            String secPart = key.substring(i);

            if(searchTrie(firstPart) && wordBreak(secPart)){
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix){
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"the","there","any","their"};

        for (String string : words) {
            insertTrie(string);
        }

        String key = "anytheir";

        System.out.print(wordBreak(key));
        System.out.print(startsWith("to"));

        
        // System.out.print(searchTrie("thei"));

    }
}
