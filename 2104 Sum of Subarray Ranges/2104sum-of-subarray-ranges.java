class Solution {
    private static int[] nse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            ans[i] = st.empty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int[] pse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            ans[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int[] nge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            ans[i] = st.empty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int[] pge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            ans[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static long minimum(int[] arr){
        long sum = 0;
        int[] next = nse(arr);
        int[] prev = pse(arr);
        for(int i=0;i<arr.length;i++){
            int left = i - prev[i];
            int right = next[i] - i;
            sum += (long)right*left*arr[i];
        }
        return sum;
    }

    private static long maximum(int[] arr){
        long sum = 0;
        int[] next = nge(arr);
        int[] prev = pge(arr);
        for(int i=0;i<arr.length;i++){
            int left = i - prev[i];
            int right = next[i] - i;
            sum += (long)right*left*arr[i];
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        return maximum(nums) - minimum(nums);
    }
}