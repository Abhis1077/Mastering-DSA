import java.util.Stack;
public class StackPB{
	public static void PushAtBottom(int data, Stack<Integer> s){
		if(s.isEmpty()){
			s.push(data);
			return;
		}
		
		int top = s.pop();
		PushAtBottom(data,s);
		s.push(top);
	}
	
	public static void main (String args[]){
	Stack<Integer> s = new Stack<>();
	s.push(1);
	s.push(2);
	PushAtBottom(3,s);

	while (!s.isEmpty()) {
		System.out.println(s.peek());
		s.pop();
	}
	}
}