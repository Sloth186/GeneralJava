public class QueueArray {
	private final int SIZE;
	private final int[] QUEUE;
	private int top;
	
	public QueueArray(int size) {
		SIZE = size;
		QUEUE = new int[SIZE];
		top = -1;
	}
	
	public QueueArray() {
		this(10);
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE;
	}
	
	public boolean enQueue(int value) {
		if (isFull())
			return false;
		else {
			QUEUE[++top] = value;
			return true;
		}
	}
	
	public int deQueue() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		else {
			int temp = QUEUE[0];
			for (int i = 1; i < top; ++i)
				QUEUE[i - 1] = QUEUE[i];
			QUEUE[top--] = 0;
			return temp;
		}
	}
	
	public int eleCount() {
		return top;
	}
	
	public void printQueue() {
		for (int i = 0; i < top; ++i)
			System.out.print(QUEUE[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		QueueArray queue = new QueueArray();
		queue.printQueue();
		queue.enQueue(3);
		queue.printQueue();
		queue.enQueue(7);
		queue.printQueue();
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
		System.out.println("Empty? " + queue.isEmpty());
		queue.enQueue(4);
		queue.printQueue();
		System.out.println("# of queues: " + queue.eleCount());
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		System.out.println("Full? " + queue.isFull());
		queue.printQueue();
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
		System.out.println("Full? " + queue.isFull());
		System.out.println("Dequeued " + queue.deQueue());
		queue.printQueue();
	}
}
