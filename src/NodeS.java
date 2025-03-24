public class NodeS {
	int data;
	NodeS next;
	
	public NodeS(int data) {
		this(data, null);
	}
	
	public NodeS(int data, NodeS next) {
		this.data = data;
		this.next = next;
	}
}
