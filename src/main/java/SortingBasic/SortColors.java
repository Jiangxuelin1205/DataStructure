package SortingBasic;

public class SortColors {
    /*
    * Given an array with n objects colored red,
    * white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
       Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    * */
    public void sortColors(int[] nums) {
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                i++;
                left++;
            }else if(nums[i]==1){
                i++;
            }else {
                swap(nums,i,right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
