class Solution {
    public int countCommas(int n) {
        int total = 0;

        if (n >= 1000) {
            total += n - 999;
        }

        if (n >= 1_000_000) {
            total += n - 999_999;
        }

        if (n >= 1_000_000_000) {
            total += n - 999_999_999;
        }

        return total;
    }
}
