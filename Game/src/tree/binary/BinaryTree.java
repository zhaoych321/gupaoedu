package tree.binary;

public class BinaryTree {
	public static class Node {
		private char data;
		private Node left;
		private Node right;

		public Node(char data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public char getData() {
			return data;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

	}
	
	public void print(Node root) {
		System.out.print(root.getData());
	}
	
	public void preOrder(Node root) {
		print(root);
		if (root.getLeft() != null) {
			preOrder(root.getLeft());
		}
		if (root.getRight() != null) {
			preOrder(root.getRight());
		}
	}
	
	public void inOrder(Node root) {
		if (root.getLeft() != null) {
			inOrder(root.getLeft());
		}
		print(root);
		if (root.getRight() != null) {
			inOrder(root.getRight());
		}
	}
	
	public void postOrder(Node root) {
		if (root.getLeft() != null) {
			postOrder(root.getLeft());
		}
		if (root.getRight() != null) {
			postOrder(root.getRight());
		}
		print(root);
	}
	
	/*
	 *                      A 
	 *                     /  \
	 *                    B    C
	 *                   /   /  \
	 *                  D   E    F
	 *                   \   \  / \
	 *                    G  H I   J
	 */
	public static void main(String[] args) {
		Node G = new Node('G', null, null);
		Node H = new Node('H', null, null);
		Node I = new Node('I', null, null);
		Node J = new Node('J', null, null);
		Node D = new Node('D', null, G);
		Node E = new Node('E', null, H);
		Node F = new Node('F', I, J);
		Node B = new Node('B', D, null);
		Node C = new Node('C', E, F);
		Node A = new Node('A', B, C);
		
		BinaryTree binaryTree = new BinaryTree();
		//前序遍历预期值  ABDGCEHFIJ
		binaryTree.preOrder(A);
		System.out.println();
		
		//中序遍历预期值  DGBAEHCIFJ
		binaryTree.inOrder(A);
		System.out.println();
		
		//后序遍历预期值 GDBHEIJFCA
		binaryTree.postOrder(A);
	}
}
