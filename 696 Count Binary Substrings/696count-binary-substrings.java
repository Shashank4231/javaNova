public class Solution {
    public int countBinarySubstrings(String s) {
        int totalCount = 0;
        int prevGroupLength = 0;
        int currGroupLength = 1;

        // Iterate starting from the second character
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // We are still in the same group of 0s or 1s
                currGroupLength++;
            } else {
                // Group changed! 
                // Add the minimum of the two adjacent groups to our result
                totalCount += Math.min(prevGroupLength, currGroupLength);
                
                // Move current group to previous, and reset current
                prevGroupLength = currGroupLength;
                currGroupLength = 1;
            }
        }
        
        // Final check for the last two groups after the loop ends
        return totalCount + Math.min(prevGroupLength, currGroupLength);
    }
}