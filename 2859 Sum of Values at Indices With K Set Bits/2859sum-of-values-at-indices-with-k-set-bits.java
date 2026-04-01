class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int temp = i;
            int count = 0;
            while (temp > 0) {
                temp &= (temp - 1);
                count++;
            }
            if (count == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }
}