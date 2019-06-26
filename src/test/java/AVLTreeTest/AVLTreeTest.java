package AVLTreeTest;

import AVL.AVLTree;
import org.junit.Assert;
import org.junit.Test;

public class AVLTreeTest {

    @Test
    public void add(){
        AVLTree avlTree=new AVLTree();
        avlTree.add(1);
        avlTree.add(2);
        avlTree.add(3);
        avlTree.add(4);
        avlTree.add(5);
        Assert.assertTrue(avlTree.isBalanced());
        Assert.assertTrue(avlTree.isBST());
    }
}
