class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int x = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            x += nums[i];
            if (x == 0)
                count++;
        }
        return count;
    }
}