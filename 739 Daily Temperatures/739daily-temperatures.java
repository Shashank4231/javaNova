class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i=ans.length-1;i>=0;i--){
            while(!st.empty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            ans[i] = st.empty()?0:st.peek()-i;
            st.push(i);
        }
        return ans;
    }
}