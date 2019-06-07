package SortingBasicTest;

import SortingBasic.ChoiceSort;
import org.junit.Test;

public class ChoiceSortTest {
    @Test
    public void test(){
        int[] arr=new int[]{
                4,4,3,2,1,1,1,1
        };
        ChoiceSort c=new ChoiceSort();
        c.choiceSort(arr);
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }
}
