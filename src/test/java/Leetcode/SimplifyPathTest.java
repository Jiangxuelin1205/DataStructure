package Leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SimplifyPathTest {

    @Test
    public void test(){
       SimplifyPath_71 s=new SimplifyPath_71();
       Assert.assertEquals(s.simplifyPath("/home/"),"/home");
    }

    @Test
    public void test2(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/../"),"/");
    }

    @Test
    public void test3(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/home//foo/"),"/home/foo");
    }

    @Test
    public void test4(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/a/../../b/../c//.//"),"/c");
    }

    @Test
    public void test5(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/a//b////c/d//././/.."),"/a/b/c");
    }

    @Test
    public void test6(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/a/./b/../../c/"),"/c");
    }

    @Test
    public void test7(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/..."),"/...");
    }

    @Test
    public void test8(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/abc/..."),"/abc/...");
    }

    @Test
    public void test9(){
        SimplifyPath_71 s=new SimplifyPath_71();
        Assert.assertEquals(s.simplifyPath("/..hidden"),"/..hidden");
    }
}
