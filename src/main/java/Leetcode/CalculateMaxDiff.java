package Leetcode;

public class CalculateMaxDiff {

    int solution(int[] arr) {
        int max_diff = arr[1] - arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max_diff=Math.max(max_diff,arr[i]-min);
            min=Math.min(arr[i],min);
        }
        return max_diff;

    }

    public static void main(String[] args) {
        int[] arr={1,17,8,9,0,3,19,2,7};
        CalculateMaxDiff c=new CalculateMaxDiff();
        System.out.println(c.solution(arr));
    }
}
