class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = Math.min(nums[0], nums[nums.length - 1]);
        while (min > 0) {
            if (nums[0] % min == 0 && nums[nums.length - 1] % min == 0) {
                return min;
            }
            min--;
        }
        return 1;
    }
}