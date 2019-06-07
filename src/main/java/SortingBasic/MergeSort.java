package SortingBasic;


import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int[] aux, int first, int last) {
        if (first < last) {
            int mid = first + (last - first) / 2;
            mergeSort(arr, aux, first, mid);
            mergeSort(arr, aux, mid + 1, last);
            merge(arr, aux, first, mid, last);
        }
    }

    private void merge(int[] arr, int[] aux, int first, int mid, int last) {
        int i = first, j = mid + 1, k = first;
        while (i <= mid && j <= last) {
            if (arr[i] < arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }
        while (i <= mid && k <= last) {
            aux[k++] = arr[i++];
        }
        while (j <= last && k <= last) {
            aux[k++] = arr[j++];
        }
        for (int start = first; start <= last; start++) {
            arr[start] = aux[start];
        }
        System.out.println("merge is " + Arrays.toString(arr));
    }
}
