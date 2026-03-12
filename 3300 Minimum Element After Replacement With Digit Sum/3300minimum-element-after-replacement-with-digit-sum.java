class Solution {
    public int minElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int sum = 0;
            while (temp > 0) {
                int num = temp % 10;
                sum += num;
                temp /= 10;
            }
            nums[i] = sum;
        }
        Arrays.sort(nums);
        return nums[0];
    }
}