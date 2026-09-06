class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        if(n == 1){
            return (k==0)?n:0;
        }

        int currScore = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                currScore++;
            }
        }
        int count = 0;
        if(currScore == k) count++;

        for(int j = 1;j<n;j++){
            if(s.charAt(j-1) == s.charAt(j)){
                currScore--;
            }
            int prev = (j-2+n) % n;
            if(s.charAt(prev) == s.charAt(j-1)) currScore++;
            if(currScore == k) count++;
        }
        return count;
    }
}