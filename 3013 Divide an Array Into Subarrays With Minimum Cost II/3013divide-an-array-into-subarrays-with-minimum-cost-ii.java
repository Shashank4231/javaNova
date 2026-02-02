import java.util.*;

class Solution {
    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();
    long sumLow = 0;
    int lowSize = 0;
    int need;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        if (k == 1) return nums[0];

        if (k == 2) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) min = Math.min(min, nums[i]);
            return nums[0] + min;
        }

        need = k - 2;

        // initial window [2 .. dist+1]
        for (int i = 2; i <= dist + 1 && i < n; i++) {
            add(nums[i]);
        }

        long ans = Long.MAX_VALUE;

        for (int i1 = 1; i1 < n; i1++) {
            if (lowSize == need) {
                ans = Math.min(ans, nums[0] + nums[i1] + sumLow);
            }

            if (i1 + 1 < n) remove(nums[i1 + 1]);
            if (i1 + dist + 1 < n) add(nums[i1 + dist + 1]);
        }

        return ans;
    }

    /* ---------- helpers ---------- */

    void add(int x) {
        if (lowSize < need) {
            insert(low, x);
            sumLow += x;
            lowSize++;
        } else if (!low.isEmpty() && x < low.lastKey()) {
            int y = low.lastKey();
            erase(low, y);
            sumLow -= y;
            lowSize--;

            insert(high, y);
            insert(low, x);
            sumLow += x;
            lowSize++;
        } else {
            insert(high, x);
        }
        rebalance();
    }

    void remove(int x) {
        if (low.containsKey(x)) {
            erase(low, x);
            sumLow -= x;
            lowSize--;
        } else {
            erase(high, x);
        }
        rebalance();
    }

    void rebalance() {
        while (lowSize < need && !high.isEmpty()) {
            int x = high.firstKey();
            erase(high, x);
            insert(low, x);
            sumLow += x;
            lowSize++;
        }

        while (lowSize > need) {
            int x = low.lastKey();
            erase(low, x);
            sumLow -= x;
            lowSize--;
            insert(high, x);
        }
    }

    void insert(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    void erase(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) map.remove(x);
    }
}




