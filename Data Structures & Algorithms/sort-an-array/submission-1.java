class Solution {
    public void merge(int[] nums, int start, int end, int mid) { 
        // size of arr1 and arr2
        int n1 = mid - start + 1;
        int n2 = end - mid; // end-(mid+1)+1

        // create two arrays
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i=0; i<n1; i++) {
            arr1[i] = nums[start + i];
        }
        for(int i=0; i<n2; i++) {
            arr2[i] = nums[mid+1+i];
        }

        // two pointers
        int i=0; // pointer for arr1
        int j=0; // pointer for arr2
        int k=start; // pointer for nums
        
        while(i<n1 && j<n2) {
            if(arr1[i] <= arr2[j]) {
                nums[k] = arr1[i];
                i++;
            }
            else {
                nums[k] = arr2[j];
                j++;
            }
            k++;
        }

        // if still ele left, copy pending elements
        while(i < n1) {
            nums[k] = arr1[i];
            i++; 
            k++;
        }
        while(j < n2) {
            nums[k] = arr2[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] nums, int start, int end) {
        if(start < end) {
            int mid = start + (end-start)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, end, mid);
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}