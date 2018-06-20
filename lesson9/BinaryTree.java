public class BinaryTree {
	private Node root; // 最上位の親ノード

	public boolean isEmpty() {
		return root == null;
	}

	public Node getMinNode() {

		// ここにgetMinNodeの処理を書く

	}

	public Node getMaxNode() {

		// ここにgetMaxNodeの処理を書く

	}

	public Node findNode(double value) {

		// ここにfindNodeの処理を書く

	}

	public void insertNode(double value) {

		// ここにinsertNodeの処理を書く

	}

	public void removeNode(Node node) {

		// ここにremoveNodeの処理を書く

	}

	private void printSubTree(Node node) {
		System.out.print(" ( " + node.getValue());
		
		if (node.getLeftNode() != null || node.getRightNode() != null) {
			if (node.getLeftNode() == null) {
				System.out.print(" ( null ) ");
			} else {
				printSubTree(node.getLeftNode());
			}

			if (node.getRightNode() == null) {
				System.out.print(" ( null ) ");
			} else {
				printSubTree(node.getRightNode());
			}
		}

		System.out.print( " )");
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.print("( null )");
		} else {
			printSubTree(root);
		}
		System.out.println();
	}
}