class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int sum = 0, max = 0;
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            max = Math.max(sum, max);
        }
        return max;
    }
}