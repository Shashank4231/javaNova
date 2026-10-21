class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;
     
        if (n == 2) return -1;

        char mn = s.charAt(0);
        char mx = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }

        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }
        
        return 3;
    }
}

