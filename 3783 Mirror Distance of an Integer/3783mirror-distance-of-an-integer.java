class Solution {
    public int mirrorDistance(int n) {
           int reverse = 0;
           int temp = n;
           while(temp>0){
            int num = temp % 10;
            reverse = (10 * reverse) + num;
            temp /= 10;
           }
           return Math.abs(n - reverse);
    }
}