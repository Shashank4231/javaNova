class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digit_sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            int n = nums[i];
            while(n!=0){
                int digit = n % 10;
                digit_sum += digit;
                n /= 10;
            }
        }
        return Math.abs(sum - digit_sum);
    }
}