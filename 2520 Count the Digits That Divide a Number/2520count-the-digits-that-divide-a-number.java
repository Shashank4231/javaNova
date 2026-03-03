class Solution {
    public int countDigits(int num) {
        int count = 0;
        int n = num;
        while (n > 0) {
            int val = n % 10;
            if ((num % val) == 0) {
                count++;
            }
            n/=10;
        }
        return count;
    }
}