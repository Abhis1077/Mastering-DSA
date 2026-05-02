public class QueueA{
	
	static class Queue{
		
		static int arr[];
		static int rear;
		static int size;
		
		Queue(int size){
			this.size = size;
			arr = new int[size];
			rear = -1;
		}
		
		
		public static boolean isEmpty(){
			return rear == -1;
		}
		
		public static boolean isFull(){
			return rear== size-1;
		}
		
		public static void add(int data){
			if(isFull()){
				System.out.println("Full queue");
				return;
			}
			rear++;
			arr[rear] = data;
		}
		
		public static int remove(){
			if(isEmpty()){
				System.out.println("Empty queue");
				return -1;
			}
			
			int front = arr[0];
			for(int i = 0;i<rear;i++){
				arr[i] = arr[i+1];
			}
			rear--;
			return front;
		}
		
		public static int peek(){
			if(isEmpty()){
				System.out.println("Empty queue");
				return -1;
			}
			
			return arr[0];
		}
		
		
	}
	
	
	public static void main(String args[]){
		Queue q = new Queue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		while(!q.isEmpty()){
			int result = q.remove();
			System.out.println(result);
		}
	}
}