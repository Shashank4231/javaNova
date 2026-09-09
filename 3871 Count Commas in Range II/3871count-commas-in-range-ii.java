class Solution {
    public long countCommas(long n) {
        long total = 0;

        if (n >= 1_000)
            total += n - 999;

        if (n >= 1_000_000)
            total += n - 999_999;

        if (n >= 1_000_000_000)
            total += n - 999_999_999;

        if (n >= 1_000_000_000_000L)
            total += n - 999_999_999_999L;

        if (n >= 1_000_000_000_000_000L)
            total += n - 999_999_999_999_999L;

        return total;
    }
}
