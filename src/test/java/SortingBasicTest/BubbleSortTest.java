package SortingBasicTest;

import SortingBasic.BubbleSort;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void bubbleSortTest(){
        int[] arr=new int[]{
                4,4,3,2,2,1
        };
        BubbleSort b=new BubbleSort();
        b.bubbleSort(arr);
        for (int anArr : arr) {
            System.out.println(anArr);
        }
        //System.out.println(arr);
    }
}
