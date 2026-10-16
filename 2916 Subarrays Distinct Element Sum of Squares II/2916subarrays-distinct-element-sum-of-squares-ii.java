

class Solution {
    private static final int MOD = 1_000_000_007;

    private static class Node {
        long sum = 0;
        long sqSum = 0;
        long lazy = 0;
    }

    private Node[] tree;

    private void push(int node, int start, int end) {
        if (tree[node].lazy == 0) return;

        long lz = tree[node].lazy;
        int mid = start + (end - start) / 2;

        // Left child
        int left = 2 * node;
        long lenL = mid - start + 1;
        tree[left].sqSum = (tree[left].sqSum + 2 * lz % MOD * tree[left].sum % MOD + lz * lz % MOD * lenL % MOD) % MOD;
        tree[left].sum = (tree[left].sum + lz * lenL) % MOD;
        tree[left].lazy = (tree[left].lazy + lz) % MOD;

        // Right child
        int right = 2 * node + 1;
        long lenR = end - mid;
        tree[right].sqSum = (tree[right].sqSum + 2 * lz % MOD * tree[right].sum % MOD + lz * lz % MOD * lenR % MOD) % MOD;
        tree[right].sum = (tree[right].sum + lz * lenR) % MOD;
        tree[right].lazy = (tree[right].lazy + lz) % MOD;

        tree[node].lazy = 0;
    }

    private void update(int node, int start, int end, int l, int r, long val) {
        if (r < start || end < l) return;
        if (l <= start && end <= r) {
            long len = end - start + 1;
            tree[node].sqSum = (tree[node].sqSum + 2 * val % MOD * tree[node].sum % MOD + val * val % MOD * len % MOD) % MOD;
            tree[node].sum = (tree[node].sum + val * len) % MOD;
            tree[node].lazy = (tree[node].lazy + val) % MOD;
            return;
        }

        push(node, start, end);
        int mid = start + (end - start) / 2;
        update(2 * node, start, mid, l, r, val);
        update(2 * node + 1, mid + 1, end, l, r, val);

        tree[node].sum = (tree[2 * node].sum + tree[2 * node + 1].sum) % MOD;
        tree[node].sqSum = (tree[2 * node].sqSum + tree[2 * node + 1].sqSum) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node();
        }

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalAns = 0;

        for (int j = 0; j < n; j++) {
            int prev = lastSeen.getOrDefault(nums[j], -1);

            // Add +1 in range [prev + 1, j]
            update(1, 0, n - 1, prev + 1, j, 1);

            totalAns = (totalAns + tree[1].sqSum) % MOD;
            lastSeen.put(nums[j], j);
        }

        return (int) totalAns;
    }
}
