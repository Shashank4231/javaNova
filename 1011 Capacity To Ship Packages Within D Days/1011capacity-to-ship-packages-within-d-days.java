class Solution {
    private static boolean isPossible(int[] weights, int days, int mid) {
        int day = 1, load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > mid) {
                day = day + 1;
                load = weights[i];
            } else
                load += weights[i];
        }

        return (day <= days);
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max, high = sum;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}