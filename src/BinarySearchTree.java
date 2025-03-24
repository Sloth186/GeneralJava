public class BinarySearchTree {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] numbers = {20, 7, 5, 9, 2, 4, 37, 10, 29, 99, 81, 49};
		for (int num : numbers)
			bst.insert(num);

		bst.printTree();
		bst.delete(7);
		System.out.println("\n");
		bst.printTree();
	}

	public static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	Node root;
	
	public Node search (int key) {
		Node temp = root;
		
		while (temp != null && key != temp.data) {
			if (key > temp.data)
				temp = temp.right;
			else
				temp = temp.left;
		}
		
		return temp;
	}
	
	public void insert (int data) {
		Node newNode = new Node(data);
		Node temp = root;
		Node tempParent = null;

		if (temp == null) {
			root = newNode;
			return;
		}
		
		while (temp != null) {
			tempParent = temp;
			
			if (data > temp.data)
				temp = temp.right;
			else
				temp = temp.left;
		}

		if (data > tempParent.data)
			tempParent.right = newNode;
		else
			tempParent.left = newNode;
	}

	public void delete(int data) {
		Node temp = root;
		Node tempParent = null;
		boolean tempIsLeftChild = false;

		while (temp != null && temp.data != data) {
			tempParent = temp;

			if (data < temp.data) {
				temp = temp.left;
				tempIsLeftChild = true;
			} else {
				temp = temp.right;
				tempIsLeftChild = false;
			}
		}

		if (temp == null)
			return;

		if (temp.left == null && temp.right == null) {
			if (temp == root)
				root = null;
			else if (tempIsLeftChild)
				tempParent.left = null;
			else
				tempParent.right = null;
		} else if (temp.left == null) {
			if (temp == root)
				root = temp.right;
			else if (tempIsLeftChild)
				tempParent.left = temp.right;
			else
				tempParent.right = temp.right;
		} else if (temp.right == null) {
			if (temp == root)
				root = temp.left;
			else if (tempIsLeftChild)
				tempParent.left = temp.left;
			else
				tempParent.right = temp.left;
		} else {
			Node successor = temp.right;
			Node successorParent = temp;

			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}

			if (successorParent == temp) {
				// when the immediate right child is the candidate
			} else {
				successorParent.left = successor.right;

				if (temp == root)
					root = successor;
				else if (tempIsLeftChild)
					tempParent.left = successor;
				else
					tempParent.right = successor;

				successor.left = temp.left;
				successor.right = temp.right;
			}
		}
	}

	public void annihilisticDelete(int data) {
		Node temp = root;
		Node tempParent = null;

		while (temp != null && temp.data != data) {
			tempParent = temp;

			if (data < temp.data)
				temp = temp.left;
			else
				temp = temp.right;
		}

		annihilisticDelete(temp, tempParent);
	}

	public void annihilisticDelete(Node node) {
		Node nodeParent = root;

		while (nodeParent != null && nodeParent.right != node && nodeParent.left != node) {
			if (node.data < nodeParent.data)
				nodeParent = nodeParent.left;
			else
				nodeParent = nodeParent.right;
		}

		if (nodeParent != null)
			annihilisticDelete(node, nodeParent);
	}

	private void annihilisticDelete(Node node, Node nodeParent) {
		if (node == null)
			return;
		boolean isLeftChild = node.data < nodeParent.data;

		if (isLeftChild)
			nodeParent.left = null;
		else
			nodeParent.right = null;

		if (node.right != null)
			annihilisticDelete(node.right, node);
		if (node.left != null)
			annihilisticDelete(node.left, node);
	}

	public void printTree() {
		printSubTree(root, 0);
	}

	public void printSubTree(Node node, int level) {
		if (node.right != null)
			printSubTree(node.right, level + 1);
		for (int i = 0; i < level; ++i)
			System.out.print("\t");
		System.out.println(node.data);
		if (node.left != null)
			printSubTree(node.left, level + 1);
	}
}
