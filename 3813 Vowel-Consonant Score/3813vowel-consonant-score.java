class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                    v++;
                } else {
                    c++;
                }
            }
        }

        return c > 0 ? v / c : 0;
    }
}