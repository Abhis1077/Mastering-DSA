public  class QueueLL{
	
	public static class Node{
		int data;
		Node next;
		
		Node( int data){
			this.data = data;
			this.next = null;
		}
	}
	
	static class Queue{
		public static Node head = null;
		public static Node tail = null;
		
		public static boolean isEmpty(){
			return head == null;
		}
		
		public static void add(int data){
			Node newNode = new Node(data);
            if(head == null){
                head = tail =  newNode;
                return;
            }
			tail.next = newNode;
			tail = newNode;
			
		}
		
		public static int remove(){
			if(isEmpty()){
				System.out.println("empty queue");
				return -1;
			}
			
			int top = head.data;
			
			head = head.next;
			
			return top;
			
		}
		
		public static int peek(){
			if(isEmpty()){
				System.out.println("empty queue");
				return -1;
			}
			
			int top = head.data;
			
			return top;
		}
		
	}


    public static void main(String args[]){
		Queue q = new Queue();
		q.add(2);
		q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
			int result = q.remove();
			System.out.println(result);
		}
	}
}
