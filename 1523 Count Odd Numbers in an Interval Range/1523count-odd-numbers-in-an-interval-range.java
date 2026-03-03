class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        while (low <= high) {
            if ((low & 1) == 1) {
                count++;
            }
            low++;
        }
        return count;
    }
}