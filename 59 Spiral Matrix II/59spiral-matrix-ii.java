class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                mat[top][i] = num;
                num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num;
                num++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                mat[bottom][i] = num;
                num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                mat[i][left] = num;
                num++;
            }
            left++;
        }
        return mat;
    }
}