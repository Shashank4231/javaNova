class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] hash = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hash[grid[i][j]]++;
            }
        }
        int repeating = -1, missing = -1;
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2)
                repeating = i;
            else if (hash[i] == 0)
                missing = i;

            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        return new int[] { repeating, missing };
    }
}