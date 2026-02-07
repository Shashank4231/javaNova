class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int deletions = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'b') {
                bCount++;
            } else { // c == 'a'
                deletions = Math.min(deletions + 1, bCount);
            }
        }

        return deletions;
    }
}
