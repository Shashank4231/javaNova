class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        boolean isIncreasing = true;
        for (int i = 1; i < n; i++) {
            int prev = (zero + i - 1) % n;
            int curr = (zero + i) % n;
            if (nums[prev] > nums[curr]) {
                isIncreasing = false;
                break;
            }
        }

       
        boolean isDecreasing = true;
        for (int i = 1; i < n; i++) {
            int prev = (zero - (i - 1) + n) % n;
            int curr = (zero - i + n) % n;
            if (nums[prev] > nums[curr]) {
                isDecreasing = false;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (isIncreasing) {
            
            ans = Math.min(ans, zero);
           
            ans = Math.min(ans, n - zero + 2);
        }

        if (isDecreasing) {
         
            ans = Math.min(ans, zero + 2);
            
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
