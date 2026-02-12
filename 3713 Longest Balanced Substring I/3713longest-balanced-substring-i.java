public class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        
        // Find how many unique characters exist in the string total
        int totalDistinct = 0;
        boolean[] exists = new boolean[26];
        for (char c : s.toCharArray()) {
            if (!exists[c - 'a']) {
                exists[c - 'a'] = true;
                totalDistinct++;
            }
        }

        // k = number of distinct characters in the substring
        for (int k = 1; k <= totalDistinct; k++) {
            // f = frequency of each character
            for (int f = 1; f * k <= n; f++) {
                int windowSize = k * f;
                
                // Only check if this combination could actually beat our current record
                if (windowSize <= maxLen) continue;

                if (check(s, windowSize, k, f)) {
                    maxLen = windowSize;
                }
            }
        }
        return maxLen;
    }

    private boolean check(String s, int windowSize, int k, int f) {
        int[] counts = new int[26];
        int distinctInWindow = 0;
        int satisfiedChars = 0; 

        for (int i = 0; i < s.length(); i++) {
            // Add right character
            int addIdx = s.charAt(i) - 'a';
            if (counts[addIdx] == 0) distinctInWindow++;
            counts[addIdx]++;
            if (counts[addIdx] == f) satisfiedChars++;
            else if (counts[addIdx] == f + 1) satisfiedChars--;

            // Remove left character
            if (i >= windowSize) {
                int remIdx = s.charAt(i - windowSize) - 'a';
                if (counts[remIdx] == f) satisfiedChars--;
                else if (counts[remIdx] == f + 1) satisfiedChars++;
                
                counts[remIdx]--;
                if (counts[remIdx] == 0) distinctInWindow--;
            }

            // If window is full size, check if it's balanced
            if (i >= windowSize - 1) {
                if (distinctInWindow == k && satisfiedChars == k) {
                    return true;
                }
            }
        }
        return false;
    }
}