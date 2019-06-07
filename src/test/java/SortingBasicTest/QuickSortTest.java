package SortingBasicTest;

import SortingBasic.QuickSort;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void quickSort(){
        int[] arr = new int[]{
                10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19
        };
        int[] ans=new int[]{
                1 ,2 ,2 ,3 ,4 ,4 ,7 ,7 ,8 ,9 ,10 ,19 ,62
        };

        QuickSort q=new QuickSort();
        int[] result=q.quickSort(arr);

        Assert.assertArrayEquals(ans,result);
    }
}
