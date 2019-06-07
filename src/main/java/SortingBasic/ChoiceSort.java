package SortingBasic;

public class ChoiceSort {
    public void choiceSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIdx=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[minIdx]){
                    minIdx=j;
                }
            }
            swap(arr,minIdx,i);
        }
    }

    private void swap(int[] arr, int minIdx, int i) {
        int tmp=arr[minIdx];
        arr[minIdx]=arr[i];
        arr[i]=tmp;
    }

}
