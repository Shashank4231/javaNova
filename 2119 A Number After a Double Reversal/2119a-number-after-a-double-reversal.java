class Solution {
    public static int reverse(int n){
        int temp = n;
        int rev = 0;
        while(temp>0){
            int num = temp % 10;
            rev = (10 * rev) + num;
            temp /= 10;
        }
        return rev;
    }
    public boolean isSameAfterReversals(int num) {
           return num == reverse(reverse(num));
    }
}