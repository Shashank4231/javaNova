class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int i = 0;
        int max = -1;
        while (i < s.length()) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    max = Math.max(max, j - i - 1);
                }
            }
            i++;
        }
        return max;
    }
}