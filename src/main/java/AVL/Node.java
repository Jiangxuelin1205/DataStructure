package AVL;

public class Node {

    Node left;
    Node right;
    public int val;
    public int height;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
        height=1;
    }
}
