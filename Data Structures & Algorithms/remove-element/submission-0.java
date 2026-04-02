class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        // return num of elements which are not equal to val
        int k = 0; 
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}