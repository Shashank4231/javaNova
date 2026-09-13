class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int dr = -(n - 1); dr <= n - 1; dr++) {
            for (int dc = -(n - 1); dc <= n - 1; dc++) {

                int overlap = 0;

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {

                        int newR = r + dr;
                        int newC = c + dc;

                        if (newR >= 0 && newR < n &&
                                newC >= 0 && newC < n) {

                            if (img1[r][c] == 1 && img2[newR][newC] == 1) {
                                overlap++;
                            }
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}
