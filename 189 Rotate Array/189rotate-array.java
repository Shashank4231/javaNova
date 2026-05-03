class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Normalize k in case it's greater than the length of the array
        k = k % n;
        
        // Reverse the entire array
        reverse(nums, 0, n - 1);
        
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Reverse the remaining n - k elements
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}