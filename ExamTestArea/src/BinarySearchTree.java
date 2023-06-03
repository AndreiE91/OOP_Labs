public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node insert(Node node, T data) {
        if (node == null) {
            return new Node(data);
        }
        int compareResult = data.compareTo(node.data);
        if (compareResult < 0) {
            node.left = insert(node.left, data);
        } else if (compareResult > 0) {
            node.right = insert(node.right, data);
        }
        return node;
    }
}
