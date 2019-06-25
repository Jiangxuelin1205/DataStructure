package BST;

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
        b.addNonRecursive(3);
        b.addNonRecursive(5);
        b.addNonRecursive(4);
        b.inOrder();
    }

    @Test
    public void insert_recursively_test() {
        BinarySearchTree b = new BinarySearchTree();
        b.addRecursive(3);
        b.addRecursive(5);
        b.addRecursive(4);
        b.inOrder();
    }


    @Test
    public void getMinimum_test() {
        BinarySearchTree b = new BinarySearchTree();
        b.addNonRecursive(3);
        b.addNonRecursive(1);
        b.addNonRecursive(2);
        b.addNonRecursive(4);
        Assert.assertEquals(b.minimum().val, 1);
    }

    @Test
    public void getMaximum_test() {
        BinarySearchTree b = new BinarySearchTree();
        b.addNonRecursive(3);
        b.addNonRecursive(1);
        b.addNonRecursive(2);
        b.addNonRecursive(4);
        Assert.assertEquals(b.maximum().val, 4);
    }

    @Test
    public void contains() {
        BinarySearchTree b = new BinarySearchTree();
        b.addNonRecursive(3);
        b.addNonRecursive(1);
        b.addNonRecursive(2);
        b.addNonRecursive(4);
        Assert.assertTrue(b.contains(3));
    }

    @Test
    public void donot_contain() {
        BinarySearchTree b = new BinarySearchTree();
        b.addNonRecursive(3);
        b.addNonRecursive(1);
        b.addNonRecursive(2);
        b.addNonRecursive(4);
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
    public void remove_minimum(){
        int[] numbers = new int[]{
                3, 1, 2, 5, 4
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        Assert.assertEquals(b.removeMinimum(),1);
        Assert.assertFalse(b.contains(1));
    }

    @Test
    public void remove_maximum(){
        int[] numbers = new int[]{
                3, 1, 2, 5, 4
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        Assert.assertEquals( b.removeMaximum(),5);
        Assert.assertFalse(b.contains(5));
    }

    @Test
    public void remove_fail() {
        int[] numbers = new int[]{
                3, 1, 2, 5, 4
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.remove(8);
        Assert.assertTrue(b.contains(3));
    }

    @Test
    public void remove_success() {
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.remove(3);
        Assert.assertFalse(b.contains(3));
    }

    @Test
    public void remove_root() {
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.remove(1);
        Assert.assertFalse(b.contains(1));
    }
}
