
// Credit: https://github.com/isstac/canopy/blob/master/src/examples/sampling/batch/BinaryTreeSearch.java
import java.util.Random;

public class BinarySearchTree {
    /**
     * Internal class representing a Node in the tree.
     */
    private class Node {
        int value;
        Node left;
        Node right;

        Node(int v, Node l, Node r) {
            value = v;
            left = l;
            right = r;
        }
    }

    private Node root = null;

    /**
     * Inserts a value in to the tree.
     */
    public void insert(int v) {

        if (root == null) {
            root = new Node(v, null, null);
            return;
        }

        Node curr = root;
        while (true) {
            if (curr.value < v) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new Node(v, null, null);
                    break;
                }
            } else if (curr.value > v) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new Node(v, null, null);
                    break;
                }
            } else {
                break;
            }
        }
    }

    /**
     * Searches for a value in the tree.
     */
    public boolean search(int v) {
        Node curr = root;
        while (curr != null) { // N branches
            if (curr.value == v) { // N-1 branches
                return true;
            } else if (curr.value < v) { // N-1 branches
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        final int N = Integer.parseInt(args[0]);
        Random rand = new Random();
        BinarySearchTree b = new BinarySearchTree();
        for (int i = 0; i < N; i++) {
            b.insert(i);
        }

        for (int i = 0; i < N; i++) {
            b.search(rand.nextInt(i + 1));
        }
    }
}
