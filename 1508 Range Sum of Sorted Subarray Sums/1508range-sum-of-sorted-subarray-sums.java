import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new long[]{nums[i], i, i});
        }

        long res = 0;

        for (int k = 1; k <= right; k++) {
            long[] cur = pq.poll();
            long sum = cur[0];
            int start = (int)cur[1];
            int end = (int)cur[2];

            if (k >= left) {
                res = (res + sum) % MOD;
            }

            if (end + 1 < n) {
                long newSum = sum + nums[end + 1];
                pq.offer(new long[]{newSum, start, end + 1});
            }
        }

        return (int)res;
    }
}