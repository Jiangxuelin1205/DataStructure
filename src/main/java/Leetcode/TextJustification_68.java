package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {

    /**
     * Given an array of words and a width maxWidth,
     * format the text such that each line has exactly
     * maxWidth characters and is fully (left and right) justified.
     * <p>
     * You should pack your words in a greedy approach;
     * that is, pack as many words as you can in each line.
     * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
     * <p>
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line do not divide evenly between words,
     * the empty slots on the left will be assigned more spaces than the slots on the right.
     * <p>
     * For the last line of text,
     * it should be left justified and no extra space is inserted between words.
     */

    List<String> fullJustify(String[] words, int maxWidth) {
        //1.把一行中第一个单词放入StringBuilder里
        //2.在行中尝试填充一个空格和一个单词。如果长度超出maxWidth，则停止尝试填充
        //3.计算一行中还剩下的空格数，剩余的空格数填充在该行前面的空格里
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex;
        while (startIndex < words.length) {
            int rowLength = 0;
            StringBuilder buffer = new StringBuilder();

            endIndex = startIndex;
            rowLength += words[endIndex].length();
            endIndex++;
            while ((endIndex < words.length) && (rowLength + 1 + words[endIndex].length() <= maxWidth)) {
                rowLength += 1 + words[endIndex].length();
                endIndex++;
            }

            if (endIndex == words.length) {//最后一行，如果有一个单词，则执行以下逻辑；如果有多个单词，则是leftjusted
                buffer.append(words[startIndex]);
                startIndex++;
                while (startIndex < words.length) {
                    buffer.append(" ");
                    buffer.append(words[startIndex]);
                    startIndex++;
                }
                while (rowLength < maxWidth) {
                    buffer.append(" ");
                    rowLength++;
                }
                result.add(buffer.toString());
                break;
            }
            //计算每单词间的空格数
            int totalSpaceCount = endIndex - startIndex - 1;
            //只有一个单词
            if (totalSpaceCount == 0) {
                buffer.append(words[startIndex++]);
                while (rowLength < maxWidth) {
                    buffer.append(" ");
                    rowLength++;
                }
                result.add(buffer.toString());
                continue;
            }
            //多个单词但不是最后一行
            int[] spacesBetweenWords = spacesBetweenWords(maxWidth, rowLength, totalSpaceCount);

            int spaceIndex = 0;
            buffer.append(words[startIndex]);
            startIndex++;
            while (startIndex < words.length && startIndex < endIndex) {
                for (int i = 0; i < spacesBetweenWords[spaceIndex]; i++) {
                    buffer.append(" ");
                }
                buffer.append(words[startIndex]);
                spaceIndex++;
                startIndex++;
            }
            result.add(buffer.toString());
        }
        return result;

    }

    private int[] spacesBetweenWords(int maxWidth, int rowLength, int totalSpaceCount) {
        int[] spacesBetweenWords = new int[totalSpaceCount];
        int remainingSpace = maxWidth - rowLength;
        if (remainingSpace % totalSpaceCount == 0) {
            int spacesAdded = remainingSpace / totalSpaceCount;
            for (int i = 0; i < spacesBetweenWords.length; i++) {
                spacesBetweenWords[i] = 1 + spacesAdded;
            }
        } else {
            int baseAdded = remainingSpace / totalSpaceCount;
            int remainingAdded = remainingSpace - totalSpaceCount * baseAdded;
            for (int i = 0; i < spacesBetweenWords.length; i++) {
                if (remainingAdded > 0) {
                    remainingAdded--;
                    spacesBetweenWords[i] += 1;
                }
                spacesBetweenWords[i] += 1 + baseAdded;
            }
        }
        return spacesBetweenWords;
    }

}
