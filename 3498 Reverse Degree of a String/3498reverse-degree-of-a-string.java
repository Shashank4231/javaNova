class Solution {
    public int reverseDegree(String s) {
        int reverseDegree = 0;
        for(int i=0;i<s.length();i++){
            reverseDegree += ('a' -s.charAt(i) + 26)*(i+1);
        }
        return reverseDegree;
    }
}