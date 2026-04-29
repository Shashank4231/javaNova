class Solution {
    public char findTheDifference(String s, String t) {
        s = s + t;
        char diff = s.charAt(0);
        for(int i=1;i<s.length();i++){
            diff = (char)(diff^(s.charAt(i)));
        }
        return diff;
    }
}