import java.util.*;

public class BinaryTreeBasics {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
	
	static class BinaryTree{
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
	}

    public static void PreOrder(Node root){
		
		if(root == null){
			System.out.print("-1"+" ");
			return;
		}
        System.out.print(root.data+" ");
		PreOrder(root.left);
		PreOrder(root.right);
	}

    public static void Inorder(Node root){
		if(root == null){
			return;
		}
		Inorder(root.left);
		System.out.print(root.data+ " " );
		Inorder(root.right);
	}

    public static void PostOrder(Node root){
		if(root == null){
			return;
		}
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+" ");
	}

    public static void LevelOrder(Node root){
		if(root == null){
			return;
		}
        Queue<Node> q = new LinkedList<>();
		q.add(root);
        q.add(null);
		while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

        
	}
    public static int CountNode(Node root){
        
            if(root == null){
                return 0;
            }

            int leftNode = CountNode(root.left);
            
           int rightNode =  CountNode(root.right);
            

            return leftNode+rightNode+1;
        }

        public static int SumNode(Node root){
        
            if(root == null){
                return 0;
            }
            int sumRoot = root.data;

            int leftNode = SumNode(root.left);
            
           int rightNode =  SumNode(root.right);
            

            return leftNode+rightNode+sumRoot;
        }

        public static int HeightOfTree(Node root){
            if(root == null){
                return 0;
            }

        //     int leftNode = HeightOfTree(root.left) ;
        //     leftNode++;
            
        //    int rightNode =  HeightOfTree(root.right);
        //    rightNode++;

        //    return Math.max(leftNode,rightNode);
        
        // better way
        int leftHeight = HeightOfTree(root.left);
       int rightHeight = HeightOfTree(root.right);
       return Math.max(leftHeight, rightHeight) + 1;
        }

        public static int DiameterOfTree(Node root){
            if(root == null){
                return 0;
            }

            int leftdiam = DiameterOfTree(root.left);
            
           int rightdiam =  DiameterOfTree(root.right);

           int Nodeheight = HeightOfTree(root.left) + HeightOfTree(root.right) +1;

           return Math.max(Math.max(leftdiam,rightdiam),Nodeheight);
        }

        static class TreeInfo 
        {
         int height;
         int diam;

         TreeInfo(int height, int diam){
            this.height = height;
            this.diam = diam;
         }
            
        }

        public static TreeInfo DiameterOfTree2(Node root){
            if(root == null){
                return new TreeInfo(0,0);
            }
            TreeInfo left = DiameterOfTree2(root.left);
            TreeInfo right = DiameterOfTree2(root.right);

            int myHeight = Math.max(left.height,right.height) + 1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.height + right.height +1;
            int mydiem = Math.max((diam3),Math.max(diam1,diam2));

          TreeInfo tree = new TreeInfo(myHeight, mydiem);

           return tree;
        }



    public static void main(String args[]) {
        int nodes[] = {1, 2, -1, -1, 3, 4, 5, -1, -1, -1, -1};
		
		BinaryTree tree = new BinaryTree();
		 Node newNode = tree.buildTree(nodes); 

         TreeInfo info = DiameterOfTree2(newNode);
		 //System.out.println(newNode.data);
		 //LevelOrder(newNode);
         System.out.println(info.diam);

    }
}