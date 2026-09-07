class Solution {
    private static boolean isPossible(int[] bloomDay, int m, int k, int val) {
        int cnt = 0, noOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= val)
                cnt++;
            else {
                noOfBouquets += cnt / k;
                cnt = 0;
            }
        }
        noOfBouquets += cnt / k;
        if (noOfBouquets >= m)
            return true;
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m * k > n)
            return -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }
        int low = min, high = max;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}