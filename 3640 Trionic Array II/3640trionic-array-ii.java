class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        long ans = Long.MIN_VALUE;

        while (i < n) {
            int l = i;
            // Segment 1: Strictly increasing (l to p)
            i++;
            while (i < n && nums[i - 1] < nums[i]) {
                i++;
            }
            if (i == l + 1) { // Segment 1 must have at least two elements
                continue;
            }
            int p = i - 1;
            long s = (long)nums[p - 1] + nums[p]; // Initialize sum with last two elements of S1

            // Segment 2: Strictly decreasing (p to q)
            while (i < n && nums[i - 1] > nums[i]) {
                s += nums[i];
                i++;
            }
            if (i == p + 1 || i == n || nums[i - 1] == nums[i]) { // Segment 2 must have at least two elements and a valid transition
                continue;
            }
            int q = i - 1;
            s += nums[i]; // Add the first element of S3
            i++;

            // Segment 3: Strictly increasing (q to r) - find max sum suffix
            long mx = 0, t = 0;
            while (i < n && nums[i - 1] < nums[i]) {
                t += nums[i];
                mx = Math.max(mx, t); // Track max sum of any S3 suffix starting from current point
                i++;
            }
            s += mx;

            // Maximize Segment 1 sum by looking backwards from p
            mx = 0;
            t = 0;
            for (int j = p - 2; j >= l; j--) {
                t += nums[j];
                mx = Math.max(mx, t); // Track max sum of any S1 prefix ending at p-1
            }
            s += mx;

            ans = Math.max(ans, s);
            i = q; // Restart search from 'q' for the next potential trionic array
        }

        return ans;
    }
}











