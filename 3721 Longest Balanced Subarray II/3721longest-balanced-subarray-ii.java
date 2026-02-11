import java.util.*;

class Solution {
    // Segment tree stores the min and max balance in a range to skip irrelevant branches
    int[] minTree, maxTree, lazy;

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        minTree = new int[4 * n];
        maxTree = new int[4 * n];
        lazy = new int[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        int[] prevPos = new int[n];
        for (int i = 0; i < n; i++) {
            prevPos[i] = lastSeen.getOrDefault(nums[i], -1);
            lastSeen.put(nums[i], i);
        }

        int maxLen = 0;
        for (int r = 0; r < n; r++) {
            int delta = (nums[r] % 2 == 0) ? 1 : -1;
            update(1, 0, n - 1, prevPos[r] + 1, r, delta);

            // We look for the leftmost index i such that balance == 0
            int leftmost = findLeftmost(1, 0, n - 1, 0, r, 0);
            if (leftmost != -1) {
                maxLen = Math.max(maxLen, r - leftmost + 1);
            }
        }
        return maxLen;
    }

    private void push(int v) {
        if (lazy[v] != 0) {
            minTree[2 * v] += lazy[v];
            maxTree[2 * v] += lazy[v];
            lazy[2 * v] += lazy[v];
            minTree[2 * v + 1] += lazy[v];
            maxTree[2 * v + 1] += lazy[v];
            lazy[2 * v + 1] += lazy[v];
            lazy[v] = 0;
        }
    }

    private void update(int v, int tl, int tr, int l, int r, int add) {
        if (l > r) return;
        if (l == tl && r == tr) {
            minTree[v] += add;
            maxTree[v] += add;
            lazy[v] += add;
        } else {
            push(v);
            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, Math.min(r, tm), add);
            update(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r, add);
            minTree[v] = Math.min(minTree[2 * v], minTree[2 * v + 1]);
            maxTree[v] = Math.max(maxTree[2 * v], maxTree[2 * v + 1]);
        }
    }

    private int findLeftmost(int v, int tl, int tr, int l, int r, int target) {
        // If the target value isn't within the min/max range of this node, skip it
        if (l > r || target < minTree[v] || target > maxTree[v]) return -1;
        if (tl == tr) return tl;

        push(v);
        int tm = (tl + tr) / 2;
        // Check left child first to ensure we find the "leftmost" (longest)
        int res = findLeftmost(2 * v, tl, tm, l, Math.min(r, tm), target);
        if (res == -1) {
            res = findLeftmost(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r, target);
        }
        return res;
    }
}