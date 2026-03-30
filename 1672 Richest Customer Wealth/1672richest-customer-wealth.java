class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i < m) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
            i++;
        }
        return max;
    }
}