class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            if (i < n) {
                nge[i] = st.empty() ? -1 : st.peek();
            }
            st.push(nums[i % n]);
        }
        return nge;
    }
}