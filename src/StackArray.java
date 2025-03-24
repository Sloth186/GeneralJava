public class StackArray {
	private final int SIZE;
	private final int[] STACK;
	private int top;
	
	public StackArray(int size) {
		SIZE = size;
		STACK = new int[SIZE];
		top = -1;
	}
	
	public StackArray() {
		this(10);
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE;
	}
	
	public boolean push(int value) {
		if (isFull())
			return false;
		else {
			STACK[++top] = value;
			return true;
		}
	}
	
	public int pop() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		else {
			int temp = STACK[top];
			STACK[top--] = 0;
			return temp;
		}
	}
	
	public int eleCount() {
		return top;
	}
	
	public int eleAccess(int position) {
		if (isEmpty() || position < 0 || position > top)
			return Integer.MIN_VALUE;
		else
			return STACK[position];
	}
	
	public boolean eleUpdate(int position, int newValue) {
		if (isEmpty() || position < 0 || position > top)
			return false;
		else {
			STACK[position] = newValue;
			return true;
		}
	}
	
	public void printStack() {
		for (int value : STACK)
			System.out.print(value + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		StackArray stack = new StackArray();
		stack.printStack();
		stack.push(2);
		stack.printStack();
		stack.push(3);
		stack.printStack();
		stack.eleUpdate(0, 5);
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.push(8);
		stack.printStack();
		stack.eleUpdate(0, 40);
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.push(2);
		stack.printStack();
		stack.eleUpdate(0, 20);
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.push(3);
		stack.printStack();
		stack.eleUpdate(0, 60);
		stack.printStack();
		stack.pop();
		stack.printStack();
	}
}