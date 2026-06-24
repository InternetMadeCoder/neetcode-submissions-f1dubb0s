/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // 1. Find peak index
        int peak = findPeak(mountainArr, n);
        
        // 2. Search in left (ascending)
        int left = binarySearch(mountainArr, 0, peak, target, true);
        if (left != -1) return left;
        
        // 3. Search in right (descending)
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
    }

    private int findPeak(MountainArray arr, int n) {
        int low = 0, high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1; // move right
            } else {
                high = mid; // move left (could be peak)
            }
        }
        
        return low; // peak index
    }

    private int binarySearch(MountainArray arr, int low, int high, int target, boolean isAscending) {
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);
            
            if (val == target) return mid;
            
            if (isAscending) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val > target) low = mid + 1;
                else high = mid - 1;
            }
        }
        
        return -1;
    }
}