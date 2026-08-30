class Solution {
    public int minimumDeletions(int[] nums) {
        int minIndex = 0, maxIndex = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex])
                minIndex = i;
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        int min = Math.min(minIndex, maxIndex);
        int max = Math.max(minIndex, maxIndex);

        int fromFront = max + 1;
        int fromBack = n - min;
        int frontBack = (min + 1) + (n - max);

        return Math.min(fromFront, Math.min(fromBack, frontBack));
    }
}