class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = (int)mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, long maxSum) {
        int parts = 1;
        long currSum = 0;

        for (int num : nums) {
            if (currSum + num > maxSum) {
                parts++;
                currSum = num;

                if (parts > k) return false;
            } else {
                currSum += num;
            }
        }

        return true;
    }
}