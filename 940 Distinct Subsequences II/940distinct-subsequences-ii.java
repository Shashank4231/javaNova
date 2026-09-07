class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007L;
        long total = 1;
        long[] last = new long[26];

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            long newCount = (total - last[c] + MOD) % MOD;

            last[c] = (last[c] + newCount) % MOD;
            total = (total + newCount) % MOD;
        }

        return (int) ((total - 1 + MOD) % MOD);
    }
}
