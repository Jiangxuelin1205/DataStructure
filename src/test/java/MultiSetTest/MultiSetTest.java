package MultiSetTest;

import MultiSet.MultiSet;
import org.junit.Assert;
import org.junit.Test;

public class MultiSetTest {
    @Test
    public void test_size() {
       MultiSet<Integer> multiSet = new MultiSet<Integer>();
        Assert.assertEquals(multiSet.size(), 0);
        multiSet.add(3);
        Assert.assertEquals(multiSet.size(), 1);
    }

    @Test
    public void test_isEmpty() {
       MultiSet<Integer> multiSet = new MultiSet<Integer>();
        Assert.assertTrue(multiSet.isEmpty());
        multiSet.add(3);
        Assert.assertFalse(multiSet.isEmpty());
    }

    @Test
    public void test_contains() {
       MultiSet<Integer> multiSet = new MultiSet<Integer>();
        Assert.assertFalse(multiSet.contains(4));
        multiSet.add(4);
        Assert.assertTrue(multiSet.contains(4));
    }

    @Test
    public void test_to_array() {
        MultiSet<Integer> multiSet = new MultiSet<Integer>();
        multiSet.add(3);
        multiSet.add(4);
        multiSet.add(4);
        Object[] array= multiSet.toArray();
        for (Object anArray : array) {
            System.out.println(anArray);
        }
    }

    @Test
    public void test_remove() {
        MultiSet<Integer> multiSet = new MultiSet<Integer>();
        multiSet.add(3);
        multiSet.add(4);
        multiSet.add(4);
        Object[] objects=multiSet.toArray();
        for(Object o:objects){
            System.out.print(o+"  ");
        }
        System.out.println();
        multiSet.remove(4);
        Object[] objects1=multiSet.toArray();
        for(Object o:objects1){
            System.out.println(o+" ");
        }
        System.out.println();
    }
    @Test
    public void test_clear(){
        MultiSet<Integer> multiSet = new MultiSet<Integer>();
        multiSet.add(3);
        multiSet.add(4);
        Assert.assertEquals(multiSet.size(),2);
        multiSet.clear();
        Assert.assertEquals(multiSet.size(),0);
    }
}
