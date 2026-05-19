class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int rowIdx = searchPotentialRow(matrix, target);
       if(rowIdx != -1) return binarySearchOverRow(rowIdx, matrix, target);
       return false;
    }

    public int searchPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1]) {
                return mid;
            }
            if(matrix[mid][0] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        int low = 0;
        int high = matrix[0].length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(matrix[rowIdx][mid] == target) return true;
            if(matrix[rowIdx][low] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
