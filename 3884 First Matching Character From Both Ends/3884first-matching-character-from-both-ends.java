class Solution {
    public int firstMatchingIndex(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high - low)) {
                return low;
            }
            low++;
        }
        return -1;
    }
}