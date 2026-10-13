class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] a = new long[nums.length];

        for (int i = 0; i < nums.length; i++)
            a[i] = Math.abs((long) nums[i]);

        Arrays.sort(a);

        long sum = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            long square = a[i] * a[i];

            if (i < n / 2)
                sum -= square;
            else
                sum += square;
        }

        return sum;
    }
}