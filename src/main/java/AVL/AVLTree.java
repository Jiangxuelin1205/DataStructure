package AVL;

import java.util.ArrayList;

public class AVLTree {

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    @SuppressWarnings("unused")
    public int getSize() {
        return size;
    }

    @SuppressWarnings("unused")
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isBST() {
        return isBST(root);
    }

    private boolean isBST(Node node) {
        ArrayList<Integer> elements = new ArrayList<>();
        inOrder(node, elements);
        for (int index = 1; index < elements.size(); index++) {
            if (elements.get(index - 1) > elements.get(index)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<Integer> elements) {
        if (node == null) {
            return;
        }
        inOrder(node.left, elements);
        elements.add(node.val);
        inOrder(node.right, elements);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(int val) {
        root = add(root, val);
    }

    private Node add(Node node, int val) {
        if (node == null) {
            size++;
            node = new Node(val);
            return node;
        }
        if (val < node.val) {
            node.left = add(node.left, val);
        } else if (val > node.val) {
            node.right = add(node.right, val);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //LR
        //       node
        //      / \
        //    left
        //     \
        //    right
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            //noinspection SuspiciousNameCombination
            node.left = leftRotate(node.left);//先将左子树向右旋转，转换成为LL的情况
            return rightRotate(node);
        }
        //RL
        //   node
        //  /  \
        //     right
        //      /
        //    left
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            //noinspection SuspiciousNameCombination
            node.right = rightRotate(node.right);//先转成RR的情况
            return leftRotate(node);
        }
        return node;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        @SuppressWarnings("UnnecessaryLocalVariable")
        Node T3 = x.right;

        y.left = T3;
        //noinspection SuspiciousNameCombination
        x.right = y;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(y.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        @SuppressWarnings("UnnecessaryLocalVariable")
        Node T2 = x.left;

        y.right = T2;
        //noinspection SuspiciousNameCombination
        x.left = y;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private Node getNode(Node node, int val) {

        if (node == null) {
            return null;
        }
        if (val == node.val) {
            return node;
        } else if (val > node.val) {
            return getNode(node.right, val);
        } else {
            return getNode(node.left, val);
        }
    }

    @SuppressWarnings("unused")
    public boolean contains(int val) {
        return getNode(root, val) != null;
    }

    @SuppressWarnings("unused")
    public int get(int key) {
        Node node = getNode(root, key);
        //noinspection ConstantConditions
        return node == null ? null : node.val;
    }

    @SuppressWarnings("unused")
    public void set(int val, int newValue) {
        Node node = getNode(root, val);
        if (node == null)
            throw new IllegalArgumentException(val + " doesn't exist!");

        node.val = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 从二分搜索树中删除键为key的节点
    @SuppressWarnings("unused")
    public void remove(int val) {
        Node node = getNode(root, val);
        if (node != null) {
            root = remove(root, val);
        }
    }

    private Node remove(Node node, int val) {

        if (node == null)
            return null;

        Node retNode;
        if (val < node.val) {
            node.left = remove(node.left, val);
            retNode = node;
        } else if (val > node.val) {
            node.right = remove(node.right, val);
            retNode = node;
        } else {   // key.compareTo(node.key) == 0
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) { // 待删除节点右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.val);
                successor.left = node.left;

                node.left = null;
                node.right = null;

                retNode = successor;
            }
        }



        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        int balanceFactor = getBalanceFactor(retNode);
        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //LR
        //       node
        //      / \
        //    left
        //     \
        //    right
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            //noinspection SuspiciousNameCombination
            retNode.left = leftRotate(retNode.left);//先将左子树向右旋转，转换成为LL的情况
            return rightRotate(retNode);
        }
        //RL
        //   node
        //  /  \
        //     right
        //      /
        //    left
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            //noinspection SuspiciousNameCombination
            retNode.right = rightRotate(retNode.right);//先转成RR的情况
            return leftRotate(retNode);
        }
        return retNode;

    }

}
