import static java.lang.IO.println;

public class LL {
    Node head;
    private int size;

    LL(){
        this.size = 0;
    }
    public class Node{
        String data; 
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }
    public void removeFirst(){
        size--;
        if(head == null){
            return;
        }
        head = this.head.next;
    }

    public void removeLast(){
        size--;
        if(head==null){
            return;

        }
        Node currNode = head;
        while(currNode.next.next!= null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }
    


    public void printList(){
        Node currNode = head;

        while (currNode != null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        println();
    }

//    public void reverseList(){
//        Node prevNode = head;
//        Node currNode = head.next;
//
//        while(currNode!=null) {
//            Node nextNode = currNode.next;
//            currNode.next = prevNode;
//            prevNode = currNode;
//            currNode = nextNode;
//
//        }
//        head.next = null;
//        head = prevNode;

 //   }

    public Node recuReverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = recuReverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public int getSize(){
        return size;
    }
    public static void main(String[] args){
     LL list = new LL();
     list.addFirst("1");
     list.addLast("2");
     list.addLast("3");
     list.addLast("4");
     //System.out.print(list.getSize());
     list.printList();
     list.head = list.recuReverse(list.head);
     list.printList();

    }
}
