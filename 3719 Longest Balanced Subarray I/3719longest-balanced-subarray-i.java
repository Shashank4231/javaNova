import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestBalanced(int[] nums) {
        int maxLength = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenSet.add(nums[j]);
                } else {
                    oddSet.add(nums[j]);
                }

                if (evenSet.size() == oddSet.size()) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}


