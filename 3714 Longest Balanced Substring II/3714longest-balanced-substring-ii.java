import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int maxLen = 0;

        // 1. Case: Substrings with exactly 1 distinct character
        int run = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) run++;
            else {
                maxLen = Math.max(maxLen, run);
                run = 1;
            }
        }
        maxLen = Math.max(maxLen, run);

        // 2. Case: Substrings with exactly 2 distinct characters (e.g., 'b' and 'c' in "abcbc")
        // We look for balanced (b, c) in regions where 'a' doesn't exist.
        maxLen = Math.max(maxLen, solvePairs(arr, 'a', 'b', 'c')); // Pair (b,c), prohibited 'a'
        maxLen = Math.max(maxLen, solvePairs(arr, 'b', 'a', 'c')); // Pair (a,c), prohibited 'b'
        maxLen = Math.max(maxLen, solvePairs(arr, 'c', 'a', 'b')); // Pair (a,b), prohibited 'c'

        // 3. Case: Substrings with exactly 3 distinct characters
        maxLen = Math.max(maxLen, solveTrio(arr));

        return maxLen;
    }

    private int solvePairs(char[] arr, char prohibited, char c1, char c2) {
        int max = 0;
        int n = arr.length;
        // Map stores the first occurrence of (count(c1) - count(c2))
        // Using an array for O(1) lookups instead of HashMap
        int[] firstSeen = new int[2 * n + 1];
        Arrays.fill(firstSeen, -2);
        
        int diff = 0;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == prohibited) {
                // Reset everything when prohibited char is seen
                diff = 0;
                start = i + 1;
            } else {
                if (arr[i] == c1) diff++;
                else if (arr[i] == c2) diff--;
                
                // If we've seen this difference since the last 'start'
                int mapIdx = diff + n;
                
                // Base case for the start of a clean segment
                if (diff == 0) {
                    max = Math.max(max, i - (start - 1));
                }

                if (firstSeen[mapIdx] >= start) {
                    max = Math.max(max, i - firstSeen[mapIdx]);
                } else {
                    firstSeen[mapIdx] = i;
                }
            }
        }
        return max;
    }

    private int solveTrio(char[] arr) {
        int n = arr.length;
        int max = 0;
        // For 3 characters, we need to track (count(a)-count(b)) and (count(b)-count(c))
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'a') a++;
            else if (arr[i] == 'b') b++;
            else c++;
            
            // Pack two differences into a single long key
            long d1 = a - b;
            long d2 = b - c;
            long key = (d1 << 32) | (d2 & 0xFFFFFFFFL);
            
            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}