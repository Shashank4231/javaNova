class Solution {
    public String reversePrefix(String s, int k) {
        String temp = "";
        for (int i = k - 1; i >= 0; i--) {
            temp += s.charAt(i);
        }
        return (temp + s.substring(k, s.length()));
    }
}