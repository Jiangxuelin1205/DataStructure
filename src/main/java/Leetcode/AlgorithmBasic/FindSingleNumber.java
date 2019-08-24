package Leetcode.AlgorithmBasic;

public class FindSingleNumber {

    private int findSingle(int[] arr) {
        int n = arr.length;
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result ^= arr[i];
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 4, 5, 4, 8, 0, 8, 0};
        FindSingleNumber f=new FindSingleNumber();
        System.out.println(f.findSingle(arr));
    }
}
