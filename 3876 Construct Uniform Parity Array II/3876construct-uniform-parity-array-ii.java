class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        boolean hasEven = false;

        for (int num : nums1) {
            if ((num & 1) == 0) {
                hasEven = true;
            } else {
                minOdd = Math.min(minOdd, num);
            }
        }

        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        for (int num : nums1) {
            if ((num & 1) == 0 && num <= minOdd) {
                return false;
            }
        }

        return true;
    }
}