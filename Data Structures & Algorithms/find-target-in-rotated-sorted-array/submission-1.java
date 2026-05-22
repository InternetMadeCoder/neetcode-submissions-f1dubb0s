class Solution {
    public int binarySearch(int nums[], int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // returns the index of the smallest element
    public int findPivot(int[] nums, int low, int high) {
        while(low <= high) {
            if(nums[low] <= nums[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;

            if(nums[mid] < nums[high]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int pivot = findPivot(nums, 0, n);

        if(nums[pivot] == target) return pivot;

        if(pivot == 0) {
            return binarySearch(nums, 0, n, target);
        }

        if(nums[0] <= target) {
            return binarySearch(nums, 0, pivot-1, target);
        }
        else {
            return binarySearch(nums, pivot, n, target);
        }
    }
}
