class Solution {
    public int maxDepth(String s) {
        int cnt_left = 0, cnt_right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                cnt_left++;
            else if (s.charAt(i) == ')')
                cnt_right++;
            max = Math.max(max, cnt_left - cnt_right);
        }
        return max;
    }
}