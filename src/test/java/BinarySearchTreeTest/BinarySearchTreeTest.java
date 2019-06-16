package BinarySearchTreeTest;

import BST.BinarySearchTree;
import BST.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BinarySearchTreeTest {
    @Test
    public void build_test() {
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.inOrder();
    }

    @Test
    public void insert_test() {
        BinarySearchTree b = new BinarySearchTree();
        b.insertNonRecursive(3);
        b.insertNonRecursive(5);
        b.insertNonRecursive(4);
        b.inOrder();
    }

    @Test
    public void insert_recursively_test() {
        BinarySearchTree b = new BinarySearchTree();
        b.insertRecursively(3);
        b.insertRecursively(5);
        b.insertRecursively(4);
        b.inOrder();
    }


    @Test
    public void getMinimum_test() {
        BinarySearchTree b = new BinarySearchTree();
        b.insertNonRecursive(3);
        b.insertNonRecursive(1);
        b.insertNonRecursive(2);
        b.insertNonRecursive(4);
        Assert.assertEquals(b.getMinimum(), 1);
    }

    @Test
    public void getMaximum_test() {
        BinarySearchTree b = new BinarySearchTree();
        b.insertNonRecursive(3);
        b.insertNonRecursive(1);
        b.insertNonRecursive(2);
        b.insertNonRecursive(4);
        Assert.assertEquals(b.getMaximum(), 4);
    }

    @Test
    public void contains() {
        BinarySearchTree b = new BinarySearchTree();
        b.insertNonRecursive(3);
        b.insertNonRecursive(1);
        b.insertNonRecursive(2);
        b.insertNonRecursive(4);
        Assert.assertTrue(b.contains(3));
    }

    @Test
    public void donot_contain() {
        BinarySearchTree b = new BinarySearchTree();
        b.insertNonRecursive(3);
        b.insertNonRecursive(1);
        b.insertNonRecursive(2);
        b.insertNonRecursive(4);
        Assert.assertFalse(b.contains(5));
    }

    @Test
    public void preOrder_nonrecursive_test(){
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        List<TreeNode>result= b.preOrderNonRecursive();
        for (TreeNode aResult : result) {
            System.out.println(aResult.val);
        }
    }

    @Test
    public void inOrder_nonrecursive_test(){
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        List<TreeNode>result= b.inOrderNonRecursive();
        for (TreeNode aResult : result) {
            System.out.println(aResult.val);
        }
    }

    @Test
    public void postOrder_non_recursive(){
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        List<TreeNode>result= b.postOrderNonRecursive();
        for (TreeNode aResult : result) {
            System.out.println(aResult.val);
        }
    }

    @Test
    public void getSuccessor_test() {
        int[] numbers = new int[]{
                3, 1, 2, 5, 4
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        TreeNode s1 = b.getSuccessor(2);
        TreeNode s2 = b.getSuccessor(3);
        TreeNode s3 = b.getSuccessor(1);
        TreeNode s4 = b.getSuccessor(5);
        TreeNode s5 = b.getSuccessor(4);

        Assert.assertEquals(s1.val,3);
        Assert.assertEquals(s2.val,4);
        Assert.assertEquals(s3.val,2);
        Assert.assertNull(s4);
        Assert.assertEquals(s5.val,5);
    }

    @Test
    public void getPredecessor_test() {
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        TreeNode p1 = b.getPredecessor(2);
        TreeNode p2 = b.getPredecessor(3);
        TreeNode p3 = b.getPredecessor(1);
        TreeNode p4 = b.getPredecessor(5);
        TreeNode p5 = b.getPredecessor(4);
        Assert.assertEquals(p1.val,1);
        Assert.assertEquals(p2.val,2);
        Assert.assertNull(p3);
        Assert.assertEquals(p4.val,4);
        Assert.assertEquals(p5.val,3);
    }

    @Test
    public void delete_fail_test() {
        BinarySearchTree b = new BinarySearchTree();
        Assert.assertFalse(b.delete(3));
    }

    @Test
    public void delete_success_test() {
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.delete(3);
        b.inOrder();
    }

    @Test
    public void delete_success_test2() {
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.delete(1);
        b.inOrder();
    }
}
