package Leetcode;

public class CalculateMaxRecursively {
    int solution(int[] arr){
        int max=Integer.MIN_VALUE;
        return solution(arr,0,max);
    }
    private int solution(int[] arr, int i, int max){
        if(i==arr.length){
            return max;
        }
        if(arr[i]>max){
            max=arr[i];

        }
        return solution(arr,i+1,max);
    }

    public static void main(String[] args) {
        CalculateMaxRecursively c=new CalculateMaxRecursively();
        int[] arr={6,7,2,9,0,4,0};
        System.out.println(c.solution(arr));
    }
}
