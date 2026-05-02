public class QueueCircular {
    static class Queue{
		
		static int arr[];
		static int rear;
		static int size;
		static int front;
		
		Queue(int size){
			this.size = size;
			arr = new int[size];
			rear = -1;
			front = -1;
		}
		
		
		public static boolean isEmpty(){
			return rear == -1 && front == -1;
		}
		
		public static boolean isFull(){
			return front== (rear+1)%size;
		}
		
		public static void add(int data){
			if(isFull()){
				System.out.println("Full queue");
				return;
			}
            if(front == -1){
                front = 0;
            }
			rear = (rear+1)%size;
			arr[rear] = data;
		}
		
		public static int remove(){
			if(isEmpty()){
				System.out.println("Empty queue");
				return -1;
			}
			int top = arr[front];

            if(front == rear){
                front = rear = -1;
            }else{
                front = (front+1)%size;
            }
			
			return top;
		}
		
		public static int peek(){
			if(isEmpty()){
				System.out.println("Empty queue");
				return -1;
			}
			
			return arr[front];
		}
		
	}
	
	
	public static void main(String args[]){
		Queue q = new Queue(5);
		q.add(1);
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
