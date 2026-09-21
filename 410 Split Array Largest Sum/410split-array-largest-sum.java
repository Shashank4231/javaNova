class Solution {
    private static int subarray(int[] nums, int val) {
        int students = 1;
        long pages = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pages + nums[i] <= val) {
                pages += nums[i];
            } else {
                students += 1;
                pages = nums[i];
            }
        }
        return students;
    }

    public int splitArray(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = subarray(nums, mid);
            if (students > k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}