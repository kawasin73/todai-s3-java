public class BinaryTree {
    private Node root; // 最上位の親ノード

    public boolean isEmpty() {
        return root == null;
    }

    public Node getMinNode() {
        if (root == null) {
            return null;
        }
        return root.getMinNode();
    }

    public Node getMaxNode() {
        if (root == null) {
            return null;
        }
        return root.getMaxNode();
    }

    public Node findNode(double value) {
        Node node = root;
        while (node != null) {
            double nodeValue = node.getValue();
            if (value == nodeValue) {
                break;
            } else if (value > nodeValue) {
                node = node.getRightNode();
            } else {
                node = node.getLeftNode();
            }
        }
        return node;
    }

    public void insertNode(double value) {
        // ここにinsertNodeの処理を書く
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node node = root;
        while (true) {
            double nodeValue = node.getValue();
            if (value == nodeValue) {
                System.out.println(String.format("%f is already inserted", value));
                break;
            } else if (value > nodeValue) {
                if (node.getRightNode() == null) {
                    node.setRightNode(newNode);
                    newNode.setUpperNode(node);
                    break;
                } else {
                    node = node.getRightNode();
                }
            } else {
                if (node.getLeftNode() == null) {
                    node.setLeftNode(newNode);
                    newNode.setUpperNode(node);
                    break;
                } else {
                    node = node.getLeftNode();
                }
            }
        }
    }

    public void removeNode(Node node) {
        Node uNode = node.getUpperNode();
        Node lNode = node.getLeftNode();
        Node rNode = node.getRightNode();
        node.setUpperNode(null);
        node.setRightNode(null);
        node.setLeftNode(null);
        Node nextNode;
        if (lNode == null && rNode == null) {
            nextNode = null;
        } else if (lNode != null && rNode != null) {
            nextNode = rNode.getMinNode();
            // reconnect rNode only if minNode is not rNode itself
            if (nextNode != rNode) {
                // disconnect minNode and its upperNode
                nextNode.getUpperNode().setLeftNode(null);

                // reconnect rNode
                nextNode.setRightNode(rNode);
                rNode.setUpperNode(nextNode);
            }
            // reconnect lNode
            nextNode.setLeftNode(lNode);
            lNode.setUpperNode(nextNode);
        } else if (lNode == null) {
            nextNode = rNode;
        } else {
            // rNode == null
            nextNode = lNode;
        }
        // reconnect nextNode and uNode
        if (nextNode != null) {
            nextNode.setUpperNode(uNode);
        }
        if (uNode == null) {
            root = nextNode;
        } else if (uNode.getRightNode() == node) {
            uNode.setRightNode(nextNode);
        } else {
            uNode.setLeftNode(nextNode);
        }
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

        System.out.print(" )");
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