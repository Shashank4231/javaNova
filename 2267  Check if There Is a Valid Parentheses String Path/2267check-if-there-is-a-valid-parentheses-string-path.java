class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        if (grid[0][0] == ')') {
            return false;
        }

        Set<Integer>[] dp = new HashSet[n];

        for (int j = 0; j < n; j++) {
            dp[j] = new HashSet<>();
        }

        dp[0].add(1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                Set<Integer> current = new HashSet<>();

                if (i > 0) {
                    current.addAll(dp[j]);
                }
                if (j > 0) {
                    current.addAll(dp[j - 1]);
                }

                dp[j].clear();

                int change = grid[i][j] == '(' ? 1 : -1;

                for (int balance : current) {
                    int newBalance = balance + change;

                    if (newBalance >= 0) {
                        dp[j].add(newBalance);
                    }
                }

                if (dp[j].isEmpty()) {
                    continue;
                }
            }
        }

        return dp[n - 1].contains(0);
    }
}
