package SortingBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大堆的建立过程
 */
public class HeapSort {

     public List<Integer> heapSort(int[] arr) {
         int length = arr.length;
         for (int current = arr.length / 2 - 1; current >= 0; current--) {
             shiftDown(arr, current,arr.length);
         }

         List<Integer> result = new ArrayList<>();
         for (int j = length - 1; j >= 0; j--) {
            swap(arr, 0, j);
            result.add(arr[j]);
            shiftDown(arr, 0,j);
        }
        return result;
    }

    /**
     * 对一个元素进行操作
     */
    private void shiftDown(int[] arr, int current,int length) {
        while (current < length) {
            int leftChild = current * 2 + 1;
            int rightChild = leftChild + 1;
            int smallerIndex = leftChild;
            if (leftChild < length) {
                if (rightChild < length && arr[rightChild] < arr[leftChild]) {
                    smallerIndex = rightChild;
                }
                if (arr[current] > arr[smallerIndex]) {
                    swap(arr, current, smallerIndex);
                }
            }
            current = smallerIndex;
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
