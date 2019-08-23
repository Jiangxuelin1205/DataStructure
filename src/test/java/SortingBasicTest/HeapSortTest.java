package SortingBasicTest;

import SortingBasic.HeapSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeapSortTest {
    @Test
    public void testHeapSort() {
        int[] arr = new int[]{
                10, 7, 2, 4, 7, 62, 3, 1, 8
        };
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);
        ans.add(4);
        ans.add(7);
        ans.add(7);
        ans.add(8);
        ans.add(10);
        ans.add(62);
        HeapSort h = new HeapSort();
        List<Integer> result = h.heapSort(arr);
        System.out.println(result);
//        Assert.assertArrayEquals(arr,result);
    }
}
