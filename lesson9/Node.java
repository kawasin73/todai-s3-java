public class Node {
	private double value;
	private Node upperNode;
	private Node leftNode;
	private Node rightNode;

	public Node(double val) {
		value = val;
	}

	public double getValue() {

		// ここにgetValueの処理を書く
		return value;
	}

	public Node getUpperNode() {

		// ここにgetUpperNodeの処理を書く
		return upperNode;
	}

	public Node getLeftNode() {

		// ここにgetLeftNodeの処理を書く
		return leftNode;
	}

	public Node getRightNode() {

		// ここにgetRightNodeの処理を書く
		return rightNode;
	}

	public void setValue(double val) {

		// ここにsetValueの処理を書く
		this.value = val;
	}

	public void setUpperNode(Node node) {

		// ここにsetUpperNodeの処理を書く
		this.upperNode = node;
	}

	public void setLeftNode(Node node) {

		// ここにsetLeftNodeの処理を書く
		this.leftNode = node;
	}

	public void setRightNode(Node node) {

		// ここにsetRightNodeの処理を書く
		this.rightNode = node;
	}

	public Node getMinNode() {

		// ここにgetMinNodeの処理を書く
		// このノード自身から下に辿って得られるすべてのノードの中から,最小の値を持つノードを返す．
		if (leftNode == null) {
			return this;
		}
		return leftNode.getMinNode();
	}

	public Node getMaxNode() {

		// ここにgetMaxNodeの処理を書く
		// このノード自身から下に辿って得られるすべてのノードの中から,最大の値を持つノードを返す．
		if (rightNode == null) {
			return this;
		}
		return rightNode.getMaxNode();
	}
}