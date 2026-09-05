class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] stable = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            stable[i] = max;
        }

        for (int i = n-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            stable[i] = stable[i] - Math.min(min, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (stable[i] <= k)
                return i;
        }
        return -1;
    }
}