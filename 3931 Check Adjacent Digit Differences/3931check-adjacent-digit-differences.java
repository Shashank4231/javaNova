class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int i = 0 , j = 1;
        while(j<s.length()){
            if(Math.abs(s.charAt(i) - s.charAt(j)) > 2) return false;
            i++;
            j++;
        }
        return true;
    }
}