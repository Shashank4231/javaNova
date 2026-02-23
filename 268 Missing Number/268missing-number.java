class Solution {
    public int missingNumber(int[] nums) {
        int a = nums.length;
        int c = a+1;
        int d = c*a;
        int total = d/2;
        int sum = 0;
        for(int i=0;i<=nums.length-1;i++){
            sum = sum + nums[i];
        }
        return (total-sum);
    }
}