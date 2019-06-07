package SortingBasic;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public List<Integer> heapSort(int[] arr) {
        /*
         * 建立最大堆
         * */
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            shiftUp(arr, i, length);
        }


        List<Integer> result = new ArrayList<>();
        for (int j = length - 1; j >= 0; j--) {
            swap(arr, 0, j);
            result.add(arr[j]);
            shiftDown(arr, j);
        }
        return result;
    }

    private void shiftDown(int[] arr, int length) {
        shiftUp(arr,0,length);
    }

    private void shiftUp(int[] arr, int i, int length) {
        int tmpIdx = i;
        int k = tmpIdx * 2 + 1;
        while (k < length) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k = k + 1;
            }
            if (arr[k] > arr[tmpIdx]) {
                swap(arr, k, tmpIdx);
                tmpIdx = k;
                k = k * 2 + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
