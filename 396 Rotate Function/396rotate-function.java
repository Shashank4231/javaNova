class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, f = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            f += (i * nums[i]);
        }
        
        int max = f;  
        
        for (int i = 1; i < nums.length; i++) {
            int f_new = f + sum - (nums.length * nums[nums.length - i]);
            max = Math.max(max, f_new);
            f = f_new;
        }
        
        return max;
    }
}