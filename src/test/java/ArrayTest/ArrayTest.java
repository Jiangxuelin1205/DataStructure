package ArrayTest;

import Array.Array;
import org.junit.Test;

public class ArrayTest {

    @Test
    public void add(){
        Array<Integer> array=new Array<Integer>();
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        System.out.println(array.getCapacity());
    }

    @Test
    public void remove(){
        Array<Integer> array=new Array<Integer>();
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        System.out.println(array.getCapacity());
        array.remove();
        array.remove();
        array.remove();
        array.remove();
        System.out.println(array.getCapacity());
    }
}
