import org.w3c.dom.Node;

public class SubtreeOfTree {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data  = data;
            this.left = null;
            this.right = null;

        }
    }

    static class BinaryTree {
    
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // public static boolean isSubTree(int nodes[], int nodes2[]){
            
        // }
        
    }

    public static void main(String args[]) {
        int nodes[] = {1, 2, -1, -1, 3, 4, 5, -1, -1, -1, -1};

        int nodes2[] = {1,2,-1,-1,3,-1,-1};


		
		BinaryTree tree = new BinaryTree();
		 Node newNode = tree.buildTree(nodes); 

         tree.idx = -1;
         Node newNode2  = tree. buildTree(nodes2);
		 System.out.println(newNode.data);
         System.out.println(newNode2.data);
    }
}                              
