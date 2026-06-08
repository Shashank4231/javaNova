class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] tarr = new int[26];
        int[] sarr = new int[26];
        for(int i=0;i<s.length();i++){
            sarr[s.charAt(i) - 'a']++;
            tarr[t.charAt(i) - 'a']++;
        }
        for(int i=0;i<tarr.length;i++){
            if(tarr[i] != sarr[i]) return false;
        }
        return true;
    }
}