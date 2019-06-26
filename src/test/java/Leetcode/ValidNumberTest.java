package Leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ValidNumberTest {
    @Test
    public void test1(){
        ValidNumber_65 v=new ValidNumber_65();
        String s="0";
        Assert.assertTrue(v.isNumber(s));
    }
}
