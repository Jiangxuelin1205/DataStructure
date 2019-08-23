package Leetcode;

public class FindMinimumIndexDistance {

    int solution(int[] arr, int n1, int n2) {
        int index_n1 = -1;
        int index_n2 = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n1) {
                index_n1 = i;
                if (index_n2 != -1) {
                    distance = Math.min(distance, Math.abs(index_n1 - index_n2));
                }
            }
            if (arr[i] == n2) {
                index_n2 = i;
                if (index_n1 != -1) {
                    distance = Math.min(distance, Math.abs(index_n1 - index_n2));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[] arr={4,5,6,7,4,6,4,7,8};
        FindMinimumIndexDistance f=new FindMinimumIndexDistance();
        System.out.println(f.solution(arr,4,7));
    }
}
