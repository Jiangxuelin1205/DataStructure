package SegmentTree;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeTest {

    @Test
    public void segment_tree() {
        Integer[] data = new Integer[]{
                2, 4, 1, 6, 8
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        System.out.println(tree.toString());
    }

    @Test
    public void size() {
        Integer[] data = new Integer[]{
                2, 4, 1, 6, 8
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        Assert.assertEquals(tree.getSize(),data.length);
    }

    @Test
    public void get() {
        Integer[] data = new Integer[]{
                2, 4, 1, 6, 8
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        int index=3;
        int result=tree.get(index);
        Assert.assertEquals(result,6);
    }

    @Test
    public void query(){
        Integer[] data = new Integer[]{
                2, 4, 1, 6, 8
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        int result=tree.query(0,4);
        Assert.assertEquals(result,21);
    }

    @Test
    public void query_left_equals_right(){
        Integer[] data = new Integer[]{
                2, 4, 1, 6, 8
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        int result=tree.query(0,0);
        Assert.assertEquals(result,2);
    }

    @Test
    public void query_left_equals_right2(){
        Integer[] data = new Integer[]{
                2, 4, 1, 6, 8
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        int result=tree.query(3,3);
        Assert.assertEquals(result,6);
    }

    @Test
    public void query_separate_segment(){
        Integer[] data = new Integer[]{
                2, 4, 1, 6, 8
        };
        SegmentTree<Integer> tree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        int result=tree.query(1,3);
        Assert.assertEquals(result,11);
    }
}
