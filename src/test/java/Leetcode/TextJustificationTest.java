package Leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationTest {

    @Test
    public void test() {
        String[] words = new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        };
        TextJustification_68 j = new TextJustification_68();
        List<String> l = j.fullJustify(words, 16);
        List<String> result = new ArrayList<>();
        result.add("This    is    an");
        result.add("example  of text");
        result.add("justification.  ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(result.get(i), l.get(i));
        }
    }

    @Test
    public void test2(){
        String[] words = new String[]{
                "What","must","be","acknowledgment","shall","be"
        };
        TextJustification_68 j = new TextJustification_68();
        List<String> l = j.fullJustify(words, 16);
        List<String> result = new ArrayList<>();
        result.add( "What   must   be");
        result.add("acknowledgment  ");
        result.add("shall be        ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(result.get(i), l.get(i));
        }
    }

    @Test
    public void test3(){
        String[] words = new String[]{
                "Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"
        };
        TextJustification_68 j = new TextJustification_68();
        List<String> l = j.fullJustify(words, 20);
        List<String> result = new ArrayList<>();
        result.add( "Science  is  what we");
        result.add("understand      well");
        result.add("enough to explain to");
        result.add("a  computer.  Art is");
        result.add("everything  else  we");
        result.add("do                  ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(result.get(i), l.get(i));
        }
    }
}
