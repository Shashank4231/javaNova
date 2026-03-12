class Solution {
    public boolean checkDivisibility(int n) {
           int sum = 0, product = 1;
           int temp = n;
           while(temp>0){
                int num = temp % 10;
                sum += num;
                product *= num;
                temp /= 10;
           }
           return ( n % (sum+product) == 0);
    }
}