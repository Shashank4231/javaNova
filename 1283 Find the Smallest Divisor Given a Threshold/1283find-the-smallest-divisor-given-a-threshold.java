class Solution {
    private static boolean isPossible(int[] nums, int threshold, int val) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] % val == 0) ? nums[i] / val : (nums[i] / val) + 1;
        }
        return (sum <= threshold);
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int low = 1, high = max;
        int ans = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}