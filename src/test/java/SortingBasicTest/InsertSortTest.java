package SortingBasicTest;

import SortingBasic.InsertSort;
import org.junit.Test;

public class InsertSortTest {
    @Test
    public void test(){
        int[] arr=new int[]{
                0,5,8,9,5,4,3,2,1,9
        };
        InsertSort i=new InsertSort();
        i.insertSort(arr);
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }
}
