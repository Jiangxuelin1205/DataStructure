package SortingBasicTest;

import SortingBasic.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] arr = new int[]{11, 9, 7, 5};
        int[] answer = new int[]{5, 7, 9, 11};

        MergeSort m = new MergeSort();
        int[] result = m.mergeSort(arr);

        Assert.assertArrayEquals(answer, result);
    }
}
