class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int middle = 0;
        int end = nums.length - 1;

        while(middle <= end) {
            switch(nums[middle]) {
                case 0:
                    swap(nums, start, middle);
                    start++;
                    middle++;
                    break;
                case 1:
                    middle++;
                    break;
                case 2:
                    swap(nums, end, middle);
                    end--;
                    break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}