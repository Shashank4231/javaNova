class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n / 2;

        long total = 0;
        for (int num : nums) {
            total += num;
        }
        long halfSum = 0;
        for (int i = 0; i < half; i++) {
            halfSum += nums[i];
        }

        int good = 0;
        for (int i = 0; i < n; i++) {
            if (2 * halfSum > total) {
                good++;
            }
            halfSum -= nums[i];
            halfSum += nums[(i + half) % n];
        }
        return good;

    }
}