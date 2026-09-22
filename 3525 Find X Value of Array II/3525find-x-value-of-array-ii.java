class Solution {
    static class Node {
        long[] cnt;
        int prod;
        Node(int k) {
            cnt = new long[k];
        }
    }

    int k;
    Node[] tree;
    int n;

    private Node merge(Node left, Node right) {
        Node res = new Node(k);
        for (int r = 0; r < k; r++) {
            res.cnt[r] += left.cnt[r];
        }
        for (int r = 0; r < k; r++) {
            if (right.cnt[r] != 0) {
                int nr = (int) ((long) left.prod * r % k);
                res.cnt[nr] += right.cnt[r];
            }
        }

        res.prod = (int) ((long) left.prod * right.prod % k);
        return res;
    }

    private Node leaf(int value) {
        Node node = new Node(k);

        int rem = value % k;
        node.prod = rem;
        node.cnt[rem] = 1;

        return node;
    }

    private void build(int idx, int l, int r, int[] nums) {
        if (l == r) {
            tree[idx] = leaf(nums[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(idx * 2, l, mid, nums);
        build(idx * 2 + 1, mid + 1, r, nums);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private void update(int idx, int l, int r, int pos, int value) {
        if (l == r) {
            tree[idx] = leaf(value);
            return;
        }

        int mid = l + (r - l) / 2;

        if (pos <= mid) {
            update(idx * 2, l, mid, pos, value);
        } else {
            update(idx * 2 + 1, mid + 1, r, pos, value);
        }

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private Node query(int idx, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[idx];
        }

        int mid = l + (r - l) / 2;

        if (qr <= mid) {
            return query(idx * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(idx * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(idx * 2, l, mid, ql, qr);
        Node right = query(idx * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int index = queries[qi][0];
            int value = queries[qi][1];
            int start = queries[qi][2];
            int x = queries[qi][3];

            nums[index] = value;
            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[qi] = (int) res.cnt[x];
        }

        return ans;
    }
}
