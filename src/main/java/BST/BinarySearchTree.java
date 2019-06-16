package BST;


import LinkedList.ListNode;

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

    public int getMinimum() {
        return getMinimum(root).val;
    }

    private TreeNode getMinimum(TreeNode treeNode) {
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    public int getMaximum() {
        return getMaximum(root).val;
    }

    private TreeNode getMaximum(TreeNode treeNode) {
        while (treeNode.right != null) {
            treeNode = treeNode.right;
        }
        return treeNode;
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
        Stack<TreeNode> stack = new Stack<TreeNode>();
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
        Stack<TreeNode> stack = new Stack<TreeNode>();
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
            return getMaximum(current.left);
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
            return getMinimum(current.right);
        } else if (parent != null && parent.left == current) {
            return parent;
        } else {
            return firstTurnLeft;
        }
    }


    /**
     * @Description 删除节点的三种情况：如果该节点没有左子树：
     * 被删除节点是根节点，则将根指针指向该节点的子节点；
     * 被删除的是叶节点，则直接删除叶节点；
     * 被删除的是中间节点：则将该节点的父节点指向该节点的子节点
     * 如果被删除的节点没有右子树：
     * 被删除的节点是根节点，则将根节点的指针向下指到根节点的子节点；
     * 被删除的是叶节点，则直接删除
     * 被删除的是中间节点，则将该节点的父节点指向该节点的子节点。
     * 如果被删除的节点既有左子树也有右子树：
     * 找到该节点的前驱节点，将该节点与前驱节点交换位置，之后删掉前驱节点。
     * 该节点的前驱节点即为左子树上最大的节点。（因为此时该节点有左子树）
     **/
    public boolean delete(int x) {
        //找到被删除节点，并且记录该节点的父节点。
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            if (current.val == x) {
                break;
            }
            parent = current;
            if (x < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return false;
        }
        if (current.left == null) {
            if (parent == null) {//删除的是根节点
                root = root.right;
            } else if (current.right == null) {//删除的是叶节点
                if (parent.left == current) {
                    parent.left = null;
                }
                if (parent.right == current) {
                    parent.right = null;
                }
            } else {
                if (parent.left == current) {
                    parent.left = current.right;
                } else if (parent.right == current) {
                    parent.right = current.right;
                }
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = root.left;
            } else {
                if (parent.left == current) {
                    parent.left = current.left;
                } else if (parent.right == current) {
                    parent.right = current.left;
                }
            }
        } else {//既有左子树又有右子树
            //找到左子树中的最大的数，与current的值进行交换，之后删除左子树最大值节点
            TreeNode leftMax = current.right;
            TreeNode leftMaxParent = current;
            while (leftMax.right != null) {
                leftMaxParent = leftMax;
                leftMax = leftMax.right;
            }
            current.val = leftMax.val;
            leftMaxParent.right = null;
        }
        return true;
    }
}
