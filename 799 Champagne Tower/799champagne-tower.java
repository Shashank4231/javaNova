class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // Using a 2D array for clarity: dp[row][glass]
        // Given 100 rows, a 102x102 array safely handles overflow into the 101st row
        double[][] tower = new double[102][102];
        
        // Pour everything into the first glass
        tower[0][0] = (double) poured;
        
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                // If the current glass overflows
                if (tower[i][j] > 1.0) {
                    double excess = (tower[i][j] - 1.0) / 2.0;
                    // Split excess to the two glasses below
                    tower[i + 1][j] += excess;
                    tower[i + 1][j + 1] += excess;
                    
                    // Cap the current glass at 1.0
                    tower[i][j] = 1.0;
                }
            }
        }
        
        // Return the fullness of the specific glass (max 1.0)
        return Math.min(1.0, tower[query_row][query_glass]);
    }
}