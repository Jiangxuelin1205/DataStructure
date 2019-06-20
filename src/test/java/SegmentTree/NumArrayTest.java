package SegmentTree;

import org.junit.Assert;
import org.junit.Test;

public class NumArrayTest {

    @Test
    public void prefix(){
        int[] data = new int[]{
                -2, 0, 3, -5, 2, -1
        };
        NumArray numArray=new NumArray(data);

    }

    @Test
    public void segment() {
        int[] data = new int[]{
                -2, 0, 3, -5, 2, -1
        };
        NumArray numArray=new NumArray(data);
        Assert.assertEquals(numArray.sumRange(0,1),-2);
    }

    @Test
    public void sumRange() {
        int[] data = new int[]{
                -2, 0, 3, -5, 2, -1
        };
        NumArray numArray=new NumArray(data);
        Assert.assertEquals(numArray.sumRange(2,5),-1);
    }

    @Test
    public void sumRange3() {
        int[] data = new int[]{
                -2, 0, 3, -5, 2, -1
        };
        NumArray numArray=new NumArray(data);
        Assert.assertEquals(numArray.sumRange(0,5),-3);
    }

}
