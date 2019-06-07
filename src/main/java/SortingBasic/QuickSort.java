package SortingBasic;

public class QuickSort {

    public int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int start, end, key;
        start = low;
        end = high;
        key = arr[low];
        while (start < end) {
            while (arr[end] >= key && start < end) {
                end--;
            }
            while (arr[start] <= key && start < end) {
                start++;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        arr[low] = arr[start];
        arr[start] = key;
        quickSort(arr, low, start - 1);
        quickSort(arr, start + 1, high);
    }

    private void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
