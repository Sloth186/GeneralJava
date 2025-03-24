public class StackLL {
	private NodeS top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(int data) {
		top = new NodeS(data, top);
	}
	
	public int pop() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		
		NodeS temp = top;
		top = top.next;
		return temp.data;
	}
	
	public int top() {
		return top.data;
	}
	
	public int size() {
		int size = 0;
		NodeS temp = top;
		
		while (temp != null) {
			++size;
			temp = temp.next;
		}
		
		return size;
	}
	
	public void update(int position, int newData) {
		int iterations = size() - position;
		if (!isEmpty() && iterations >= 0 && position >= 0) {
			NodeS temp = top;
			for (int i = 0; i < iterations; ++i)
				temp = temp.next;
			temp.data = newData;
		}
	}
	
	public void printStack() {
		for (NodeS temp = top; temp != null; temp = temp.next)
			System.out.print(temp.data + " ");
		System.out.println();
	}
}