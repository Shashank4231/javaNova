class Solution {
    public boolean isPalindrome(int x) {
           if(x>=0){
            int temp = x;
            int rev = 0;
            while(temp!=0){
             rev = (10 * rev) + temp % 10;
                temp /= 10;
            }
            return (rev == x);
           }
           return false;
    }
}