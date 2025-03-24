public class SinglyLinkedList {
	private NodeS head;
	
	public SinglyLinkedList() {
		head = null;
	}
	
	public boolean push(int value) {
		NodeS newNodeS = new NodeS(value);
		newNodeS.next = head;
		head = newNodeS;
		return true;
	}
	
	public boolean insert(NodeS prevNodeS, int value) {
		if (prevNodeS == null) {
			return false;
		} else {
			prevNodeS.next = new NodeS(value, prevNodeS.next);
			return true;
		}
	}
	
	public boolean append(int value) {
		NodeS newNodeS = new NodeS(value);
		
		if (head == null) {
			head = newNodeS;
		} else {
			NodeS temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = newNodeS;
		}
		return true;
	}
	
	public int getValue(int position) {
		if (position < 0)
			return Integer.MIN_VALUE;
		
		NodeS temp = head;
		
		for (int i = 0; i < position; ++i) {
			if (temp == null)
				return Integer.MIN_VALUE;
			temp = temp.next;
		}
		
		return temp.data;
	}
	
	public NodeS getNode(int position) {
		if (position < 0)
			return null;
		
		NodeS temp = head;
		
		for (int i = 0; i < position; ++i) {
			if (temp == null)
				return null;
			temp = temp.next;
		}
		
		return temp;
	}
	
	public int getPosition(int value) {
		NodeS temp = head;
		int i = 0;
		
		while (temp != null) {
			if (temp.data == value)
				return i;
			temp = temp.next;
			++i;
		}
		
		return -1;
	}
	
	public int getPosition(NodeS value) {
		if (value == null)
			return -1;
		
		NodeS temp = head;
		int i = 0;
		
		while (temp != null) {
			if (temp == value)
				return i;
			temp = temp.next;
			++i;
		}
		
		return -1;
	}
	
	public boolean removeNode(int position) {
		if (position < 0)
			return false;
		if (position == 0) {
			head = head.next;
			return true;
		}
		
		NodeS temp = head;
		
		for (int i = 0; i < position - 1; ++i) {
			if (temp == null)
				return false;
			temp = temp.next;
		}
		
		temp.next = temp.next.next;
		return true;
	}
	
	public void printList() {
		for (NodeS temp = head; temp != null; temp = temp.next)
			System.out.print(temp.data + " ");
		System.out.println();
	}
}