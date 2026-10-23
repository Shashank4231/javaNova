class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                k |= nums[i];
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }

        return ans == -1 ? 0 : ans;
    }
}