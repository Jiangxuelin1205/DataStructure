package Leetcode.AlgorithmBasic;

import java.util.ArrayList;
import java.util.List;

public class PrintAllCharCompsition {
    //使用位图
    private List<String> solution(char[] s) {
        int length = s.length;
        int n = 1 << length;//迭代的次数
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder current = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0) {
                    current.append(s[j]);
                }
            }
            result.add(new String(current));
        }
        return result;
    }

    public static void main(String[] args) {
        PrintAllCharCompsition p=new PrintAllCharCompsition();
        String s="abc";
        System.out.println(p.solution(s.toCharArray()));
    }
}
