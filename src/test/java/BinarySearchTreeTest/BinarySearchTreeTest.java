package BinarySearchTreeTest;

import BinarySearchTree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

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
    public void dont_contain() {
        BinarySearchTree b = new BinarySearchTree();
        b.insertNonRecursive(3);
        b.insertNonRecursive(1);
        b.insertNonRecursive(2);
        b.insertNonRecursive(4);
        Assert.assertFalse(b.contains(5));
    }

    @Test
    public void getSuccessor_test() {
        int[] numbers = new int[]{
                3, 1, 2, 5, 4
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.getSuccessor(2);
        b.getSuccessor(3);
        b.getSuccessor(1);
        b.getSuccessor(5);
        b.getSuccessor(4);
    }

    @Test
    public void getPredecessor_test() {
        int[] numbers = new int[]{
                1, 2, 3, 4, 5
        };
        BinarySearchTree b = new BinarySearchTree();
        b.build(numbers);
        b.getPredecessor(2);
        b.getPredecessor(3);
        b.getPredecessor(1);
        b.getPredecessor(5);
        b.getPredecessor(4);
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
