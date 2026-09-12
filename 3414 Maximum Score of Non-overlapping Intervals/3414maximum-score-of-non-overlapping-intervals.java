class Solution {

    static class Result {
        long score;
        int[] indices;

        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[3], b[3]);
        });

        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i][0];
        }

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = upperBound(starts, arr[i][1]);
        }

        Result[][] dp = new Result[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new Result(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = new Result(0, new int[0]);

            for (int k = 1; k <= 4; k++) {
                Result skip = dp[i + 1][k];
                Result nextResult = dp[next[i]][k - 1];

                int[] indices = new int[nextResult.indices.length + 1];

                indices[0] = arr[i][3];

                System.arraycopy(
                        nextResult.indices,
                        0,
                        indices,
                        1,
                        nextResult.indices.length);

                Arrays.sort(indices);

                Result take = new Result(
                        arr[i][2] + nextResult.score,
                        indices);

                dp[i][k] = better(skip, take);
            }
        }

        return dp[0][4].indices;
    }

    private int upperBound(int[] a, int value) {
        int lo = 0;
        int hi = a.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] <= value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private Result better(Result a, Result b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return compare(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compare(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }
}
