package BSTTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    private TreeNode root;

    public void build(int[] numbers) {
        for (int number : numbers) {
            insertNonRecursive(number);
        }
    }

    //二叉树插入的非递归实现
    public void insertNonRecursive(int e) {
        if (root == null) {
            root = new TreeNode(e);
        }
        TreeNode current = root;
        TreeNode parent;
        while (true) {
            parent = current;
            if (e < current.val) {
                current = current.left;
                if (current == null) {
                    parent.left = new TreeNode(e);
                    return;
                }
            } else if (e > current.val) {
                current = current.right;
                if (current == null) {
                    parent.right = new TreeNode(e);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void insertRecursively(int e) {
        root = insertRecursively(root, e);
    }

    //二叉树插入的递归实现
    private TreeNode insertRecursively(TreeNode root, int e) {
        if (root == null) {
            root = new TreeNode(e);
            return root;
        }

        if (e < root.val) {
            root.left = insertRecursively(root.left, e);
        } else if (e > root.val) {
            root.right = insertRecursively(root.right, e);
        }
        return root;
    }

    public boolean contains(int e) {
        return contains(root, e);
    }

    private boolean contains(TreeNode root, int e) {
        if (root == null) {
            return false;
        }
        if (e < root.val) {
            return contains(root.left, e);
        } else if (e > root.val) {
            return contains(root.right, e);
        } else {
            return true;
        }
    }

    public TreeNode minimum() {
        return minimum(root);
    }

    private TreeNode minimum(TreeNode treeNode) {
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    public int removeMinimum() {
        int minimum = minimum().val;
        root = removeMinimum(root);
        return minimum;
    }

    private TreeNode removeMinimum(TreeNode root) {
        //删除以root为根的最小值节点,最小节点为该节点的左子树的最右节点
        if (root.left == null) {
            TreeNode rightNode = root.right;
            root.right = null;
            return rightNode;
        }
        root.left = removeMinimum(root.left);
        return root;
    }

    public TreeNode maximum() {
        return maximum(root);
    }

    private TreeNode maximum(TreeNode treeNode) {
        while (treeNode.right != null) {
            treeNode = treeNode.right;
        }
        return treeNode;
    }

    public int removeMaximum() {
        int maximum = maximum().val;
        root = removeMaximum(root);
        return maximum;
    }

    private TreeNode removeMaximum(TreeNode root) {
        if (root.right == null) {
            TreeNode leftNode = root.left;
            root.left = null;
            return leftNode;
        }
        root.right = removeMaximum(root.right);
        return root;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    private void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.val);
        }
    }

    public List<TreeNode> preOrderNonRecursive() {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public List<TreeNode> inOrderNonRecursive() {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        TreeNode currentNode = root;
        if (root == null) {
            return result;
        }
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                result.add(currentNode);
                currentNode = currentNode.right;
            }
        }
        return result;
    }

    public List<TreeNode> postOrderNonRecursive() {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!output.isEmpty()) {
            result.add(output.pop());
        }
        return result;
    }

    public TreeNode getPredecessor(int x) {
        //求前驱节点和后继节点的方法很类似
        TreeNode firstTurnRight = null;
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            if (current.val == x) {
                break;
            }
            parent = current;
            if (current.val > x) {
                current = current.left;
            } else {
                //找到第一个出现右拐的节点
                firstTurnRight = current;
                current = current.right;
            }
        }
        if (current != null && current.left != null) {
            return maximum(current.left);
        } else if (parent != null && parent.right == current) {
            return parent;
        } else {
            return firstTurnRight;
        }
    }

    public TreeNode getSuccessor(int x) {
        //保存该节点的父节点，以及父节点的祖先节点中第一个出现左拐的节点
        TreeNode firstTurnLeft = null;
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            if (current.val == x) {
                break;
            }
            parent = current;
            if (current.val < x) {
                current = current.right;
            } else {
                firstTurnLeft = current;
                current = current.left;
            }
        }
        if (current != null && current.right != null) {
            return minimum(current.right);
        } else if (parent != null && parent.left == current) {
            return parent;
        } else {
            return firstTurnLeft;
        }
    }

    public void remove(int e) {
        this.root = remove(root, e);
    }

    /**
     * 移除操作分为三种情况：被移除的节点有左孩子；被移除的节点有有孩子；
     * 被移除的节点有左右孩子
     */
    private TreeNode remove(TreeNode root, int e) {
        if (root == null) {
            return null;
        }
        if (e < root.val) {
            root.left = remove(root.left, e);
            return root;
        } else if (e > root.val) {
            root.right = remove(root.right, e);
            return root;
        } else {//e==root.val
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            } else if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            } else {
                //找到该节点的后继节点代替该节点
                //后继节点为该节点右子树的最小节点
                TreeNode successor = minimum(root.right);
                successor.left = root.left;
                successor.right = removeMinimum(root.right);

                root.left = null;
                root.right = null;

                return successor;
            }
        }
    }
}
