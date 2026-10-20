class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevLast = Integer.MIN_VALUE;

            for (int i = 0; i < n && valid; i += k) {
                int descents = 0;
                int descentPos = -1;

                for (int j = 0; j < k; j++) {
                    int cur = nums[i + j];
                    int next = nums[i + (j + 1) % k];

                    if (cur > next) {
                        descents++;
                        descentPos = j;
                    }
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                int start = (descentPos + 1) % k;
                int first = nums[i + start];
                int last = nums[i + (start + k - 1) % k];

                if (first < prevLast) {
                    valid = false;
                    break;
                }

                prevLast = last;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}