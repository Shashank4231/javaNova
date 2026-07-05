class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = (m * n) - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Map the 1D index back to 2D coordinates
            int midElement = matrix[mid / n][mid % n];
            
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}