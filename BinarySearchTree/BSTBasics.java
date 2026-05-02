import java.util.*;

import org.w3c.dom.Node;

public class BSTBasics {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){

        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if (root == null) {
        return;
    }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }

    public static boolean BinarySearch(Node root, int key){
        if (root == null) {
        return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
         return BinarySearch(root.left, key);
        }
        else
        {
        return BinarySearch(root.right, key);  
         }                                                                                                                 
    }

    public static Node deleteNode(Node root, int val){
        if(root == null){
            return null;
        }
        if(root.data > val){
            root.left = deleteNode(root.left, val);
        }
        else if (root.data <val){
            root.right = deleteNode(root.right, val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.right == null) return root.left;
            if(root.left == null) return root.right;

            Node IS = InorderSuccessor(root.right);
            root.data = IS.data;
            root.right =  deleteNode(root.right, IS.data);
        }
        return root;
    }

    public static Node InorderSuccessor(Node root ){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void PrintInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(x>root.data){
            PrintInRange(root.right, x, y);
        }
        else if(root.data>y){
            PrintInRange(root.left, x, y);
        }
        else{
            PrintInRange(root.left, x, y);
            System.out.print(root.data + " ");
            PrintInRange(root.right, x, y);
            System.out.print(root.data + " ");
        }

    }

     public static void printPath(ArrayList<Integer> path){
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i)+ "->");
            }
            System.out.println();
        }

        public static void PrintLeafToPath(Node root, ArrayList<Integer> path){
            if(root == null){
                return;
            }
            path.add(root.data);

            if(root.left == null && root.right == null){
                printPath(path);
            }
            else{
                PrintLeafToPath(root.left, path);
                PrintLeafToPath(root.right,path);
            }

            path.remove(path.size()-1);
        }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        // deleteNode(root,3);
        // inorder(root);
        System.out.println();
        PrintLeafToPath(root, new ArrayList<>());
        //PrintInRange(root, 4, 7);
        //System.out.print(BinarySearch(root,10));
    }
}
