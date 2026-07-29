class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for (int i = ans.length - 1; i >= 0; i--) {
            while (!st.empty() && prices[i] < st.peek()) {
                st.pop();
            }
            ans[i] = prices[i] - (st.empty() ? 0 : st.peek());
            st.push(prices[i]);
        }
        return ans;
    }
}