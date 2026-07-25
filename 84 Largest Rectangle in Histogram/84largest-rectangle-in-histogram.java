class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for(int i=0;i<heights.length;i++){
            while(!st.empty() && heights[st.peek()] > heights[i]){
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.empty()?-1:st.peek();
                area = Math.max(heights[element] * (nse-pse-1) , area);
            }
            st.push(i);
        }
        while(!st.empty()){
            int nse = heights.length;
            int element = st.peek();
            st.pop();
            int pse = st.empty()?-1:st.peek();
            area = Math.max(heights[element] * (nse-pse-1) , area);
        }
        return area;
    }
}