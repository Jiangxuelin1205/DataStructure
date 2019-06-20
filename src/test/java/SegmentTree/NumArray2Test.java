package SegmentTree;

import org.junit.Assert;
import org.junit.Test;

public class NumArray2Test {

    @Test
    public void test(){
        int[] data = new int[]{
                2, 4, 1, 6, 8
        };
        NumArray2 numArray2=new NumArray2(data);
        int result=numArray2.sumRange(0,2);
        Assert.assertEquals(result,7);
    }

    @Test
    public void test2(){
        int[] data = new int[]{
                2, 4, 1, 6, 8
        };
        NumArray2 numArray2=new NumArray2(data);
        numArray2.update(0,3);
        int result=numArray2.sumRange(0,2);
        Assert.assertEquals(result,8);
    }
}
